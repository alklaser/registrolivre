package br.com.registrolivre.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static br.com.registrolivre.utils.EnvironmentVariables.REGISTROLIVRE_AWS_ACCESS_KEY_ID;
import static br.com.registrolivre.utils.EnvironmentVariables.REGISTROLIVRE_AWS_SECRET_ACCESS_KEY;

public class AWSService {
    public static final String BUCKET_NAME = "registrolivre";
    public static final Date DATE_EXPIRATION = null;

    public static AmazonS3 client() {
        AWSCredentials credentials = new BasicAWSCredentials(REGISTROLIVRE_AWS_ACCESS_KEY_ID, REGISTROLIVRE_AWS_SECRET_ACCESS_KEY);
        return new AmazonS3Client(credentials);
    }

    public String uploadToS3(AmazonS3 client, String fileName) throws IOException {
        String[] prefixSuffix = fileName.split(".");
        File file = File.createTempFile(prefixSuffix[0], prefixSuffix[1]);
        client.putObject(BUCKET_NAME, fileName, file);
        return client.generatePresignedUrl(BUCKET_NAME, fileName, DATE_EXPIRATION).toString();
    }
}
