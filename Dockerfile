# Stage de build
FROM maven:3.9-eclipse-temurin-17 as builder
WORKDIR /app

# Copier le fichier POM avant les sources pour optimiser le cache des dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier les sources et compiler
COPY src ./src
# Les fichiers .mvn et mvnw sont facultatifs dans ce projet
RUN mvn package -DskipTests

# Stage d'exécution
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Créer un utilisateur non-root pour exécuter l'application
RUN addgroup --system --gid 1001 appgroup \
    && adduser --system --uid 1001 --gid 1001 appuser

# Copier le JAR depuis le stage de build
COPY --from=builder /app/target/*.jar app.jar

# Configuration pour Render et autres plateformes cloud
ENV PORT=8080
ENV SPRING_PROFILES_ACTIVE=prod

# Exposer le port de l'application
EXPOSE ${PORT}

# Définir l'utilisateur non-root
USER appuser

# Amélioration des performances JVM pour les conteneurs
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
