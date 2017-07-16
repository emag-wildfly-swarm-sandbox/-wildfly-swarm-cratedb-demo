# wildfly-swarm-cratedb-demo

WildFly Swarm CrateDB Demo

## Prerequisites

* Install CrateDB on local
  * https://crate.io/docs/crate/reference/installation.html

## Build & Run

``` console
./mvnw clean package
java -jar target/wildfly-swarm-cratedb-demo-swarm.jar
```

## Access API

``` console
$ curl -s localhost:8080 | jq .
{
  "databaseProductName": "Crate",
  "databaseMajorVersion": 9,
  "driverVersion": "PostgreSQL 9.4.jre7"
}
```

## Related Forum

[CrateDB JDBC not auto-detected](https://groups.google.com/forum/#!topic/wildfly-swarm/kJN42Swgt8s)