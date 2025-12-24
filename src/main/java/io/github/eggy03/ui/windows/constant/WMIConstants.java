package io.github.eggy03.ui.windows.constant;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@UtilityClass
public class WMIConstants {

    // Win32CacheMemory
    @NotNull
    public static String resolveWMICacheMemoryType(@Nullable Integer cacheType) {

        return switch (cacheType) {
            case 1-> "Other";
            case 2-> "Unknown";
            case 3-> "Instruction";
            case 4-> "Data";
            case 5-> "Unified";
            case null, default -> "N/A";
        };
    }

    @NotNull
    public static String resolveWMICacheMemoryLevel(@Nullable Integer cacheLevel) {

        return switch (cacheLevel) {
            case 1-> "Other";
            case 2-> "Unknown";
            case 3-> "Primary (L1)";
            case 4-> "Secondary (L2)";
            case 5-> "Tertiary (L3)";
            case 6-> "Not Applicable";
            case null, default -> "Not Found";
        };
    }

    @NotNull
    public static String resolveWMICacheMemoryAssociativity(@Nullable Integer associativity) {

        return switch (associativity) {
            case 1-> "Other";
            case 2-> "Unknown";
            case 3-> "Direct Mapped";
            case 4-> "2-way Set-Associative";
            case 5-> "4-way Set-Associative";
            case 6-> "Fully Associative";
            case 7-> "8-way Set-Associative";
            case 8-> "16-way Set-Associative";
            case null, default -> "N/A";
        };
    }

    @NotNull
    public static String resolveWMICacheMemoryLocation(@Nullable Integer location) {

        return switch (location) {
            case 0-> "Internal";
            case 1-> "External";
            case 2-> "Reserved";
            case 3-> "Unknown";
            case null, default -> "N/A";
        };
    }

    @NotNull
    public static String resolveWMICacheErrorCorrectType(@Nullable Integer errorCorrectType) {

        return switch (errorCorrectType) {
            case 0 -> "Reserved";
            case 1 -> "Other";
            case 2 -> "Unknown";
            case 3 -> "None";
            case 4 -> "Parity";
            case 5 -> "Single-bit ECC";
            case 6 -> "Multi-bit ECC";
            case null, default -> "N/A";
        };
    }

    // Win32PhysicalMemory
    @NotNull
    public static String resolveWMIPhysicalMemoryFormFactor(@Nullable Integer formFactor) {

        return switch (formFactor) {
            case 0-> "Unknown";
            case 1-> "Other";
            case 2-> "SIP";
            case 3-> "DIP";
            case 4-> "ZIP";
            case 5-> "SOJ";
            case 6-> "Proprietary";
            case 7-> "SIMM";
            case 8-> "DIMM";
            case 9-> "TSOP";
            case 10-> "PGA";
            case 11-> "RIMM";
            case 12-> "SODIMM";
            case 13-> "SRIMM";
            case 14-> "SMD";
            case 15-> "SSMP";
            case 16-> "QFP";
            case 17-> "TQFP";
            case 18-> "SOIC";
            case 19-> "LCC";
            case 20-> "PLCC";
            case 21-> "BGA";
            case 22-> "FPBGA";
            case 23-> "LGA";
            case null, default -> "N/A";
        };
    }

    // Win32PortConnector
    @NotNull
    public static String resolveWMIPortType(@Nullable Integer portType) {

        return switch (portType) {
            case 0  -> "None";
            case 1  -> "Parallel Port XT/AT Compatible";
            case 2  -> "Parallel Port PS/2";
            case 3  -> "Parallel Port ECP";
            case 4  -> "Parallel Port EPP";
            case 5  -> "Parallel Port ECP/EPP";
            case 6  -> "Serial Port XT/AT Compatible";
            case 7  -> "Serial Port 16450 Compatible";
            case 8  -> "Serial Port 16550 Compatible";
            case 9  -> "Serial Port 16550A Compatible";
            case 10 -> "SCSI Port";
            case 11 -> "MIDI Port";
            case 12 -> "Joy Stick Port";
            case 13 -> "Keyboard Port";
            case 14 -> "Mouse Port";
            case 15 -> "SSA SCSI";
            case 16 -> "USB";
            case 17 -> "FireWire (IEEE 1394)";
            case 18 -> "PCMCIA Type I";
            case 19 -> "PCMCIA Type II";
            case 20 -> "PCMCIA Type III";
            case 21 -> "Cardbus";
            case 22 -> "Access Bus Port";
            case 23 -> "SCSI II";
            case 24 -> "SCSI Wide";
            case 25 -> "PC-98";
            case 26 -> "PC-98-Hireso";
            case 27 -> "PC-H98";
            case 28 -> "Video Port";
            case 29 -> "Audio Port";
            case 30 -> "Modem Port";
            case 31 -> "Network Port";
            case 32 -> "8251 Compatible";
            case 33 -> "8251 FIFO Compatible";
            case null, default -> "N/A";
        };
    }


    // GENERAL
    @NotNull
    public static String resolveWMIAvailability(@Nullable Integer availability) {

        return switch (availability) {
            case 1  -> "Other";
            case 2  -> "Unknown";
            case 3  -> "Running / Full Power";
            case 4  -> "Warning";
            case 5  -> "In Test";
            case 6  -> "Not Applicable";
            case 7  -> "Power Off";
            case 8  -> "Offline";
            case 9  -> "Off-duty";
            case 10 -> "Degraded";
            case 11 -> "Not Installed";
            case 12 -> "Install Error";
            case 13 -> "Power Save - Unknown";
            case 14 -> "Power Save - Low Power Mode";
            case 15 -> "Power Save - Standby";
            case 16 -> "Power Cycle";
            case 17 -> "Power Save - Warning";
            case 18 -> "Paused";
            case 19 -> "Not Ready";
            case 20 -> "Not Configured";
            case 21 -> "Quiesced";
            case null, default -> "N/A";
        };
    }
}
