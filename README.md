# av3
Projeto AV3 Engenharia de Software 2

# Pré Requisitos

	• Tomcat7
	• Java8
	• NodeJS
	• Bower
	• Git
	• Qualquer IDE (o projeto é maven..) 

#Configurando o projeto

1. Baixe o servidor de aplicação:

https://tomcat.apache.org/download-80.cgi

2. Instale o git:

https://git-scm.com/downloads

3. Instale o node:

https://nodejs.org/en/download/

4. Depois de instalar o node, verifique se o mesmo esta funcionando com o comando:

node -v

5. Depois baixe o bower com o seguinte comando:

npm install -g bower

6. Após instalar todas os pré-requisitos, acesse a pasta do sistema/src/main/webapp/static e execute:

npm install

e depois

bower install

7. (Apenas para ECLIPSE) Baixe o Maven do site: https://maven.apache.org/ e configure as váriaveis de ambiente

8. Na IDE, vá em RUN -> Run Configurations -> Maven -> Doube click e configure duas rotinas para:

Eclipse eclipse e Install skip test

9. Depois execute um package para gerar o jar

10. Depois configure o servidor de aplicação adicionando o JAR gerado pelo maven dentro do tomcat