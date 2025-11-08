# springboot-multidatasource

A Spring Boot application demonstrating multi-datasource configuration with PostgreSQL databases.

## Prerequisites

- Java 17 or higher
- Docker and Docker Compose
- Gradle (or use the included Gradle wrapper)

## Docker Setup

This project uses Docker Compose to run PostgreSQL 18.0 with Spring Boot's Docker Compose support.

### Starting the Database

The application uses PostgreSQL 18.0 running in Docker with the following configuration:

- **PostgreSQL Version**: 18.0
- **Username**: yu71
- **Password**: 53cret
- **Databases**: db1, db2
- **Port**: 5432

To start the PostgreSQL container:

```bash
docker-compose up -d
```

To stop the container:

```bash
docker-compose down
```

To stop and remove volumes (this will delete all data):

```bash
docker-compose down -v
```

### Verify the Setup

Check that PostgreSQL is running:

```bash
docker ps
```

List the databases:

```bash
docker exec springboot-multidatasource-postgres psql -U yu71 -d postgres -c "\l"
```

## Running the Application

With Spring Boot Docker Compose support, the application will automatically start the Docker containers when you run:

```bash
./gradlew bootRun
```

The application will be available at `http://localhost:8080`

## Testing the REST Endpoints

You can test the REST endpoints using the following GET endpoints:

```
GET| http://localhost:8080/api/db1
{
    "key": 1,
    "databaseName": "db1"
}

GET| http://localhost:8080/api/db2
{
    "key": 2,
    "databaseName": "db2"
}
```

## Database Configuration

The application connects to two separate PostgreSQL databases:

- **db1**: First database instance
- **db2**: Second database instance

Both databases run on the same PostgreSQL server but are logically separated, demonstrating Spring Boot's
multi-datasource capabilities.
