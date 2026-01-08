# Nautilus
A cross-platform Java Swing based GUI application to view Computer Information

# Cross-Platform Support

### Windows
- Uses Windows Management Instrumentation
- Windows 10 and 11 are supported out of the box
- Windows 7SP1, 8 and 8.1 need [Windows Management Framework 5.1](https://www.microsoft.com/en-us/download/details.aspx?id=54616)

### Linux
- Uses DMIDECODE
- Any distribution is supported as long as `dmidecode` is or can be installed.
To download `dmidecode` for your distribution of linux: 

Fedora/Rhel/Rocky
```bash
$ sudo dnf install dmidecode
```
Debian/Ubuntu
```bash
$ sudo apt install dmidecode
```
Arch Linux
```bash
$ sudo pacman -S dmidecode
```

### Mac
- Planned

# Screenshots

### Windows Build
<img width="1759" height="637" alt="image" src="https://github.com/user-attachments/assets/70167e8a-007f-4bb3-8f0c-8190f94d82ff" />

### Linux Build

# Download
## Pre-Built Binaries
Pre-built, portable binaries are available on the [Releases](https://github.com/eggy03/Nautilus/releases) page.

Binary releases are not code-signed. Because of this:
- Windows Defender / Antivirus software may flag the application
- Windows SmartScreen may show a warning

If you build the binaries yourself, these warnings may not appear.

## Building from source
### Pre-requisites
- JDK 21+ must be installed
- Build Tool: Maven (optional, maven wrapper will be provided)

### Steps
- Clone the repository
```
git clone https://github.com/eggy03/Nautilus.git
cd Nautilus
```
- Build the application depending on your platform
```
./mvnw package jpackage:jpackage@win
```
```
./mvnw package jpackage:jpackage@linux
```
The generated binaries will be available in `project_directory/target/output`

- The build uses `jpackage` to generate native app images
- Output format depends on the target OS

# License
MIT




  
  
