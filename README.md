# Spring Boot REST API

A Spring Boot REST API that requires environment configuration for database connections.

## Setup

### 1. Clone the repo

```bash
git clone https://github.com/rajumb0232/spring-demo.git
cd spring-demo
```

### 2. Configure Environment Variables

#### Create a `.env` file by copying the `.env.example` file:

```bash
cp .env.example .env
```

#### Update the `.env` file with the appropriate values:

```env
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```

- **`DB_URL`**: The URL of your database (e.g., `jdbc:mysql://localhost:3306/yourdatabase`)
- **`DB_USERNAME`**: The username to connect to the database.
- **`DB_PASSWORD`**: The password for the specified database username.

### 3. Run the Application

- **For local development**:

```bash
mvn spring-boot:run
```

- **For production**, make sure the `.env` file is correctly set up with the production environment values and run:

```bash
mvn spring-boot:run -Dspring.profiles.active=prod
```

### 4. Build the Application (Optional)

If you need to build the application for production:

```bash
mvn clean install
```

This will package the application into a `.jar` file inside the `target/` directory.

### 5. Running the Application in Production

After building the application, use the following command to run the JAR in production:

```bash
java -jar target/your-application.jar
```

Ensure that the `.env` file with production values is properly loaded before running.

## Project Structure

```
src/               # Source code
target/            # Built files
.env               # Environment variables for local and production environments
.env.example       # Example .env file
pom.xml            # Maven build configuration
README.md          # Documentation
```
