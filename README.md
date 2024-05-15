Requirements: Java17, PostgreSQL, Node20

Frontend has it's own readme.

For the backend:
 - Run PostgreSQL instance on port 5432, can be a Docker container
 - Ruin ./gradlew clean verify
 - Run the backend/build/libs/projekt-0.0.1-SNAPSHOT.jar file that was created by build process.