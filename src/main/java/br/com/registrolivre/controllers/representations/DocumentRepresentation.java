package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.models.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;

import static lombok.AccessLevel.*;

@NoArgsConstructor
@AllArgsConstructor
@Value
@Wither
@FieldDefaults(level = PRIVATE)
public class DocumentRepresentation {
    @JsonFormat Long id;
    @JsonFormat CompanyRepresentation company;
    @JsonFormat String s3Etag;

    public DocumentRepresentation(CompanyRepresentation company, String s3Etag) {
        this.company = company;
        this.s3Etag = s3Etag;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Value
    @Wither
    @FieldDefaults(level = PRIVATE)
    public static class Builder {

        Long id;
        String cnpj;
        String tradeName;

        public DocumentRepresentation build() {
            return new DocumentRepresentation(null, null, null);
        }

        public DocumentRepresentation toRepresentantion(Document document) {
            CompanyRepresentation companyRepresentation = new CompanyRepresentation.Builder()
                    .withId(document.getCompany().getId())
                    .withCnpj(document.getCompany().getCnpj())
                    .withTradeName(document.getCompany().getTradeName())
                    .build();

            return new DocumentRepresentation()
                    .withId(document.getId())
                    .withCompany(companyRepresentation)
                    .withS3Etag(document.getS3Etag());
        }
    }
}
