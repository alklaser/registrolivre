if [ -z "$(which postgres)" ] || [ "$(which postgres)" == 'postgres not found' ]; then
	rm ~/Downloads/Postgres-9.4.4.1.zip
	wget -P ~/Downloads/ https://github.com/PostgresApp/PostgresApp/releases/download/9.4.4.1/Postgres-9.4.4.1.zip
	unzip ~/Downloads/Postgres-9.4.4.1.zip -d ~/Downloads/
	rm ~/Downloads/Postgres-9.4.4.1.zip
	mv ~/Downloads/Postgres.app /Applications/
	export PATH=$PATH:/Applications/Postgres.app/Contents/Versions/9.4/bin
fi

open -a postgres

sleep 5

psql -c "CREATE ROLE registro_livre WITH ENCRYPTED PASSWORD 'registro_livre' LOGIN;"
psql -c "CREATE DATABASE registro_livre WITH OWNER = registro_livre;"
