package br.com.registrolivre.services;

import com.amazonaws.services.s3.AmazonS3;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AWSServiceTest {
    @Mock
    private AmazonS3 client;

    AWSService awsService;

    @Before
    public void setUp() {
        initMocks(this);
        awsService = new AWSService(client);
    }

    @Test
    public void shouldCheckIfUploadIsCalled() throws IOException {
        File arquivo = new File("nomeDoArquivo");
        URL url = new URL("http://url.com/nomeDoArquivo");
        when(client.generatePresignedUrl("registrolivre", "nomeDoArquivo", null)).thenReturn(url);
        assertThat(awsService.uploadToS3(arquivo), is("http://url.com/nomeDoArquivo"));

        verify(client).putObject("registrolivre", "nomeDoArquivo", arquivo);
    }
}
