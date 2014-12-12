Example Dynamic Extension
=========================

About this project
------------------

This project illustrates the use of <a href="https://github.com/laurentvdl/dynamic-extensions-for-alfresco">Dynamic Extensions for Alfresco</a>. Dynamic Extensions brings rapid development of Java repository extensions extensions to Alfresco. This project contains example Web Scripts, Actions and Behaviours.

Building using Gradle
---------------------

Build this project using <a href="http://www.gradle.org/">Gradle</a>:

```
./gradlew build # nix
./gradle.bat build # Windows
```

This creates a JAR in `build/libs` ready to be hot-deployed to an Alfresco repository with Dynamic Extensions enabled.

Run `./gradlew installBundle` instead to build and deploy live to a running repository.


Building using Maven (alternative)
---------------------

```
mvn package
```

This creates a JAR in `target` ready to be hot-deployed to an Alfresco repository with Dynamic Extensions enabled.

