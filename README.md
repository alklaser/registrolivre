![alt tag](http://i.imgur.com/CguDLcL.png?1)

# Registro Livre

O **Registro Livre** é uma plataforma de dados abertos cujo objetivo principal é colocar à disposição do público informações sobre empresas, imóveis e outros tipos de bens e atividades sujeitos a registro público no Brasil. Embora os dados disponíveis em cartórios e juntas comerciais sejam públicos, eles raramente são publicados. O cidadão que deseja ter acesso a contratos sociais e informações sobre propriedade de imóveis, por exemplo, precisa pagar taxas e aguardar vários dias para receber cópias de documentos. O Registro Livre vai reunir estes dados numa plataforma aberta, para a qual todo cidadão poderá contribuir. Desta forma, os registros públicos serão acessíveis a todos e tornados públicos de fato.

## Status
[![Build Status](https://snap-ci.com/aceleradora6-tw/RegistroLivre/branch/master/build_image)](https://snap-ci.com/aceleradora6-tw/RegistroLivre/branch/master)

## Tecnologias e dependências
* JAVA [(VRaptor3 Framework)](http://vraptor3.vraptor.org/pt/)
* PostgreSQL
* Hibernate
* Jetty
* Maven
* [Bootstrap3](http://getbootstrap.com/)

##### Testes
* JUnit
* Hamcrest
* Selenium / Fluentlenium
* Mockito

##### DevOps
* [SnapCI](https://snap-ci.com/aceleradora6-tw/RegistroLivre/branch/master)

##### Hospedagem
* [Heroku Staging](http://registro-livre-staging.herokuapp.com/)
* [Heroku Produção](http://registro-livre-aceleradora.herokuapp.com/)
* [Cloudinary (Arquivos .pdf)](http://cloudinary.com/)
*É indicado ter uma conta no Cloudinary para desenvolvimento local e gestão dos arquivos PDF. (A configuração padrão no ambiente de produção é no Cloudinary e está configurada no arquivo [db.sh](https://github.com/aceleradora6-tw/RegistroLivre/blob/master/db.sh))*


## Rodando o projeto

#### Configurando o ambiente	

##### Mac

No mac, você precisa ter as seguintes tecnologias instaladas:

1. [Ruby](https://www.ruby-lang.org/pt/downloads/)
2. [Java 1.7+](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk7-downloads-1880260.html)

Para fazer o projeto funcionar, você precisa rodar o arquivo 'config-mac.sh' para baixar e configurar o banco local postgresql e suas variaveis.

##### Debian/Ubuntu

No Debian/Ubuntu, você precisa ter as seguintes tecnologias instaladas:

1. [Java 1.7+](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk7-downloads-1880260.html)

Para fazer o projeto funcionar, você precisa rodar o arquivo 'config.sh' para baixar e configurar o banco local postgresql e suas variaveis.


#### Clonando o projeto

1. Faça um clone para sua máquina via GIT: `$ git clone https://github.com/aceleradora6-tw/RegistroLivre.git`
2. Enter project folder: `$ cd RegistroLivre`
3. Para usar o projeto em alguma IDE importe-o como um projeto Maven para o seu workspace.

Se tudo der certo, você poderá rodar o projeto!

#### Rodando o projeto localmente

	$ mvn jetty:run

Open [http://localhost:8080](http://localhost:8080)

#### Rodando os testes do projeto localmente

	$ mvn test
	
## Colabore

O Registro Livre é um projeto de software livre. Portanto, você pode obter nosso código-fonte no Github e aplicar em seus próprios projetos. Melhor ainda, você pode nos ajudar a aprimorá-lo! Também adoraríamos ver os dados disponíveis aqui servindo como base para análises e estudos, ou sugestões de novas funcionalidades.

Para **contribuir no aplicativo pelo Github** (após clonar e configurar o ambiente), crie um branch: 

	$ git branch funcionalidade-nome

acesse o branch criando: 
	
	$ git checkout funcionalidade-nome
	
e após feitas as alterações que deseja, envie um [*pull request*](https://help.github.com/articles/using-pull-requests/) para juntarmos a esta versão.

Saiba mais sobre contribuir [aqui](http://registro-livre-staging.herokuapp.com/colabore).
	
## Contribuidores

[http://registro-livre-staging.herokuapp.com/sobre](http://registro-livre-staging.herokuapp.com/sobre)
