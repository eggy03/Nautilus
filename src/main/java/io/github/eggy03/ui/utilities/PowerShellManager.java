package io.github.eggy03.ui.utilities;

import com.profesorfalken.jpowershell.PowerShell;

import java.util.function.Function;

// manages a single powershell session on application start
public class PowerShellManager {

    private static final PowerShell powershellSession = PowerShell.openSession(); //TODO refactor this in future cause if pshell is not found, will throw a runtime exception and not start the UI itself

    // provides a synchronized way of utilizing a single powershell session since jPowershell is NOT thread safe
    public static synchronized <T> T invoke(Function<PowerShell, T> fn){
       return fn.apply(powershellSession);
    }

    public static void close() {
        if(powershellSession!=null)
            powershellSession.close();
    }
}
