# Puissance 4 - Projet

Projet Puissance 4

## Dépendance

Ce projet nécessite [gson](https://github.com/google/gson) pour fonctionner.<br>
Ou de Maven (dépendance automatique).

## Javadoc

Disponible [ici](https://upec.frederic94500.net/puissance-4/)

## Release

Joueur contre joueur: [v1.0](https://s3.frederic94500.net/2020/12/puissance-4-1.0.jar)<br>
Joueur contre BogoIA: [v1.1](https://s3.frederic94500.net/2020/12/puissance-4-1.1.jar)<br>
Joueur contre IA MinMax et Customisé: [v1.2](https://s3.frederic94500.net/2021/01/puissance-4-1.2.jar)<br>
Joueur contre IA MinMax refait: [v1.3](https://s3.frederic94500.net/2021/01/puissance-4-1.3.jar)

## Compilation - Génération Javadoc

`mvn clean package javadoc:javadoc`

## Exécution

`java -jar target/puissance-4-1.3.jar [fichier de partie]`