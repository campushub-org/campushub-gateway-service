# campushub-gateway-service - API Gateway

Ce service est la porte d'entrée unique pour toutes les requêtes des clients vers l'écosystème de microservices Campushub. Il est basé sur Spring Cloud Gateway (en mode WebFlux) et est responsable du routage des requêtes vers les services appropriés.

### Fonctionnalités

*   **Routage des requêtes**: Redirige les requêtes des clients vers les microservices backend appropriés (e.g., `campushub-user-service`).
*   **Configuration centralisée**: Obtient sa configuration de `campushub-config`.
*   **Découverte de services**: S'enregistre auprès de `campushub-registry` pour découvrir les services backend.
*   **Actuator**: Expose des endpoints de gestion pour surveiller et interagir avec la passerelle.

### Configuration du routage

Le routage est configuré de manière programmatique dans la classe `GatewayConfig.java`. Les routes sont définies à l'aide d'un bean `RouteLocator`.

### Ports

*   **Port de l'application**: `8080` (pour les requêtes des clients)
*   **Port de gestion (Actuator)**: `8084` (pour les endpoints de gestion)

### Endpoints de l'API (Actuator)

Voici un endpoint de gestion utile pour diagnostiquer et surveiller la passerelle. Notez qu'il est exposé sur le port de gestion `8084`.

---

#### 1. Lister les routes actives

Permet de voir toutes les routes actuellement chargées par la passerelle.

- **Méthode :** `GET`
- **Path :** `/actuator/gateway/routes`
- **Permissions :** Publique (sur le port de gestion)

**Exemple `curl`:**
```bash
curl http://localhost:8084/actuator/gateway/routes
```

---
