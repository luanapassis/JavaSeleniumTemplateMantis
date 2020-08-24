# templateJava

Projeto criado utilizando a IDE IntelliJ IDEA
Crianção do projeto utilizando a ferramenta de automação de compilação Maven
Automação utilizando Java + Selenium + TestNG

Este projeto tem como base o framework de java da Base2 Tecnologia, seguindo as melhores práticas de automação de teste.

Automação realizada na aplicação Mantis, instalada localmente.
Na instalação do mantis, recomenda-se a utilização do prefixo mantis_ nas tabelas do sistema.

Configuração do build no Jenkins:
-Baixar o maven Binary zip archive no site https://maven.apache.org/download.cgi
-Descopactar numa pasta do sistema
-Incluir o caminho xxx\apache-maven-x.x.x\bin na variavel path do windows

-No jenkins Acessar Global Tool Configuration
 -Configurar o jkd e o maven
 exemplo https://subscription.packtpub.com/book/networking_and_servers/9781786465702/2/ch02lvl1sec16/configuring-java-and-maven-in-jenkins
 
-Criar um Job de maven
-No Construir adicionar o caminho do POM.xml xxx\templateJava\pom.xml
-No metas e opções usar o "clean test"

obs: é necessário usar os plugins do maven no POM e criar o arquivo testng.xml onde contem todos os casos de testes que serão executados.

