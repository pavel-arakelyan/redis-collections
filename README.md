# RedisMap Test Guide

This guide explains how to set up, run, and test the Redis-backed `Map` implementation in this project.

---

## Prerequisites

Before proceeding, ensure you have the following installed on your system:

- Docker
- Docker Compose
- Java 21
- Gradle

---

## Project Setup

### 1. Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/your-repo-name.git
cd your-repo-name
```

### 2. Build the Project

```bash
./gradlew clean build
```

## Running Redis with Docker Compose

To set up a Redis server for testing:

### 1. Start Redis

Navigate to `infrastructure` folder and run the following command to start the Redis server using Docker Compose:

```bash
docker-compose up -d
```

### 2. Verify Redis is Running

Confirm the Redis server is running:

```bash
docker ps
```

You should see a container named `redis-standalone-server`.

## Testing the Map

To demonstrate how the Redis-backed Map implementation works, you can either.

### 1. Run the Application

Run spring boot application whose main method performs put, get operations on `RedisMap`, and observe the output.

```bash
./gradlew bootRun
```

### 2. Run Tests

Execute the tests to verify that the Redis-backed Map works as expected:

```bash
./gradlew test
```


