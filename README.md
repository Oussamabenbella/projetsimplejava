# TravelAPI - Application Spring Boot avec PostgreSQL

![CI/CD Status](https://github.com/Oussamabenbella/projetsimplejava/actions/workflows/ci-cd.yml/badge.svg)

Une API RESTful moderne de gestion de destinations de voyage, développée avec Spring Boot et PostgreSQL, et déployée automatiquement via CI/CD sur Render.

## Fonctionnalités

- API RESTful complète pour la gestion des destinations de voyage
- Interface utilisateur moderne et responsive
- Base de données PostgreSQL pour le stockage des données
- Documentation API avec Swagger/OpenAPI
- Pipeline CI/CD automatique avec GitHub Actions
- Déploiement automatisé sur Render

## Architecture

- **Backend**: Spring Boot 3.x avec Java 17
- **Base de données**: PostgreSQL
- **Migrations**: Flyway
- **Documentation API**: Springdoc-OpenAPI
- **Conteneurisation**: Docker
- **CI/CD**: GitHub Actions
- **Hébergement**: Render

## Prérequis pour le développement

- Java 17 ou supérieur
- Maven 3.8+
- Docker (optionnel)
- PostgreSQL (pour le développement local)
- Git

## Mise en route

### Cloner le dépôt

```bash
git clone https://github.com/Oussamabenbella/projetsimplejava.git
cd projetsimplejava
```

### Configuration de la base de données

Configurez votre base de données PostgreSQL locale et mettez à jour les informations de connexion dans `src/main/resources/application.properties`.

### Démarrer l'application en mode développement

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse http://localhost:8080

### Construction du JAR

```bash
mvn clean package
```

Le fichier JAR sera généré dans le dossier `target/`.

### Exécuter avec Docker

```bash
docker build -t travelapi .
docker run -p 8080:8080 travelapi
```

## Pipeline CI/CD

Ce projet utilise GitHub Actions pour l'intégration continue et le déploiement continu. Le pipeline comprend :

### 1. Build et Tests
- Checkout du code source
- Configuration de JDK 17
- Compilation avec Maven
- Exécution des tests unitaires et d'intégration
- Publication des artefacts de build

### 2. Construction de l'image Docker
- Construction de l'image Docker
- Test de l'image Docker

### 3. Déploiement sur Render
- Déclenchement d'un déploiement via webhook Render
- Vérification du statut du déploiement

Le déploiement est automatiquement déclenché à chaque push sur la branche `master`.

## Configuration pour le déploiement

### Variables d'environnement pour Render

Configurez les variables d'environnement suivantes sur Render :

- `spring.datasource.url` - URL de la base de données PostgreSQL
- `spring.datasource.username` - Nom d'utilisateur PostgreSQL
- `spring.datasource.password` - Mot de passe PostgreSQL
- `SPRING_PROFILES_ACTIVE` - Définir à `prod`

### Secrets GitHub pour CI/CD

Pour que le pipeline CI/CD fonctionne, ajoutez ces secrets dans votre dépôt GitHub :

- `RENDER_DEPLOY_HOOK_URL` - URL du webhook de déploiement Render
- `RENDER_DEPLOY_HOOK_KEY` - Clé d'authentification pour le webhook Render

## Documentation API

Après avoir démarré l'application, accédez à :

- Documentation Swagger UI : `/swagger-ui.html`
- Documentation OpenAPI : `/api-docs`

## Licence

Ce projet est sous licence MIT.
