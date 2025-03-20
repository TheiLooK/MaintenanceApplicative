# 🗓️ TP Noté – Maintenance Applicative & TDD en Java
## Mellano Louka IL1
Gestionnaire d'Événements & Calendrier

## Fonctionalités implémentées :
- [x] Ajouter un nouveau type d'événement au calendrier.
- [ ] Obtenir la liste des événements pour une période donnée.
- [ ] Détecter automatiquement les conflits entre événements (chevauchement horaire).
- [ ] Générer une description spécifique à chaque type d'événement.
- [ ] Pouvoir supprimer un événement par son identifiant métier (ajouter un EventId).

## Fonctionalités ajoutées :
- Ajout d'un système connexions avancé avec hachage des mots de passe
- Amélioration de l'interface

Temps de travail : environ 11h

### Exemple :
```
╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                                                      ║
║  ██████╗ █████╗ ██╗     ███████╗███╗   ██╗██████╗  █████╗ ██████╗     ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗  ║
║ ██╔════╝██╔══██╗██║     ██╔════╝████╗  ██║██╔══██╗██╔══██╗██╔══██╗    ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗ ║
║ ██║     ███████║██║     █████╗  ██╔██╗ ██║██║  ██║███████║██████╔╝    ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝ ║
║ ██║     ██╔══██║██║     ██╔══╝  ██║╚██╗██║██║  ██║██╔══██║██╔══██╗    ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗ ║
║ ╚██████╗██║  ██║███████╗███████╗██║ ╚████║██████╔╝██║  ██║██║  ██║    ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║ ║
║  ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝ ║
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║ Generating test data...                                                                                                              ║
║ Test data generated.                                                                                                                 ║
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║                                      [Bienvenue dans Calendar Manager. Veuillez vous connecter]                                      ║
║                                                                                                                                      ║
║ 1 - Se connecter                                                                                                                     ║
║ 2 - S'inscrire                                                                                                                       ║
║ 3 - Quitter l'application                                                                                                            ║
║                                                                                                                                      ║
║ Votre choix :  1
║ Entrez votre nom d'utilisateur :  admin
║ Entrez votre mot de passe :  admin
║ Vous êtes connecté                                                                                                                   ║
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║                                                   [Menu Gestionnaire d'Événements]                                                   ║
║                                                                                                                                      ║
║ 1 - Menu de visualisation d'Événements                                                                                               ║
║ 2 - Ajouter un rendez-vous personnel                                                                                                 ║
║ 3 - Ajouter une réunion                                                                                                              ║
║ 4 - Ajouter un événement périodique                                                                                                  ║
║ 5 - Se déconnecter                                                                                                                   ║
║                                                                                                                                      ║
║ Votre choix :  1
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║                                                 [Menu de visualisation d'Événements]                                                 ║
║                                                                                                                                      ║
║ 1 - Afficher les événements                                                                                                          ║
║ 2 - Afficher les événements d'un MOIS précis                                                                                         ║
║ 3 - Afficher les événements d'une SEMAINE précise                                                                                    ║
║ 4 - Afficher les événements d'un JOUR précis                                                                                         ║
║ 5 - Retour                                                                                                                           ║
║                                                                                                                                      ║
║ Votre choix :  1
║                                                       [Liste des événements :]                                                       ║
║                                                                                                                                      ║
║ ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ ║
║ │ ===================================================== Événement Personnel ====================================================== │ ║
║ │ Titre : Corriger le TP de maintenance applicative                                                                                │ ║
║ │ Propriétaire : admin                                                                                                             │ ║
║ │ Date : 2025-03-26                                                                                                                │ ║
║ │ Heure : 14:00                                                                                                                    │ ║
║ │ Durée : 30 minutes                                                                                                               │ ║
║ └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ ║
║ ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ ║
║ │ ===================================================== Événement Périodique ===================================================== │ ║
║ │ Titre : Manger 5 fruits et légumes                                                                                               │ ║
║ │ Propriétaire : admin                                                                                                             │ ║
║ │ Date : 2025-03-26                                                                                                                │ ║
║ │ Heure : 09:00                                                                                                                    │ ║
║ │ Durée : 60 minutes                                                                                                               │ ║
║ │ Périodicité : 1 jours                                                                                                            │ ║
║ └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ ║
║ ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ ║
║ │ =========================================================== Réunion ============================================================ │ ║
║ │ Titre : Réunion de projet                                                                                                        │ ║
║ │ Propriétaire : admin                                                                                                             │ ║
║ │ Date : 2025-03-26                                                                                                                │ ║
║ │ Heure : 10:00                                                                                                                    │ ║
║ │ Durée : 30 minutes                                                                                                               │ ║
║ │ Lieu : IUT Charlemange - Salle 105                                                                                               │ ║
║ │ Participants : Bob, Alice                                                                                                        │ ║
║ └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ ║
║ Appuyez sur Entrée pour continuer :
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║                                                 [Menu de visualisation d'Événements]                                                 ║
║                                                                                                                                      ║
║ 1 - Afficher les événements                                                                                                          ║
║ 2 - Afficher les événements d'un MOIS précis                                                                                         ║
║ 3 - Afficher les événements d'une SEMAINE précise                                                                                    ║
║ 4 - Afficher les événements d'un JOUR précis                                                                                         ║
║ 5 - Retour                                                                                                                           ║
║                                                                                                                                      ║
║ Votre choix :  5
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║                                                   [Menu Gestionnaire d'Événements]                                                   ║
║                                                                                                                                      ║
║ 1 - Menu de visualisation d'Événements                                                                                               ║
║ 2 - Ajouter un rendez-vous personnel                                                                                                 ║
║ 3 - Ajouter une réunion                                                                                                              ║
║ 4 - Ajouter un événement périodique                                                                                                  ║
║ 5 - Se déconnecter                                                                                                                   ║
║                                                                                                                                      ║
║ Votre choix :  5
║ Vous êtes déconnecté                                                                                                                 ║
║                                                                                                                                      ║
╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║                                      [Bienvenue dans Calendar Manager. Veuillez vous connecter]                                      ║
║                                                                                                                                      ║
║ 1 - Se connecter                                                                                                                     ║
║ 2 - S'inscrire                                                                                                                       ║
║ 3 - Quitter l'application                                                                                                            ║
║                                                                                                                                      ║
║ Votre choix :  3
║ Fermeture de l'application...                                                                                                        ║
╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
```



# -------------------- Sujet --------------------

## 🎯 Objectifs du TP :
Mettre en pratique la démarche Test-Driven Development (TDD).  
Appliquer des principes propres à la maintenance applicative en faisant évoluer une base de code existante.  

Pour pimenter un peu les choses, il y aura quelques petites contraintes:
- Utiliser exclusivement des Value Objects  
// interdiction d'utiliser des primitives nues  
- Implémenter une solution reposant sur le polymorphisme  
// interdiction d'utiliser des conditionnels (if, switch, opérateur ternaire).


## 📌 Contexte du TP :
Votre supérieur, fan de *COBOL* et "autodicacte" a dévellopé un projet nommé **« *main.com.tpnote.com.tpnote.services.CalendarManager* »** (oui, une application avec un nom anglais, c'est plus classe), une application minimaliste de gestion d’événements et rendez-vous. Il n'a pas du tout confiance en l'utilisation de code externe (il a déjà fallu batailler pour passer aux fax...), donc il n'est même pas la peine de lui proposer une autre solution, même éprouvée. 

L’application souffre d’une mauvaise conception initiale (utilisation excessive de primitives, couplage fort, répétitions de conditionnels, etc.).

Votre rôle est d'appliquer une stratégie de refactoring progressif afin de transformer ce code fragile en un système robuste, facilement maintenable et évolutif.


## 🚧 Contraintes techniques imposées :

### Baby-steps
On ne casses pas tout d'un coup, on essaie de faire d'abord un nettoyage progressif pour réduire la quantité de code, puis on restructure.

### Développement des nouvelles fonctionnalités guidé par les tests (TDD) :
Chaque fonctionnalité doit être écrite en suivant strictement la démarche TDD :
- Écrire d’abord un test qui échoue (rouge).
- Implémenter le code nécessaire pour passer le test (vert).
- Refactorer sans casser les tests précédents.

### Interdiction des primitives nues :
Toutes les données métier (dates, heures, durées, titres, lieux) doivent être représentées par des Value Objects immuables.
Exemples obligatoires de Value Objects : 
- DateEvenement,
- HeureDebut,
- DureeEvenement,
- TitreEvenement,
- etc.

Aucune primitive brute (int, double, String, Date, etc.) n’est autorisée dans le domaine métier directement.

### Polymorphisme et interdiction des conditionnels :
Aucun bloc conditionnel explicite (if, switch, opérateur ternaire) n'est autorisé dans le domaine métier.
Tout comportement variant doit être géré par le polymorphisme via des interfaces ou classes abstraites.


## 📦 Domaine Métier (Calendrier d'événements) :

Le calendrier permet d'ajouter différents types d'événements, notamment :

- Rendez-vous personnels : simples, avec une date, une heure de début, une durée, un titre.  
- Réunions : avec des participants et un lieu.  
- Événements périodiques : répétitifs à fréquence fixe (hebdomadaire, mensuelle, annuelle).  
- Chaque événement peut générer une description textuelle spécifique à son type, sans utiliser de conditions explicites.


## ⚙️ Exigences fonctionnelles à implémenter :
1) Ajouter un nouveau type d'événement au calendrier.
2) Obtenir la liste des événements pour une période donnée.
3) Détecter automatiquement les conflits entre événements (chevauchement horaire).
4) Générer une description spécifique à chaque type d'événement.
5) Pouvoir supprimer un événement par son identifiant métier (ajouter un EventId).


## ✅ Livrables attendus :
Projet Maven ou Gradle comprenant obligatoirement des tests unitaires.  
Commit par étape démontrant la démarche TDD (rouge → vert → refactor).  
Respect strict des contraintes techniques :
- Aucune primitive nue
- Aucun conditionnel explicite
- Utilisation obligatoire des Value Objects
- Démonstration claire du polymorphisme


## 🧑‍💻 Évaluation (à titre indicatif):
- Qualité et fréquence des commits - **2 points**
- Qualité de la démarche TDD - **4 points**
- Implémentation des fonctionnalités - **2 points**
- Respect des contraintes techniques - **4 points**
- Qualité du design orienté objet & maintenabilité - **4 points**
- Qualité/Lisibilité du code et des tests - **4 points**


## 🚀 Suggestions d’évolution ultérieure possible (non obligatoire mais bonus) :
- Sérialisation/Désérialisation vers JSON. **+1** 
- Ajout d'une interface utilisateur minimale. **+3**
- Une idée, ben go, fait des beaux commits et je verrais bien ce que ça vaut. **+X**

**Rappel: Un bonus est un bonus, le projet, hors bonus, est noté sur 20. Les bonus permettent juste de récuppérer des points potentiellement perdus.**