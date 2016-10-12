Web-based calculator for solving triangles
Author: Mikhail S. Zakharov (mzakharov@setronica.com)

1. Introduction
This a demo project built in order to design and implement the task of calculating arbitrary triangle be given sidelengths.
After build and launch, software become accessible as web page suitable for most modern desktop and mobile browsers.

2. Prerequisites
- Java 8 Development Kit (Oracle JDK is better)
- Linux OS such as Debian or Ubuntu (project initially built on Kubuntu 14.04) and Docker tools - if you intended to build app image, suitable for running on top of docker infrastructure.
Note: Setting up and troubleshooting prerequisites are out of scope of current README

3. Quick run
Assumed that you run this step-by-step locally.

1. Open terminal and go to the same directory as contained this README.
2. Execute "./gradlew appRun" command
3. If you see output such as:
19:54:29 INFO  Jetty 9.2.15.v20160210 started and listening on port 8086
19:54:29 INFO  triangle runs at:
19:54:29 INFO    http://localhost:8086/triangle
Press any key to stop the server.

Let's open http://localhost:8086/triangle in browser and got it!

4. Building deployment-ready distribution
4.1. Building TAR package
1. Open terminal and go to the same directory as contained this README.
2. Execute "./gradlew packageApp" command
After that you must see file triangle-web-calculator-<VERSION>-bundled.tgz. This file contains layout sufficient to run project on top of any OS with installed Java 8 - just doubleclick/execute start.sh or start.bat script, according to you host OS after unpacking it.

Hint: unpacking into arbitrary directory on most *nix OS:
tar -xzvf /path/to/triangle-web-calculator-<VERSION>-bundled.tgz -C /path/to/target/dir

4.2. Building Docker image
1. Open terminal and go to the same directory as contained this README.
2. Execute "./gradlew dockerImage" command
3. Execute "docker images", you must see such as:
REPOSITORY                                                            TAG                                        IMAGE ID            CREATED             SIZE
com.setronica.mzakharov/triangle-web-calculator                       1.0-SNAPSHOT                               a8ee9407c2d7        56 minutes ago      610.2 MB

This indicate that docker image with app built successfully, registered in local docker cache, and ready to run.
4. Export docker image into archive (optional)
"docker save com.setronica.mzakharov/triangle-web-calculator:1.0-SNAPSHOT > triangle-web-calculator-1.0-docker-image.tar && gzip triangle-web-calculator-1.0-docker-image.tar"
produces triangle-web-calculator-1.0-docker-image.tar.gz file which can be moved and after ungzipping ready for consuming by "docker load" command

5. Running project in local docker container
Assumed that you run over chapter 4.2. Then next execute
"docker run -itd -p 8087:8086 com.setronica.mzakharov/triangle-web-calculator:1.0-SNAPSHOT"

It run detached container and expose app on port 8087, so open http://localhost:8087/triangle for accessing it
