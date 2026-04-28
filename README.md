# Nautilus

A cross-platform Java Swing based GUI application to view information about your hardware.

# Cross-Platform Support

### Windows

- Uses Windows Management Instrumentation
- Windows 10 and 11 are supported out of the box
- Windows 7SP1, 8 and 8.1 need [Windows Management Framework 5.1](https://www.microsoft.com/en-us/download/details.aspx?id=54616) to be installed. See [WMF availability across Windows Systems](https://learn.microsoft.com/en-us/powershell/scripting/windows-powershell/wmf-overview?view=powershell-7.5#wmf-availability-across-windows-operating-systems)

### Linux

- Uses `dmidecode`
- Any distribution is supported as long as `dmidecode` is or can be installed.

### Mac

- Planned

# Download

## Pre-Built Binaries

Pre-built binaries are not signed, which means your antivirus or smart-screen software may flag it as an
unwanted program. If there is a demand for it, I may start releasing them, but for now, building from source
is a viable option since your AV or Smart Screen filter wouldn't flag it.

## Building from source

### Pre-requisites

- JDK 21 or later
- Build Tool: Maven (optional, maven wrapper will be provided)

### Steps

- Clone the repository
```shell
git clone https://github.com/eggy03/Nautilus.git
cd Nautilus
```
- Build the application depending on your platform
```shell
./mvnw -Pdist package jpackage:jpackage@win
```
```shell
./mvnw -Pdist package jpackage:jpackage@linux
```
The generated binaries will be available in `../Nautilus/target/output`

Note that each subsequent build requires manually clearing out the target folder or else the build will fail

- The build uses `jpackage` to generate native app images
- Output format depends on the target OS
- A minimal runtime is generated using `jlink` which is then packaged into the target build
- This makes your build portable

## Native Builds (Experimental)

Nautilus also supports native builds via [GraalVM](https://www.graalvm.org/latest/reference-manual/native-image/).
This feature is experimental and may produce unstable builds.

Native builds offer faster startup and reduced memory consumption. However, you will lose
JVM's cross-platform compatibility.

To build a native image, you will require GraalVM JDK (25+ is recommended).

Building Nautilus is a 2-Step Process:

### Step 1: Create reachability-metadata

```shell
./mvnw -Pnative -DskipNativeBuild=true exec:exec@java-agent
```
This launches the Nautilus GUI with the GraalVM tracing agent enabled.
You must interact with the UI as thoroughly as you can, to enable proper generation of `reachability-metadata`.
This will create the `reachability-metadata.json` in `src/main/resources/META-INF/native-image/{groupId}/{artifactId}`
which is required in the next step.

### Step 2: Build the native executable

```shell
./mvnw clean -Pnative package 
```
This performs ahead-of-time (AOT) compilation and produces a native executable in the target directory.
Note that this is a resource intensive process.

After completion, you will need to run Nautilus via

```shell
./nautilus "<java.home.path>"
```
Native images do not include a JVM runtime, so `java.home` may be unavailable.
Provide a valid JDK path manually as a launch argument.

Example: 
```shell
./nautilus "C:/Users/Username/.jdks/graalvm-ce-25.0.2"
```


# Screenshots

### Windows

A modified build of Nautilus with hidden Hardware ID and Processor ID, running on Windows 11 24H2

<img width="850" height="640" alt="Screenshot 2026-04-07 122534" src="https://github.com/user-attachments/assets/79bcb6bf-ea05-4c85-9e2f-5b27a5d57208" />

### Linux

A modified build of Nautilus with hidden System UUID and Processor ID, running on Bazzite 43, a Fedora based distribution and using dmidecode 3.6

<img width="850" height="640" alt="Screenshot_20260408_200545" src="https://github.com/user-attachments/assets/f0c95572-9232-420f-aec3-cd335d7b5aed" />

# License

[GPLv3](/LICENSE.md)
