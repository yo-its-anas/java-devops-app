# Use a lightweight JDK image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside the container
WORKDIR /app

# Copy Java source code
COPY src/Main.java /app/Main.java

# Copy tips file
COPY tips.txt /app/tips.txt

# Compile Java application
RUN javac Main.java

# Expose application port
EXPOSE 8080

# Run the application
CMD ["java", "Main"]
