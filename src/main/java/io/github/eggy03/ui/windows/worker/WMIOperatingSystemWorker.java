package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.system.Win32OperatingSystem;
import io.github.eggy03.ferrumx.windows.service.system.Win32OperatingSystemService;
import io.github.eggy03.ui.common.utilities.IconImageChooser;
import io.github.eggy03.ui.windows.utilities.WMIBooleanUtility;
import io.github.eggy03.ui.windows.utilities.WMIDateUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class WMIOperatingSystemWorker extends SwingWorker<List<Win32OperatingSystem>, Void> {

    private final JComboBox<String> osNameComboBox;
    private final List<JTextField> osFields;
    private final JLabel osCoverLabel;

    @Override
    protected List<Win32OperatingSystem> doInBackground() {
        return new Win32OperatingSystemService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<Win32OperatingSystem> osList = get();
            if(osList.isEmpty()) {
                log.info("No entries for Win32OperatingSystem were found");
                return;
            }
            log.info("Found {} Win32OperatingSystem entry/entries", osList.size());

            // fill the combo box with os names
            osList.forEach(os -> osNameComboBox.addItem(os.getName()));
            // populate fields for the first entry in the combo box
            populateFields(osList);
            // add a listener to the combo box to re-populate fields on new selection
            osNameComboBox.addActionListener(selectEvent-> populateFields(osList));

        } catch (InterruptedException e) {
            log.error("OS Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("OS Fetch Failed", e);
        }
    }

    private void populateFields(List<Win32OperatingSystem> osList) {

        String osName = String.valueOf(osNameComboBox.getSelectedItem());

        Optional<Win32OperatingSystem> optionalOs = osList
                .stream()
                .filter(os-> os.getName()!=null && os.getName().equals(osName))
                .findFirst();

        if(optionalOs.isEmpty())
            return;

        Win32OperatingSystem os = optionalOs.get();

        osFields.get(0).setText(os.getCaption());
        osFields.get(1).setText(os.getVersion());
        osFields.get(2).setText(os.getBuildNumber());
        osFields.get(3).setText(os.getManufacturer());
        osFields.get(4).setText(os.getOsArchitecture());
        osFields.get(5).setText(WMIDateUtility.toLocalDateTime(os.getInstallDate()));
        osFields.get(6).setText(WMIDateUtility.toLocalDateTime(os.getLastBootUpTime()));
        osFields.get(7).setText(os.getSerialNumber());
        osFields.get(8).setText(os.getMuiLanguages()==null ? "N/A" : os.getMuiLanguages().toString());
        osFields.get(9).setText(WMIBooleanUtility.resolveBoolean(os.isPrimary()));
        osFields.get(10).setText(WMIBooleanUtility.resolveBoolean(os.isDistributed()));
        osFields.get(11).setText(WMIBooleanUtility.resolveBoolean(os.isPortable()));
        osFields.get(12).setText(os.getCsName());
        osFields.get(13).setText(String.valueOf(os.getNumberOfUsers()));
        osFields.get(14).setText(os.getRegisteredUser());
        osFields.get(15).setText(os.getSystemDrive());
        osFields.get(16).setText(os.getWindowsDirectory());
        osFields.get(17).setText(os.getSystemDirectory());

        IconImageChooser.osImageChooser(osCoverLabel, os.getCaption());
    }
}
