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
* [GO](http://www.go.cd/)
* [Vagrant](https://www.vagrantup.com/) 

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

## Como iniciar o GO-CD no seu computador

Para ter uma instância do GO-CD executando no seu computador, basta executar o comando abaixo:

```
$ ./gradlew bringUpGoServer
```

Após a inicialização da maquina, execute provisionGoServer para fazer o provisionamento da maquina, o que irá instalar e configurar todos os requisitos necessários:

```
$ ./gradlew provisionGoServer
```

Ao fazer isso o GO-CD será configurado dentro da maquina virtual criada no step anterior, permitindo o acesso ao GO-CD através das configurações informadas no Vagrantfile na pasta infrastructure/go. Se as configurações  padrões foram mantidas, o acesso será através da url:  192.168.33.10:8153/go.

Além disso você pode destruir a maquina virtual executando o comando:

```
$ ./gradlew destroyGoServer
```

E a qualquer momento  verificar o status da maquina virtual usando:

```
$ ./gradlew statusGoServer
```

#### Permissões de acesso
GO-CD provem duas formas para autenticação de acesso. A primeira utilizando um arquivo de configuração de senhas (no formato padrão do Apache htpasswd) ou por autenticação LDAP/ActiveDirectory. Para este projeto nós ultizaremos a primeira opção. Você pode ler mais sobre as formas de autenticação lendo a documentado do GO-CD na parte de autentication, [clicando aqui](http://www.go.cd/documentation/user/current/configuration/dev_authentication.html).

O arquivo com as configurações de senhas pode ser encontrado em:

```
$ infrastructure/go/configurations/htpasswd
```

Para criar um login de acesso, primeiro verifique se você já possui o Apache htpasswd instalado no seu computador, caso não o possua, [clique aqui](http://www.go.cd/documentation/user/current/configuration/dev_authentication.html#generating-passwords-using-htpasswd ) para saber como instalar.

Uma vez instalado, vá até a pasta root do projeto e execute o seguinte comando:
```
$ htpasswd -s infrastructure/go/configurations/htpasswd "username desejado"
```
A senha desejada será solicidada e será armazenada no arquivo htpasswd (usando hash SHA1), lembrando que será necessário executar o provisionamento da maquina virtual utilizada pelo go novamente.

