package br.com.registrolivre.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;

import static br.com.registrolivre.utils.AWSEnviromentVariables.ACCESS_KEY_ID;
import static br.com.registrolivre.utils.AWSEnviromentVariables.SECRET_ACCESS_KEY;

public class AWSService {
    public static final String BUCKET_NAME = "registrolivre";

    public static AmazonS3 client() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY);
        return new AmazonS3Client(credentials);
    }

    public String uploadToS3(AmazonS3 client, String fileName, File file) {
        client.putObject(BUCKET_NAME, fileName, file);
        return client.generatePresignedUrl(BUCKET_NAME, fileName, null).toString();
    }
}
