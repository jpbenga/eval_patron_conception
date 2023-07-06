## Description du projet

Vous devez concevoir une application Java permettant à l'utilisateur de composer son stage d'une demi-journée au poney-club. Ce dernier compte dix poneys : Ribambelle, Ping, Pong, Impala, Bueno, Country, Forza, Horizon, Cassandra et Oasis. Le cavalier garde le même poney pour toute la durée du stage. Les stages se déroulent à la date unique du 01/07/2023. La composition du stage s'effectue en six étapes :

1. L'application affiche les poneys. L'utilisateur doit choisir un poney dans cette liste.

2. L'utilisateur doit choisir les équipements obligatoires du poney : couvre reins, selle, bride et rênes. Le tableau ci-dessous présente la liste exhaustive des équipements et pour chaque équipement le stock initial disponible :

| Nom de l'équipement            | Stock disponible |
|-------------------------------|------------------|
| Couvre reins violet           | 2                |
| Couvre reins rose             | 2                |
| Couvre reins bleu             | 2                |
| Selle en cuir de buffle       | 4                |
| Selle en matière synthétique  | 2                |
| Bride rose                    | 3                |
| Bride bleu                    | 3                |
| Rênes roses                   | 3                |
| Rênes noirs                   | 3                |

3. L'utilisateur peut ensuite ajouter une ou plusieurs activités parmi les activités suivantes :

| Id de l'activité | Nom de l'activité | Tarif (€) |
|-----------------|------------------|-----------|
| 1               | Soins            | 25        |
| 2               | Ballade          | 35        |
| 3               | Pony-Games       | 20        |
| 4               | Saut d'obstacles | 40        |

L'ajout d'une activité se fait ainsi :
Souhaitez-vous ajouter une nouvelle activité (O/N) ? O
Entrez le numéro de l'activité: 3
Vous avez ajouté l'activité Pony-Games
Une activité peut être ajoutée plusieurs fois. Un stage doit comporter au minimum une activité.

4. L'utilisateur renseigne le prénom du cavalier.

5. L'application génère un code unique pour le stage, ce code commence par STAGE.

6. L'application affiche un récapitulatif du stage. Exemple de récapitulatif :
Cavalier: Kylian
Poney: Impala avec Couvre reins bleu, Selle en cuir de buffle, Bride bleu et Rênes noirs
Activité(s) choisie(s): Soins, Pony-Games
Coût total du stage: 45 €
Numéro du séjour: STAGE01

Patrons de conception demandés :
Votre application doit mettre en œuvre les patrons de conception suivants :

- Iterator (pour afficher les poneys)
- Factory (pour fabriquer le code du stage) (une interface est demandée)
- Builder (pour équiper le poney) (une interface est demandée)
- Decorator (pour décorer le stage)
- Singleton
