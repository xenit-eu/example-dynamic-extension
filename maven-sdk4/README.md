# Alfresco Maven SDK 4 example Dynamic Extensions project

Example project building a custom Dynamic Extensions module with the Alfresco Maven SDK version 4.

## Building
The project can be build with the default `mvn package` command.  
Once build, two artifacts will be available in the `target` folder:

* A Dynamic Extensions OSGi bundle that can be manually uploaded to the Dynamic Extensions dashboard
* An Alfresco Module Package containing the custom bundle, which can be installed in Alfresco using e.g. Alfresco's 
Module Management Tool.

## Starting Alfresco

Since this project is based on the `org.alfresco.maven.archetype:alfresco-platform-jar-archetype` Maven 
archetype, you can use `./run.sh build_start` to start it up locally.
 
The starting Alfresco will have Dynamic Extensions and the custom module build by this project, installed. 
Once started up the dashboard is available on http://localhost:8080/alfresco/s/dynamic-extensions/bundles.

![Dynamic Extensions Dashboard](assets/Dashboard.png)

For simplicity and as a reference, we'll hereafter include a part of the default README of the used Alfresco archetype. 
This gives detailed instructions on how to build and setup Alfresco with docker.

# Alfresco ACS JAR Module - SDK 4.0

This is an ACS project for Alfresco SDK 4.0.

Run with `./run.sh build_start` or `./run.bat build_start` and verify that it

 * Runs Alfresco Content Service (ACS)
 * (Optional) Runs Alfresco Share
 * Runs Alfresco Search Service (ASS)
 * Runs PostgreSQL database
 * Deploys the JAR assembled module
 
All the services of the project are now run as docker containers. The run script offers the next tasks:

 * `build_start`. Build the whole project, recreate the ACS docker image, start the dockerised environment composed by ACS, Share (optional), ASS 
 and PostgreSQL and tail the logs of all the containers.
 * `build_start_it_supported`. Build the whole project including dependencies required for IT execution, recreate the ACS docker image, start the dockerised environment 
 composed by ACS, Share (optional), ASS and PostgreSQL and tail the logs of all the containers.
 * `start`. Start the dockerised environment without building the project and tail the logs of all the containers.
 * `stop`. Stop the dockerised environment.
 * `purge`. Stop the dockerised container and delete all the persistent data (docker volumes).
 * `tail`. Tail the logs of all the containers.
 * `reload_acs`. Build the ACS module, recreate the ACS docker image and restart the ACS container.
 * `build_test`. Build the whole project, recreate the ACS docker image, start the dockerised environment, execute the integration tests and stop 
 the environment.
 * `test`. Execute the integration tests (the environment must be already started).
