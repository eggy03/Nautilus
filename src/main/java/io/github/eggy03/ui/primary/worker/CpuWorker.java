package io.github.eggy03.ui.primary.worker;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.compounded.Win32ProcessorToCacheMemory;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32ProcessorToCacheMemoryService;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CpuWorker extends SwingWorker<List<Win32ProcessorToCacheMemory>, Void> {

    private final JComboBox<String> cpuIdComboBox;
    private final List<JTextField> cpuFields;
    private static List<Win32ProcessorToCacheMemory> storedResult;

    public CpuWorker(JComboBox<String> cpuIdComboBox, List<JTextField> cpuFields){
        this.cpuIdComboBox=cpuIdComboBox;
        this.cpuFields=cpuFields;
    }

    @Override
    protected @NotNull List<Win32ProcessorToCacheMemory> doInBackground() {
        try(PowerShell shell = PowerShell.openSession()){
            return new Win32ProcessorToCacheMemoryService().get(shell);
        }
    }

    @Override
    protected void done() {
        try {
            storedResult = get(20L, TimeUnit.SECONDS);
            // add all cpu device ids to the combo box
            storedResult.forEach(cpuAndCacheCombo -> cpuIdComboBox.addItem(cpuAndCacheCombo.getDeviceId()));

            //add cpu combo box action listener
            addCpuComboBoxActionListener();
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private void addCpuComboBoxActionListener() {
        cpuIdComboBox.addActionListener(cbSelectEvent ->{

            Optional<Win32ProcessorToCacheMemory> current = storedResult.stream()
                    .filter(cpu ->
                        cpu.getDeviceId()!=null && cpu.getDeviceId().equals(cpuIdComboBox.getSelectedItem())
                    ).findFirst();

            if (current.isEmpty())
                return;

            Win32ProcessorToCacheMemory currentCpuAndCache = current.get();
            //TODO fill the fields
        });
    }
}
