#!/bin/bash
#Auteur : Abdelhamid CHERAGA
set -o pipefail

checkJava() {
    if [ -x "$JAVA_HOME/bin/java" ]; then
        JAVA="$JAVA_HOME/bin/java"
    else
        JAVA=`which java`
    fi

    if [ ! -x "$JAVA" ]; then
        echo "Could not find any executable java binary. Please install java in your PATH or set JAVA_HOME"
        exit 1
    fi
}

checkJava
echo $JAVA


for cmd in {mvn,jq,curl,java,javac}; do
  if ! command -v ${cmd} > /dev/null; then
    >&2 echo "This script requires '${cmd}' to be installed."
    exit 1
  fi
done


workspace=$(pwd)
echo $workspace


cd /tmp
if [[ ! -e dev_api ]]; then

	mkdir 'dev_api'
fi
cd dev_api

if [[ ! -e ~/bin/openapitools/openapi-generator-cli ]]; then
	#https://openapi-generator.tech/docs/installation
	#wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/6.3.0/openapi-generator-cli-6.3.0.jar -O openapi-generator-cli.jar
	mkdir -p ~/bin/openapitools
	curl https://raw.githubusercontent.com/OpenAPITools/openapi-generator/master/bin/utils/openapi-generator-cli.sh > ~/bin/openapitools/openapi-generator-cli
	chmod u+x ~/bin/openapitools/openapi-generator-cli
fi


export PATH=$PATH:~/bin/openapitools/

#https://api.insee.fr/catalogue/api-docs/carbon.super/Sirene/V3/?envName=Production%20and%20Sandbox
#wget https://api.insee.fr/catalogue/api-docs/carbon.super/Sirene/V3\?envName\=Production%20and%20Sandbox -O sirene.json
curl https://api.insee.fr/catalogue/api-docs/carbon.super/Sirene/V3/?envName=Production%20and%20Sandbox --output sirene.json

##creation du config.json

vesrion_api=$(jq  ".info.version" sirene.json)
echo "-------------"
echo $vesrion_api

config="""
{
  \"groupId\" : \"org.esupportail.data\",
  \"artifactId\" : \"sirene\",
  \"artifactVersion\" : "$vesrion_api",
  \"apiPackage\" : \"org.esupportail.data.sirene.entreprise.client.api\",
  \"invokerPackage\" : \"org.esupportail.data.sirene.entreprise.client.invoker\",
  \"modelPackage\" : \"org.esupportail.data.sirene.entreprise.client.model\",
  \"dateLibrary\": \"java11\",
  \"library\" : \"native\"
}

"""
echo   $config >config.json






openapi-generator-cli  generate -g java -i sirene.json -c config.json -o sirene

cd sirene
mvn install
cd target
versionJar=${vesrion_api//\"/}
jarName="sirene-$versionJar.jar"
mvn install:install-file -Dfile=$jarName -DgroupId=org.esupportail.data -DartifactId=sirene -Dversion=$versionJar -Dpackaging=jar

echo """ ajoutez la dépendance suivante dans votre pom.xml afin de pouvoir utiliser le client \n
	<dependency>
    		<groupId>org.esupportail.data</groupId>
		<artifactId>sirene</artifactId>
		<version>$versionJar</version>
	</dependency>
"""
cd $workspace
