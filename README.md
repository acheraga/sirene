# prérequis: le jar client de l'API sirene de l'INSEE:
pour installer le jar client de l'API sirene :
lancez le script  install_requirement/install_Sirene_V3.sh 


#Accés Swagger
http://server/swagger-ui/index.html

#Accés curl
curl -X 'GET' \
  'http://server/sirene/findBySiret?siret=19921204400010'   -H 'accept: \*/\*'