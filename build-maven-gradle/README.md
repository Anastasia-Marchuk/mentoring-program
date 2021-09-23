
# Project Builder 

Test build project with use Maven and Gradle scripts

## Requirements

* JDK 11
* Apache Maven
*Gradle

123

## Build application: Maven 
start only tests
```
mvn clean test
```
build project
```
mvn clean install
```
for start web-app...
```
mvn jetty:run
```
This starts application and serves up your project on [http://localhost:8085](http://localhost:8085) for web-app
## Build application: Gradle
start only tests
```
./gradlew clean test
```
build project
```
./gradlew clean build
```
