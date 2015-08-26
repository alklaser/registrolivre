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
        URI dbUri = new URI(System.getenv(DatabaseEnvironmentVariables.URL));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String databaseUrl = String.format("jdbc:postgresql://%s:%s%s", dbUri.getHost(), dbUri.getPort(), dbUri.getPath());

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
