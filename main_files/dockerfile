# ---- Build Stage ----
FROM gradle:8-jdk17 AS build
WORKDIR /app

# Copy Gradle config first to leverage caching
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle

RUN ./gradlew --version

# Copy the rest of the source
COPY . .

# Build the Kotlin React app
RUN ./gradlew browserProductionWebpack --no-daemon

# ---- Runtime Stage ----
FROM nginx:alpine

# Copy compiled static artifacts to Nginx
COPY --from=build /app/build/distributions/ /usr/share/nginx/html/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
