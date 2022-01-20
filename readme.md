# Quarkus Tutorial

Very simple example application with [Quarkus][quarkus]

## Build the Application

Requirements:
* Java 11
* Maven 3.8.4
* Docker 20.10.11
* Docker Compose 2.2.1

Build the project by typing into the command line
```
mvn clean install
```

## Start the Application

Start the database typing into the command line:
```
docker compose up
```

Start the application typing into the command line:
```
mvn quarkus:dev
```
or use IntelliJ run/debug

Execute request `GetAll`
```
curl --location --request GET 'localhost:8089/feature/example-table'
```

Execute request `Create`
```
curl --location --request POST 'localhost:8089/feature/example-table' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Suppenkasper",
    "used": true
}'
```

Execute request `GetById`
```
curl --location --request GET 'localhost:8089/feature/example-table/1'
```

You can also find a postman collection inside the `/postman` folder for importing to you Postman app.
It is also possible to use swagger-ui, use the link: http://localhost:8089/q/swagger-ui/

## Links
* [Quarkus with Maven][quarkus-maven]
* [Quarkus: Getting started][first-app]
* [Quarkus: Guides][quarkus-guides]

[first-app]: https://quarkus.io/guides/getting-started
[quarkus]: https://quarkus.io/
[quarkus-guides]: https://quarkus.io/guides/
[quarkus-maven]: https://quarkus.io/guides/maven-tooling
