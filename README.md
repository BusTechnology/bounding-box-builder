# bounding-box-build

[![Build Status](https://travis-ci.org/BusTechnology/bounding-box-builder.svg?branch=master)](https://travis-ci.org/BusTechnology/bounding-box-builder)

  a. generates bounding box for gtfs *.zip files
    
  b. returns the bounding box northeast latitute, northeast longitude, southwest latitute, and southwest longitude
  
## Run quickly:

  mvn package
  
  java -jar target/boundingboxbuilder-0.0.1-SNAPSHOT.jar [path of gtfs *.zip files]
