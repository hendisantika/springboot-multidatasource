# springboot-multidatasource

[![Java CI with Gradle](https://github.com/hendisantika/springboot-multidatasource/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/springboot-multidatasource/actions/workflows/gradle.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.x-6DB33F?logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-9.8.x-02303A?logo=gradle)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-4169E1?logo=postgresql)

A Spring Boot application demonstrating multi-datasource configuration with PostgreSQL databases.

## Tech Stack

| Component          | Version                                   |
|--------------------|-------------------------------------------|
| Java (JDK)         | 25 (via Gradle Java toolchain)            |
| Spring Boot        | 4.1.x                                     |
| Gradle (wrapper)   | 9.8.x                                     |
| Persistence        | Spring Data JPA, Jakarta Persistence 3.2  |
| Database           | PostgreSQL 18                             |
| Other              | Lombok, Spring Boot Docker Compose, Actuator |

## Prerequisites

- JDK 25 (the build uses a Gradle Java toolchain pinned to Java 25)
- Docker and Docker Compose
- Gradle (or use the included Gradle wrapper `./gradlew`)

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

## Building & Running Tests

The `contextLoads` test connects to the real `db1` and `db2` PostgreSQL databases, so make sure the database
container is running first:

```bash
docker-compose up -d
./gradlew build
```

The datasource URLs can be overridden with environment variables, e.g. when PostgreSQL runs on another port:

```bash
DB1_DATASOURCE_URL=jdbc:postgresql://localhost:55432/db1 \
DB2_DATASOURCE_URL=jdbc:postgresql://localhost:55432/db2 \
./gradlew build
```

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

## Continuous Integration

GitHub Actions ([`.github/workflows/gradle.yml`](.github/workflows/gradle.yml)) runs on every push and pull request
to `master`:

- Sets up **JDK 25 (Temurin)** and Gradle with dependency caching.
- Starts a **PostgreSQL 18** service container and creates `db1` & `db2` from [`init-db.sql`](init-db.sql).
- Runs `./gradlew build` (compile + tests) and uploads test reports on failure.
- On push, submits the Gradle dependency graph to enable Dependabot alerts.

## Dependency Updates (Dependabot)

[`.github/dependabot.yml`](.github/dependabot.yml) keeps dependencies up to date:

| Ecosystem        | Schedule (Asia/Jakarta) | Notes                                                              |
|------------------|-------------------------|--------------------------------------------------------------------|
| `gradle`         | Daily, 21:00            | Spring Boot updates grouped; other minor/patch updates grouped     |
| `github-actions` | Weekly (Mon), 21:00     | All action updates grouped into a single PR                        |
| `docker-compose` | Weekly (Mon), 21:00     | Keeps the PostgreSQL image in `docker-compose.yml` up to date      |

PRs are labeled (`dependencies` + ecosystem label) and use conventional commit prefixes
(`chore(deps)`, `ci(deps)`, `chore(docker)`).
