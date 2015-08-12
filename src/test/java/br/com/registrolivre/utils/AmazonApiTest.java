package br.com.registrolivre.utils;

import com.amazonaws.services.s3.AmazonS3;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by idiesel on 8/12/15.
 */
public class AmazonApiTest {

    @Test
    public void shouldReturnS3Client() throws Exception {
        AmazonS3 api = AmazonAPI.getS3Client();
       // when(api.getObject(anyString(), anyString())).thenReturn(new S3Object());
       // S3Object object = api.getObject(AmazonAPI.BUCKET_NAME, "key");
        assertNotNull(api);
    }



}
