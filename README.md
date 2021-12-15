# pismo-transaction-manager


## Running

For executing the application locally, first is necessary to execute the services infrastructure, and then you can execute the application.

```sh
$ ./gradlew bootRun
```

### Services infrastructure

Services infrastructure include Postgres. To run them, execute the following command, from the project root directory:

```sh
$ docker-compose up -d
```
