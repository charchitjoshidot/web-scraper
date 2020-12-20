# Tech Versions 
    java v11
    npm v7.0.15
    Spring Boot v2.4.1
# Install Client Packages
    cd ./client
    npm i
# Start Client Server
    npm start
# Install Server Packages
    cd ./server
    mvn install / mvn clean install
# Start Server Server
    mvn spring-boot:run
# Application URL
    http://localhost:4200
# Database URL
    http://localhost:8080/h2

# Folder Structure

<pre>
├───app-shots
├───client
│   ├───e2e
│   │   └───src
│   └───src
│       ├───app
│       │   └───dummy-event-card
│       ├───assets
│       │   └───images
│       └───environments
└───server
    ├───.mvn
    │   └───wrapper
    ├───.settings
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───galen
    │   │   │           └───webscrapper
    │   │   │               ├───controller
    │   │   │               ├───entity
    │   │   │               ├───repository
    │   │   │               └───service
    │   │   └───resources
    │   │       ├───static
    │   │       └───templates
    │   └───test
    │       └───java
    │           └───com
    │               └───galen
    │                   └───webscrapper
    └───target
        ├───classes
        │   ├───com
        │   │   └───galen
        │   │       └───webscrapper
        │   │           ├───controller
        │   │           ├───entity
        │   │           ├───repository
        │   │           └───service
        │   └───META-INF
        │       └───maven
        │           └───com.galen
        │               └───web-scrapper
        ├───generated-sources
        │   └───annotations
        ├───generated-test-sources
        │   └───test-annotations
        ├───maven-status
        │   └───maven-compiler-plugin
        │       └───compile
        │           └───default-compile
        └───test-classes
            └───com
                └───galen
                    └───webscrapper

</pre>
