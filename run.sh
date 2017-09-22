#!/bin/bash
# need install docker

# startup activemq
docker run -d -p 61616:61616 --rm --name activemq11111 webcenter/activemq &&
sleep 5

# run app
mvn clean install exec:java -Dexec.mainClass=mq1.App

# stop activemq
docker stop activemq11111
