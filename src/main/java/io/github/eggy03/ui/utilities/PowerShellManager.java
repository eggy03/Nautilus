package io.github.eggy03.ui.utilities;

import com.profesorfalken.jpowershell.PowerShell;
import lombok.experimental.UtilityClass;

import java.util.function.Function;

/**
 * manages a single PowerShell session on application start
 * @deprecated
 */
@Deprecated(since = "2.0.0")
@UtilityClass
class PowerShellManager {

    // refactor this in future cause if pshell is not found, will throw a runtime exception and not start the UI itself
    private static final PowerShell powershellSession = PowerShell.openSession();

    /**
     * provides a synchronized way of utilizing a single PowerShell session since jPowershell is NOT thread safe
     * @deprecated
     */
    @Deprecated
	public static synchronized <T> T invoke(Function<PowerShell, T> fn){
       return fn.apply(powershellSession);
    }

    /**
     * @deprecated
     */
    @Deprecated
	public static void close() {
        if(powershellSession!=null)
            powershellSession.close();
    }
}
