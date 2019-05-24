# Gradle SDK example Dynamic Extensions project using the Dynamic Extensions Gradle plugin

Example project building a custom Dynamic Extensions module with the 
[Dynamic Extensions Gradle plugin](https://github.com/xenit-eu/dynamic-extensions-for-alfresco/blob/master/documentation/Gradle_Plugin.md).

## Building
The project can be build with the default `./gradlew assemble` command.  
Once build, two artifacts will be available in the `build` folder:

* A Dynamic Extensions OSGi bundle that can be manually uploaded to the Dynamic Extensions dashboard. 
This artifact is available in the `build/libs` directory. 
* An Alfresco Module Package containing the custom bundle, which can be installed in Alfresco using e.g. Alfresco's 
Module Management Tool. This artifact is available in the `build/distribution` directory.

## Starting Alfresco
This project provides the infrastructure to setup Alfresco using the
[alfresco-docker-gradle-plugin](https://github.com/xenit-eu/alfresco-docker-gradle-plugin).

To start Alfresco, with Dynamic Extensions and your custom module installed, run:

`./gradlew composeUp` or `./gradlew.bat composeUp`

Alfresco will start and will be available on localhost port 8080.

Once started, it is possible to update our custom module at runtime, using following command:

`./gradlew installBundle` or `./gradlew.bat installBundle`

All changes made to the Java source code will then be build & the bundle will be updated to the running Alfresco. This 
without the need to restart Alfresco! To customize the Alfresco destination to which te bundle needs to be uploaded,
have a look at the `alfrescoDynamicExtensions.repository` configuration block in the `build.gradle`.

To stop the running alfresco, use the `composeDown` gradle task.