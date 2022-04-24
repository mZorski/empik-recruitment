# Empik recruitment task

## Table of contents

1. [Basic information](#basic-information)
2. [Prerequisites](#prerequisites)
3. [Cloning application](#cloning-application)
4. [Running application](#running-application)
5. [Stopping application](#stopping-application)
6. [Cleaning database](#cleaning-database)

## Basic information

Application runs under `https://localhost:8082/`

## Prerequisites

To be able to run this application, you need:

1. Git
2. Java +11

## Cloning application

1. Clone this repository

   `git clone https://github.com/mZorski/empik-recruitment`

2. Go to project's root directory

   `cd empik-recruitment`

## Running application

1. Build and run executable jar
   1. Build executable jar (uber jar)

      `./gradlew clean bootJar`

   2. Run application

      `java -jar ./build/libs/empik.jar`

2. Run application using gradle task

   `./gradlew bootRun`

## Stopping application

Press `ctrl + c`

## Cleaning database

1. Stop application
2. Run `./gradlew removeDbFiles`
3. Start application