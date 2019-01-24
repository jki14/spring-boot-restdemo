#! /bin/bash

git add gadd.sh
git add README.md
git add ./src/main/resources/application.properties
git add ./build.gradle
git add ./src/test/resources/*.sql

find -name "*.java" -exec git add {} \;
