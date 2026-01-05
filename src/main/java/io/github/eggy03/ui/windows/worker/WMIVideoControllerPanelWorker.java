package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.display.Win32VideoController;
import io.github.eggy03.ferrumx.windows.service.display.Win32VideoControllerService;
import io.github.eggy03.ui.common.utilities.IconImageChooser;
import io.github.eggy03.ui.windows.utilities.WMIDateUtility;
import io.github.eggy03.ui.windows.utilities.WMISizeUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
public class WMIVideoControllerPanelWorker extends SwingWorker<List<Win32VideoController>, Void> {

    private final JComboBox<String> gpuDeviceIdComboBox;
    private final List<JTextField> gpuFields;

    @Override
    protected List<Win32VideoController> doInBackground() {
        return new Win32VideoControllerService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<Win32VideoController> videoControllerList = get();
            if (videoControllerList.isEmpty()) {
                log.info("No entries for Win32VideoController were found");
                return;
            }
            log.info("Found {} Win32VideoController entry/entries", videoControllerList.size());

            // fill video controller IDs in the combo box
            videoControllerList.forEach(v -> gpuDeviceIdComboBox.addItem(v.getDeviceId()));
            // populate fields for the first entry in the combo box
            populateFields(videoControllerList);
            // add a listener to the combo box to re-populate fields on new selection
            gpuDeviceIdComboBox.addActionListener(selectEvent -> populateFields(videoControllerList));

        } catch (InterruptedException e) {
            log.error("Video Controller Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Video Controller Fetch Failed", e);
        }
    }

    private void populateFields(List<Win32VideoController> videoControllerList) {

        String gpuDeviceId = String.valueOf(gpuDeviceIdComboBox.getSelectedItem());
        Optional<Win32VideoController> optionalGpu = videoControllerList
                .stream()
                .filter(v -> v.getDeviceId() != null && v.getDeviceId().equals(gpuDeviceId))
                .findFirst();

        if (optionalGpu.isEmpty())
            return;

        Win32VideoController gpu = optionalGpu.get();
        gpuFields.get(0).setText(gpu.getName());
        gpuFields.get(1).setText(gpu.getPnpDeviceId());
        gpuFields.get(2).setText(gpu.getCurrentHorizontalResolution() + " px");
        gpuFields.get(3).setText(gpu.getCurrentVerticalResolution() + " px");
        gpuFields.get(4).setText(gpu.getCurrentBitsPerPixel() + " bit");
        gpuFields.get(5).setText(gpu.getMinRefreshRate() + " Hz");
        gpuFields.get(6).setText(gpu.getMaxRefreshRate() + " Hz");
        gpuFields.get(7).setText(gpu.getCurrentRefreshRate() + " Hz");
        gpuFields.get(8).setText(gpu.getAdapterDacType());
        gpuFields.get(9).setText(WMISizeUtility.parseToGBString(gpu.getAdapterRam()));
        gpuFields.get(10).setText(gpu.getDriverVersion());
        gpuFields.get(11).setText(WMIDateUtility.toLocalDateTime(gpu.getDriverDate()));
        gpuFields.get(12).setText(gpu.getVideoProcessor());
    }
}
