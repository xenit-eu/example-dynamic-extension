# Gradle SDK example Dynamic Extensions project using the Dynamic Extensions Gradle plugin

Example project building a custom Dynamic Extensions module with the 
[Dynamic Extensions Gradle plugin](https://github.com/xenit-eu/dynamic-extensions-for-alfresco/blob/master/documentation/Gradle_Plugin.md).

## Building
The project can be build with the default `./gradlew assemble` command.  
Once build, two artifacts will be available in the `build` folder:

* A Dynamic Extensions OSGi bundle that can be manually uploaded to the Dynamic Extensions dashboard
* An Alfresco Module Package containing the custom bundle, which can be installed in Alfresco using e.g. Alfresco's 
Module Management Tool.

## Installing in Alfresco
To install the custom OSGi bundle, you can 
* upload the bundle through the Dynamic Extensions Dashboard of a running Alfresco.
* use the `./gradlew installBundle` task to automatically upload the bundle. To configure the target Alfresco, have a 
look at the `alfrescoDynamicExtensions.repository` configuration block in the `build.gradle`.