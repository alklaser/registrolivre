#!/bin/bash

## Script de instalação do projeto Registro Livre
## Repositório oficial do projeto: https://github.com/aceleradora6-tw/RegistroLivre

## Instalando o postgreSQL
sudo apt-get update
sudo apt-get install postgresql postgresql-contrib

## Configura o Postgres para tirar os acentos dos dados.
sudo -u postgres psql -c "CREATE EXTENSION IF NOT EXISTS unaccent;"

## Isntalando o Maven
sudo apt-get install maven

## Configurando o postgreSQL
if [ -z "$DB_CONNECTION_USUARIO" ] && [ -z "$DB_CONNECTION_SENHA"]; then
	echo '[DIGITE O USUARIO DO BANCO]:'
	read usuario
	echo "export DB_CONNECTION_USUARIO=$usuario" >> ~/.bashrc

	echo '[DIGITE A SENHA DO BANCO]:'
	read senha
	echo "export DB_CONNECTION_SENHA=$senha">> ~/.bashrc

	sudo -u postgres psql -c "CREATE USER $usuario WITH PASSWORD '$senha'"
fi

if [ -z "$DB_CONNECTION_URL" ]; then
	echo 'export DB_CONNECTION_URL="jdbc:postgresql://localhost/registro_livre"' >> ~/.bashrc
fi

## Configurando as informações do Cloudinary
## Caso não saiba o que são essas informações, leia o README do projeto.
if [ -z "$API_SECRET" ]; then
	echo '[DIGITE O SECRET DO CLOUDINARY]:'
	read api_secret
	echo "export API_SECRET=$api_secret" >> ~/.bashrc
fi

if [ -z  "$API_KEY" ]; then
	echo '[DIGITE O API KEY DO CLOUDINARY]:'
	read api_key
	echo "export API_KEY=$api_key" >> ~/.bashrc
fi

if [ -z "$CLOUD_NAME" ]; then
	echo '[DIGITE O CLOUD NAME DO CLOUDINARY]:'
	read cloud_name
	echo "export CLOUD_NAME=$cloud_name">>~/.bashrc
fi

if [ -z "$SENHA_EMAIL" ]; then
	echo '[DIGITE A SENHA PARA O EMAIL DE CONTATO]:'
	read senha_email
	echo "export SENHA_EMAIL=$senha_email">>~/.bashrc
fi

## Configurando as variáveis de ambiente do Selenium
if [ -z "$WEBDRIVER_PATH" ]; then
	echo "export WEBDRIVER_PATH=$PWD/src/main/resources/chromedriver">>~/.bashrc
fi

if [ -z "$URL_ENV_TESTE" ]; then
	echo "export URL_ENV_TESTE=http://localhost:8080">>~/.bashrc
fi

exec bash
