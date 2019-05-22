# Gradle SDK example Dynamic Extensions project using the Dynamic Extensions Gradle plugin

Example project building a custom Dynamic Extensions module with the 
[Dynamic Extensions Gradle plugin](https://github.com/xenit-eu/dynamic-extensions-for-alfresco/blob/master/documentation/Gradle_Plugin.md).

## Building
The project can be build with the default `./gradlew assemble` or `./gradlew.bat assemble` command.  
Once build, the Dynamic Extensions OSGi bundle artifact will be available in the `build` folder.

## Installing in Alfresco
To install the custom OSGi bundle, you can 
* upload the bundle through the Dynamic Extensions Dashboard of a running Alfresco.
* use the `./gradlew installBundle` task to automatically upload the bundle. To configure the target Alfresco, have a 
look at the `alfrescoDynamicExtensions.repository` configuration block in the `build.gradle`.