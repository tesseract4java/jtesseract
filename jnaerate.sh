#!/bin/sh

# call jnaerator
java -jar jnaerator-0.12-SNAPSHOT.jar \
    -library tesseract \
    -runtime BridJ \
    -direct \
    -mode Directory \
    -skipDeprecated \
    -o src/main/java \
    -package de.vorb.tesseract \
    ../VS2013/tesseract-ocr/api/capi.h
