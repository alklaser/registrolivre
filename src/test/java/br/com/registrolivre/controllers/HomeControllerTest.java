package br.com.registrolivre.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HomeControllerTest {
    private HomeController homeController;

    @Before
    public void setUp() {
        homeController = new HomeController();
    }
    
    @Test
    public void testHome() {
        String result = homeController.home();
        assertThat(result, is("index"));
    }
}