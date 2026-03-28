# 🚪 CampusHub - API Gateway Service

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2023.0.2-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)

> L'**API Gateway** est la sentinelle de CampusHub. Elle centralise le routage des requêtes, la gestion des politiques de sécurité (CORS) et offre une façade unifiée pour tous les microservices métier.

---

## 🚀 Fonctionnalités Clés

- **Routage Dynamique** : Redirection intelligente vers les microservices (`user-service`, `salle-service`, `support-service`) basée sur le chemin d'URL.
- **Façade Unifiée** : Un seul hôte et port (`8080`) pour l'intégralité du backend.
- **Gestion des CORS** : Configuration centralisée pour autoriser les interactions avec le Front-end.
- **Haute Disponibilité** : Intégration avec Eureka pour équilibrer la charge entre les instances de services.
- **Observabilité** : Endpoints Actuator pour le monitoring de l'état de santé du système.

---

## 🗺️ Plan de Routage

| Préfixe de Route | Destination | Port Interne |
| :--- | :--- | :--- |
| `/campushub-user-service/**` | **User Service** | `8081` |
| `/campushub-salle-service/**` | **Salle Service** | `8082` |
| `/campushub-support-service/**` | **Support Service** | `8083` |

---

## 🛠️ Stack Technique

- **Core :** Spring Boot 3.2.5
- **Routing :** Spring Cloud Gateway
- **Discovery :** Eureka Client integration
- **Config :** Spring Cloud Config Client

---

## ⚙️ Configuration & Installation

### Build du package (Crucial)
```bash
# Générer le JAR en sautant les tests
./mvnw clean package -DskipTests
```

### Lancement Local
```bash
./mvnw spring-boot:run
```

### Déploiement Docker
```bash
docker build -t campushub-gateway-service .
```

---
<p align="center">Une porte d'entrée unique vers l'excellence académique</p>
