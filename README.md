# Registro Livre

O **Registro Livre** é uma plataforma de dados abertos cujo objetivo principal é colocar à disposição do público informações sobre empresas, imóveis e outros tipos de bens e atividades sujeitos a registro público no Brasil. Embora os dados disponíveis em cartórios e juntas comerciais sejam públicos, eles raramente são publicados. O cidadão que deseja ter acesso a contratos sociais e informações sobre propriedade de imóveis, por exemplo, precisa pagar taxas e aguardar vários dias para receber cópias de documentos. O Registro Livre vai reunir estes dados numa plataforma aberta, para a qual todo cidadão poderá contribuir. Desta forma, os registros públicos serão acessíveis a todos e tornados públicos de fato.

## Tecnologias e dependências
* [Java 8](http://docs.oracle.com/javase/8/)
* [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [SpringBoot](http://projects.spring.io/spring-boot/)
* [Gradle](https://gradle.org/)
* [PostgreSQL](http://www.postgresql.org/)
* [Hibernate](http://hibernate.org/)
* [Bootstrap3](http://getbootstrap.com/)
* [GO](http://www.go.cd/)
* [Vagrant](https://www.vagrantup.com/)
* [JUnit](http://junit.org/)
* [Hamcrest](https://code.google.com/p/hamcrest/wiki/Tutorial)
* [Mockito](http://mockito.org/)
* [Jasmine](http://jasmine.github.io/)
* [Karma](http://karma-runner.github.io/0.13/index.html)
* [Sinon](http://sinonjs.org/)
* [Chai](http://chaijs.com/)


## Pré-requisitos para executar os testes de front-end

### Mac OS X

```
$ brew install node
```

No Mac OS X, instalando somente o 'node', o npm já é incluso.

### Linux

```
$ sudo apt-get update
$ sudo apt-get install nodejs
$ sudo apt-get install npm
```

## Como executar os testes de front-end

```
$ ./gradlew jsTest
```

#  Como fazer o deploy do GO-CD no seu computador

Para ter uma instância do GO-CD executando no seu computador, basta executar o comando abaixo:

```
$ ./gradlew bringUpGoServerLocally
```

Após a inicialização da maquina, execute provisionGoServer para fazer o provisionamento da maquina, o que irá instalar e configurar todos os requisitos necessários:

```
$ ./gradlew provisionGoServerLocally
```

Ao fazer isso o GO-CD será configurado dentro da maquina virtual criada no step anterior, permitindo o acesso ao GO-CD através das configurações informadas no Vagrantfile na pasta infrastructure/go. Se as configurações  padrões foram mantidas, o acesso será através da url:  192.168.33.10:8153/go.

Além disso você pode destruir a maquina virtual executando o comando:

```
$ ./gradlew destroyGoServerLocally
```

E a qualquer momento  verificar o status da maquina virtual usando:

```
$ ./gradlew statusGoServerLocally
```

## Permissões de acesso
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

# Criar Máquina Virtual Local

O ambiente local para executar a aplicação é em uma máquina virtual.
Para criar a máquina virtual no ambiente local, executar o script abaixo:

```
$ ./gradlew bringUpLocalAppServer
```

Para provisionar a máquina local, tem que configurar as variáveis de ambientes antes de executar a task "provisionLocalAppServer":

- Adicione as seguintes variáveis de ambiente:

```
export REGISTROLIVRE_PRIVATE_KEY="caminho_da_chave_privada"
export LOCAL_REGISTROLIVRE_IP="ip_maquina_local"
```

- Provisionamento:

```
$ ./gradlew provisionLocalAppServer
```

Para verificar o status da sua máquina local:

```
$ ./gradlew statusLocalAppServer
```

Para destruir a máquina virtual, se necessário:

```
$ ./gradlew destroyLocalAppServer
```

## Banco de Dados

Para criar o banco de dados local é necessário que sua chave pública esteja presente no diretório infrastructure/application/public_keys.

```
$ ./gradlew createLocalDatabase
```

Para destruir o banco de dados local, se necessário:

```
$ ./gradlew destroyLocalDatabase
```

### Como criar migrations

Migrations devem ser adicionadas no diretório src/main/resources/db/migration/.

#### Nomenclatura

Os arquivos de migration devem seguir o padrão abaixo de nomenclatura.
* Prefixo: V
* Versão: Pontos e underscores separão as partes, você pode usar quantas partes quiser
* Separador: __ (dois underscores)
* Descrição: Underscores separam as palavras
* Sufixo: .sql

**Exemplo**: V1__init.sql

#### Executar migrations

Para executar as migrations na Máquina Virtual é só fazer um novo deploy da aplicação, executando:

```
$ ./gradlew deployLocalAppServer
```

## Deploy da aplicação no ambiente local

Para fazer o deploy da aplicação no ambiente local, antes tem que ter executado as tasks "bringUpLocalAppServer", "provisionLocalAppServer" e "createLocalDatabase"

A task para efetuar o deploy da aplicação:

```
$ ./gradlew deployLocalAppServer
```

Url para acessar a aplicação local: http://192.168.33.71:5000/

# Aplicação em Produção

Url para acessar a aplicação: http://ec2-54-232-246-149.sa-east-1.compute.amazonaws.com:5000/
