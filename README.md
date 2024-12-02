# prérequis: le jar client de l'API sirene de l'INSEE:
pour installer le jar client de l'API sirene :
lancez le script  install_requirement/install_Sirene_V3.sh 
une fois l'exécution terminée, il faut mettre à jour le pom.xml du projet avec la code de la dépendance généré.

# prérequis: le jeton (tocken) d'accés
Pour pouvoir se conncter à l'API sirene il faut avoir un compte sur le site [https://api.insee.fr/catalogue/](https://api.insee.fr/catalogue/)
une fois connecté, éventuellement après la création d'un nouveau compte, il faut aller dans la rubrique "MES APPLICATIONS" puis ajouter une application, après cela suivre les étapes suivantes:
+ aller dans l'application créée
+ aller dans la rubrique "clefs et jetons d'accés" 
+ cliquez sur boutton "générer les clefs" pour générer les clefs
+ vous pouvez maintenant récupérer la clef consommateur et secret consommateur et les mettre dans application.yml  

##MAJ

21-08-2024.
L’Insee modernise son portail des API, en s’appuyant sur une nouvelle architecture.
Les conditions générales d’utilisation du portail, ainsi que celles des API présentées, demeurent inchangées.
Sous l’URL du nouveau portail https://portail-api.insee.fr/, vous retrouvez les API de diffusion de l’Insee.

Accès à l’API Sirene.
Pour accéder à l'API Sirene, vous devez créer un compte sur le nouveau portail, puis souscrire à l'API.
Vous trouverez un mode d'emploi sous le lien suivant :
https://portail-api.insee.fr/catalog/api/2ba0e549-5587-3ef1-9082-99cd865de66f/doc?page=52d26f24-963b-4fc0-926f-24963b4fc021
Un même compte peut souscrire à plusieurs API, en suivant la même procédure.
Après le 28-02-2025, l'API Sirene ne sera accessible qu'à partir de ce nouveau portail.

Sirene 4 - l'Api Sirene 3.11 devient la version de référence depuis le 30 avril 2024
Le répertoire Sirene effectue régulèrement des opérations qualité.
Nous vous invitons à consulter « Sirene.fr » pour obtenir le détail des opérations et en suivre l’avancement.



#Démarrer le service
./mvnw spring-boot:run 


#Accés Swagger
http://server/swagger-ui/index.html

#Accés curl
curl -X 'GET' \
  'http://server/sirene/findBySiret?siret=19921204400010'   -H 'accept: \*/\*'