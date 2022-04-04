DIR:=$(shell basename $(shell pwd))

run: build
	java -Dfile.encoding=UTF-8 -cp build/libs/$(DIR)-fat.jar:build/libs/$(DIR).jar fr.usmb.m1isc.compilation.tp.Main

build: src/main/jflex/*.flex src/main/cup/*.cup src/main/java/fr/usmb/m1isc/compilation/tp/*.java
	./gradlew clean && ./gradlew build
