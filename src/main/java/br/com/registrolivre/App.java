package br.com.registrolivre;

import br.com.registrolivre.sample.flyway.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        new App().run();
    }

    public void run () {
        System.err.println(repository.findAll());
    }

}
