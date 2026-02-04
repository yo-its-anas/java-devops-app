# DevOps Tip of the Day – Java Application

## Overview
This is a lightweight Java HTTP application that serves a single web page.
Each page load displays a random DevOps tip.

The application is intentionally simple and has:
- No external dependencies
- No database
- No build tools (Maven/Gradle)

It is designed to be easy to run locally and easy to containerize.

---

## How the Application Works

- The application starts an HTTP server on port **8080**
- When a user accesses `/`, it:
  - Reads tips from a file called `tips.txt`
  - Selects one tip randomly
  - Returns a basic HTML page

---

## Project Structure
 - src/Main.java → Application source code
 - tips.txt → Text file containing DevOps tips

---

## Requirements

- Java 17 or compatible
- Port 8080 must be available

---

## How to Run Locally (Without Docker)

From the project root:

```bash
javac src/Main.java
java -cp src Main


Then open a browser and visit:

http://localhost:8080

---

## Configuration Notes

 - The application expects tips.txt to be present in the current working directory
 - If the file is missing, the application will fail at runtime
 - The server port is currently hardcoded to 8080
