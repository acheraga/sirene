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




#Démarrer le service
./mvnw spring-boot:run 


#Accés Swagger
http://server/swagger-ui/index.html

#Accés curl
curl -X 'GET' \
  'http://server/sirene/findBySiret?siret=19921204400010'   -H 'accept: \*/\*'