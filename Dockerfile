# Use the official Gradle image as a base image
FROM docker.io/library/gradle:7.5.0-jdk17 as build

ENV TZ=America/Sao_Paulo

# Set the working directory
WORKDIR /build

# Copy the build files
COPY . .

# Build the project with Gradle
RUN gradle build --no-daemon

CMD ["gradle", "bootRun"]

