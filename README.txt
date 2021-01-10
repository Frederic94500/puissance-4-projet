=== EXECUTION ===

java -jar puissance-4-1.2.jar [fichier de partie]

=== EXECUTION DEPUIS LE CODE SOURCE + GENERATION DU JAVADOC (Nécessite Maven)===

mvn clean package javadoc:javadoc

java -jar puissance-4-1.2.jar [fichier de partie]

Javadoc disponible sur target/site/apidocs/

=== JAVADOC EN LIGNE ===

https://upec.frederic94500.net/puissance-4/

=== DEPOTS ===

GitLab UPEC = https://git-etudiants.lacl.fr/u21960418/puissance-4-projet
GitHub = https://github.com/Frederic94500/puissance-4-projet

=== AVANCEMENT ===

Joueur vs joueur: codé
IA naïve: codé
IA MinMax: partiellement, buggé
IA AlphaBeta: non commencé

=== METHODOLOGIE ===

En argument: le fichier -> Si oui: charge la partie
			Sinon: création de la partie
			Sans argument: crée la partie

Méthode: ArrayList de ArrayList de Coin

Enregistrement: colonne par colonne (géré par gson)

0 0 0 ...
1 1 1 
2 2 2 
3 3 3 
4 4 4 
5 5 5 

Enregistrement dans un fichier: géré par gson via la méthode toJson() -> enregistrement dans un fichier .json
Lecture d'un fichier: géré par gson via la méthode fromJson() -> lit un fichier et le transforme en objet Game

Déroulement:
1 - Création de la partie ou lecture de la partie
2 - Vérification de la partie s'il y a un gagnant, si oui, aller à 7, sinon continuer
3 - A qui doit placer un disque
4 - Affiche la grille
5 - Enregistre la partie
6 - Recommencer depuis 2
7 - Annonce du gagnant ou non

IA:
Bogo = Codé
MinMax = WIP (buggé)
Customisé = Codé
AlphaBeta = Not started yet

Customisé:
1 - On crée l'arbre des possibilités, jusqu'à 4 à gauche (droite étant les possibilités sur chaque colonne)
2 - On calcul le score de chaque noeud
3 - On remonte le score des noeuds gauche
4 - On calcul: négatif = défavorable, 0 = nul, positif = favorable
5 - On place en priorité sur le noeud où le score est postif, sinon, si il n'y a rien: alors on place sur la liste de choix 0 (Le négatif est buggé).

MinMax: (Buggé)
1 - Création de l'arbre des possiblités, 4 de profondeurs
2 - Calcul de score de chaque noeud
3 - On remonte le score: adversaire: on prend le score le plus petit, IA: on prend le score le plus grand de l'adversaire
4 - On récupère le score le plus grand et on place

=== DIFFICULTES ===

Chaque difficultées sont indiqués avec un numéro du commit où la correction a été faite

1 - Impossibilité d'entrer la colonne, corrigé: 39e05fa426d42f68edd6769d0b3e513c7a549fcb
2 - Vérification de la grille, corrigé: ce30acc9a1f70fb6e462544d0ded7e6678468f65
3 - Ajout de la fonction de nettoyage, non implémenté à cause de la non-exécution sur Windows et Ubuntu: 41ad54433197d4ae8a07e11b5f6fa6ffaced182b
4 - Création de l'arbre pour MinMax, implémenté: 3603ab0850b97bcc7a785122d1cb9d1ad2a2ca8f
5 - (Obsolète, voir 7)La copie fonctionne mal, implémenté via la lecture du fichier de partie: 943e1e6da0760ee075538b3401c7211659ab4e60
6 - Remonter le score à travers l'arbre, codé: bc6e8e62c60d3b2dd6e5b5b9853b44effbdc2949
7 - La copie ne fonctionne pas pour les autres possibilités, copie profonde via gson vu qu'il ne copie pas les références: bc6e8e62c60d3b2dd6e5b5b9853b44effbdc2949
8 - A un moment, l'IA ne place plus de disque: il se bloque quand l'adversaire va bientôt gagner (score négatif), commenté: non implémenté à cause d'un bug assez étrange: 65421c2e890b821fc34bea89bf90472fa4625eae
9 - MinMax totalement bloqué sur la colonne 7, non corrigé.

=== DOCUMENTATION ===

Gestion des couleurs:
https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
https://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java

Gson:
https://github.com/google/gson
https://attacomsian.com/blog/gson-write-json-file
https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html

ArrayList:
https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/
https://www.w3schools.com/java/java_arraylist.asp

Manipulation:
https://stackoverflow.com/questions/7833689/java-string-new-line
https://www.w3schools.com/java/java_enums.asp
https://www.w3schools.com/java/java_switch.asp
https://www.javatpoint.com/java-get-current-date
https://www.baeldung.com/java-deep-copy

Maven:
https://maven.apache.org/guides/getting-started/
https://maven.apache.org/plugins/maven-shade-plugin/examples/executable-jar.html
https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven/4608897-creez-votre-premier-projet-maven
