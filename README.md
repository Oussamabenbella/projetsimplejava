# Spring Boot PostgreSQL Minimal Demo

Une application Spring Boot minimale configurée pour PostgreSQL, prête à être déployée sur Render.

## Prérequis

- Java 17
- Maven
- PostgreSQL (pour le développement local)

## Configuration

### Variables d'environnement pour Render

Configurez les variables d'environnement suivantes sur Render :

- `spring.datasource.url` - URL de la base de données PostgreSQL (format : jdbc:postgresql://host:port/database)
- `spring.datasource.username` - Nom d'utilisateur PostgreSQL
- `spring.datasource.password` - Mot de passe PostgreSQL
- `SPRING_PROFILES_ACTIVE` - Définir à `prod`

### Développement local

Pour exécuter l'application localement :

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse http://localhost:8080

### Construction du JAR

```bash
mvn clean package
```

Le fichier JAR sera généré dans le dossier `target/`.

## Déploiement sur Render

1. Pushez ce dépôt sur GitHub
2. Créez un nouveau Web Service sur Render
3. Sélectionnez "Build and deploy from a Git repository"
4. Connectez votre dépôt GitHub
5. Configurez les variables d'environnement
6. Déployez !
