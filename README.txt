=== EXECUTION ===

java -jar puissance-4-1.?.jar [fichier de partie]

=== DEPOTS ===

GitLab = https://git-etudiants.lacl.fr/u21960418/puissance-4-projet
GitHub = https://github.com/Frederic94500/puissance-4-projet

=== METHODOLOGIE ===

en argument: le fichier -> Si oui: charge la partie
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
MinMax = WIP
AlphaBeta = Not started yet

MinMax (WIP):
1 - On crée l'arbre des possibilités, jusqu'à 2 à gauche (droite étant les possibilités sur chaque colonne)
2 - On calcul le score de chaque noeud
3 - On place en priorité sur le noeud où le score = numéro du joueur (via verify), si il n'y a rien: alors on place sur le premier choix 0, si c'est mort: alors on joue n'imp

Source:
Gitlab LACL -> push Github

Pour Frédéric: commit avec clé GPG

=== DIFFICULTEES ===

1 - Impossibilité d'entrer la colonne, corrigé: 39e05fa426d42f68edd6769d0b3e513c7a549fcb
2 - Vérification de la grille, corrigé: ce30acc9a1f70fb6e462544d0ded7e6678468f65
3 - Ajout de la fonction de nettoyage, non implémenté à cause de la non-exécution sur Windows et Ubuntu: 41ad54433197d4ae8a07e11b5f6fa6ffaced182b
4 - Création de l'arbre pour MinMax, implémenté: 3603ab0850b97bcc7a785122d1cb9d1ad2a2ca8f
5 - La copie fonctionne mal, implémenté via la lecture du fichier de partie: SHA256

=== DOCUMENTATION ===

IA:
https://www.baeldung.com/java-deep-copy

Gestion des couleurs:
https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
https://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java

Gson:
https://attacomsian.com/blog/gson-write-json-file
https://github.com/google/gson
https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html

Manipulation
https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/
https://stackoverflow.com/questions/7833689/java-string-new-line
https://www.w3schools.com/java/java_arraylist.asp
https://www.w3schools.com/java/java_enums.asp
https://www.w3schools.com/java/java_switch.asp
https://www.javatpoint.com/java-get-current-date

Maven:
https://maven.apache.org/guides/getting-started/
https://maven.apache.org/plugins/maven-shade-plugin/examples/executable-jar.html
https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven/4608897-creez-votre-premier-projet-maven

Screenshot du cours:
https://s3.frederic94500.net/2020/11/36ibC.png
https://s3.frederic94500.net/2020/11/6q4PP.png