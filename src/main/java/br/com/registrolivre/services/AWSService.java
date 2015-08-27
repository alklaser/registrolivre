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
    private AmazonS3 client;

    public AWSService() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY);
        this.client = new AmazonS3Client(credentials);
    }

    public AWSService(AmazonS3 client) {
        this.client = client;
    }

    public String uploadToS3(File file) {
        String fileName = file.getName();
        this.client.putObject(BUCKET_NAME, fileName, file);
        return this.client.generatePresignedUrl(BUCKET_NAME, fileName, null).toString();
    }
}