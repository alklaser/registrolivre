package br.com.registrolivre.configurations;

import br.com.registrolivre.utils.DatabaseEnvironmentVariables;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI databaseUri = new URI(System.getenv(DatabaseEnvironmentVariables.URL));

        String userName = databaseUri.getUserInfo().split(":")[0];
        String password = databaseUri.getUserInfo().split(":")[1];
        String databaseUrl = String.format("jdbc:postgresql://%s:%s%s", databaseUri.getHost(), databaseUri.getPort(), databaseUri.getPath());

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseUrl);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
