package br.com.registrolivre.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Created by idiesel on 8/12/15.
 */
public class AmazonAPI {
    public static final String BUCKET_NAME = "documentos-empresas";

    public static AmazonS3 getS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials("YourAccessKeyID", "YourSecretAccessKey");
        return new AmazonS3Client(credentials);
    }
}
