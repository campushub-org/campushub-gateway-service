# campushub-gateway-service - Service de Passerelle API (Spring Cloud Gateway)

Ce service est la passerelle API de l'architecture microservices Campushub. Il sert de point d'entrée unique pour toutes les requêtes des clients externes vers les microservices internes. Il assure le routage des requêtes, la sécurité, l'équilibrage de charge et d'autres fonctionnalités transversales.

### Fonctionnalités

*   **Routage dynamique**: Route les requêtes des clients vers les microservices appropriés.
*   **Sécurité**: Peut intégrer des mécanismes d'authentification et d'autorisation.
*   **Résilience**: Gère les défaillances des microservices en aval avec des circuits breakers (via Spring Cloud Circuit Breaker, si configuré).
*   **Intégration Eureka**: Découvre les microservices via `campushub-registry`.
*   **Configuration centralisée**: Obtient sa configuration de `campushub-config`.

### Comment ça marche

`campushub-gateway-service` est une application Spring Boot basée sur Spring Cloud Gateway. Il utilise le service `campushub-config` pour obtenir ses règles de routage et d'autres propriétés. Il s'enregistre également auprès de `campushub-registry` et l'interroge pour trouver les instances de microservices disponibles.

### Commandes Utiles

#### Construire le service (localement, sans Docker)

Pour construire le fichier JAR exécutable du service:

```bash
cd campushub-deployment/campushub-gateway-service
./mvnw clean install -Dspring.cloud.config.uri=http://localhost:8888
```
*(Note: L'option `-Dspring.cloud.config.uri=http://localhost:8888` est nécessaire pour que les tests et la construction locale puissent se connecter au service `campushub-config` si celui-ci est démarré via Docker sur votre machine locale.)*

#### Exécuter le service (localement, sans Docker)

Assurez-vous d'avoir construit le JAR au préalable.

```bash
cd campushub-deployment/campushub-gateway-service
java -jar target/gateway_service-0.0.1-SNAPSHOT.jar
```

Le service sera accessible sur `http://localhost:8080`.

#### Construire et exécuter avec Docker Compose

Dans le répertoire `campushub-deployment`, ce service est défini dans le fichier `docker-compose.yml`.

Pour construire l'image Docker (cela inclut la construction du JAR si ce n'est pas déjà fait):

```bash
cd campushub-deployment
docker-compose build campushub-gateway-service
```

Pour démarrer le conteneur du service:

```bash
cd campushub-deployment
docker-compose up -d campushub-gateway-service
```

Pour vérifier les logs du service une fois démarré:

```bash
cd campushub-deployment
docker-compose logs campushub-gateway-service
```