# Geocollections of Estonia

http://geocollections.arendus.geokogud.info/

## Getting Started

### Prerequisites:

installed:

* Java JDK version 8

* git

* Gradle build tool 3.5 (do not forget to add gradle in environment variable path). https://gradle.org/releases

* Node.js latest version. https://nodejs.org/en/download/

* bower: ```npm install -g bower ```


### Installing

Install all libraries:

```
bower install
```
Run:
```
gradle bootRun
```
Go to http://localhost:8081 to see the result.

Run unit tests:
```
gradle test
```

Run UI tests (application should be running locally):
```
gradle testUI 
```