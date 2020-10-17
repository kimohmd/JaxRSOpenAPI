# TP JaxRS et OpenAPI Kanban board

### Mise en place de la BDD (avec Docker)
arrêter le service mysql si il est installé sur votre machine
```bash
sudo service mysql stop
```
#### démarrez la base de données avec docker.

On démarre un conteneur qui aura comme nom jaxrs et comme mot de passe 554446666

On exporte le port 3306 sur notre host pour que notre programme Java puisse dialoguer facilement avec la base de données
```
docker run --name jaxrs  -p 3306:3306 -e MYSQL_ROOT_PASSWORD=554446666 -d mysql:latest
```
Pour démarrer phpmyadmin avec docker.
```
docker run --name myadminjaxrs -d --link jaxrs:db -p 8082:80 phpmyadmin
```
Accédez à Php myadmin depuis [http://localhost:8082](http://localhost:8082)

utilisateur root, password 554446666

créez une BDD nommée jaxrs

### REMARQUE
les deux conteneurs seront réutilisés lors du tp Spring Boot (ne les supprimez pas)!!

## Exécution
placez-vous dans la racine du projet puis lancez les commandes
```
mv clean compile
mvn exec:java -Dexec.mainClass="fr.istic.taa.jaxrs.RestServer"
```
ou 

Lancer la classe RestServer.java
clic droit-> run as -> java application

rendez-vous dans Swagger UI sur [http://localhost:8080/api/](http://localhost:8080/api/)

testez par exemple le service POST /tableau/addTableau avec body

```json

{
  "titre": "kanban"
}
```

le service POST /utilisateur/addUtilisateur avec body
```json

{
  "nom": "UTILISATEUR",
  "prenom": "User",
  "fonction": "Dev"
}
```

le service GET /utilisateur/{utilisateurId} avec l'Id de l'utilisateur que vous venez de créer

## Limitations

les services ne sont pas optimisées, il manque la gestion des erreurs (dans le cas ou l'on fait un GET sur un utilisateur qui n'existe pas par exemple), de plus
le service fiche/addFiche est plus "propre dans le tp avec springboot"

Le but était juste d'avoir quelques services fonctionnels 

(vous pouvez aussi tester les apis sur Postman.)


## Auteur
Abdel Karim HAMMAD
