package br.com.registrolivre;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicationTest {


    Hello hello = mock(Hello.class);

    @Test
    public void someDummyTest() throws Exception {
        when(hello.getHelloMessage()).thenReturn("test");
        assertThat("test", is(hello.getHelloMessage()));
    }
}
