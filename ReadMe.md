# Empik recruitment task

## Table of contents

1. [Prerequisites](#prerequisites)
2. [Running application](#running-application)
3. [Cleaning database](#cleaning-database)

## Prerequisites

To be able to run this application, you need:

1. Git
2. Java +11

## Running application

1. Clone repository

   `git clone https://github.com/mZorski/empik-recruitment`


2. Go to project's root directory

   `cd empik-recruitment`


3. Build executable jar (uber jar)

   `./gradlew clean bootJar`


4. Run application

   `java -jar ./build/libs/empik.jar`


5. Stop application

   Press`ctrl + c`

## Cleaning database

1. Stop application
2. Run `./gradlew removeDbFiles`