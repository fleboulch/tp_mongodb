# tp_mongodb

####Question sur les bases de données orientées document####

Ces bases de données n'ont pas de structure figée comme l'exige à l'inverse les bases de données relationnelles. On peut ainsi modifier la structure du document comme on le souhaite. Cela a des avantages et des inconvénients. Si le modèle change fréquemment, les données de la base peuvent devenir **inconsistentes** et **obsolètes**.

A grande échelle, les bases de données orientées document n'ont pas encore démontré qu'elles surpassaient les bases de données SQL.

Les opérations sur l'ensemble des données ne sont pas efficaces. En effet, chaque ligne du jeu de données est lue. Cela entraine des **opérations sur le disque couteuse** et une réponse lente.

Le modèle de requetage est **limité** aux clés et index.
