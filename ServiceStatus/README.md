## ServiceStatus

This project is a web app that queries MBeans on the application server where it is deployed for deployed web services and displays the endpoints.  The MBean query has been partially abstracted, so the code can be more easily adapted to look up other MBeans.

## Build

```sh
mvn clean install
```

## Deploy

While JBoss/WildFly is running, either drop the war into $JBOSS_HOME/standalone/deployments, or run the following:

```sh
$JBOSS_HOME/bin/jboss-cli.sh -c --command="deploy ServiceStatus-[version].war"
```

## Run

Deploy one or more web service projects to your server, then access the ServiceStatus app via http://localhost:8080/status
