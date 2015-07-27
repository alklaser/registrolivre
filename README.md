# Registro Livre

O **Registro Livre** é uma plataforma de dados abertos cujo objetivo principal é colocar à disposição do público informações sobre empresas, imóveis e outros tipos de bens e atividades sujeitos a registro público no Brasil. Embora os dados disponíveis em cartórios e juntas comerciais sejam públicos, eles raramente são publicados. O cidadão que deseja ter acesso a contratos sociais e informações sobre propriedade de imóveis, por exemplo, precisa pagar taxas e aguardar vários dias para receber cópias de documentos. O Registro Livre vai reunir estes dados numa plataforma aberta, para a qual todo cidadão poderá contribuir. Desta forma, os registros públicos serão acessíveis a todos e tornados públicos de fato.

## Tecnologias e dependências
* Java 8 
* Spring MVC 
* SpringBoot
* Gradle
* PostgreSQL
* Hibernate
* [Bootstrap3](http://getbootstrap.com/)

##### Testes
* JUnit
* Hamcrest
* Mockito
* Jasmine
* Karma
* Sinon
* Chai

## Configurando banco de dados

Para configurar o banco executar o comando abaixo:

```
$ ./gradlew initDatabase
```

## Pré-requisitos para executar os testes de front-end

##### Mac OS X

```
$ brew install node
```

No Mac OS X, instalando somente o 'node', o npm já é incluso.

##### Linux

```
$ sudo apt-get update
$ sudo apt-get install nodejs
$ sudo apt-get install npm
```

## Como executar os testes de front-end

```
$ ./gradlew jsTest
```

## Criando migrations

Migrations devem ser adicionadas no diretório src/main/resources/db/migration/.

##### Nomenclatura

Os arquivos de migration devem seguir o padrão abaixo de nomenclatura.
* Prefixo: V
* Versão: Pontos e underscores separão as partes, você pode usar quantas partes quiser
* Separador: __ (dois underscores)
* Descrição: Underscores separam as palavras
* Sufixo: .sql

**Exemplo**: V1__init.sql

#### Executar migrations

```
$ ./gradlew flywayMigrate
```
Ou
```
$ ./gradlew run
```
Obs: Executando o comando run as migrations serão executadas automaticamente.