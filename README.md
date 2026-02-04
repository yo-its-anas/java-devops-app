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

