package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Wither
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentRepresentation {
    @JsonFormat Long id;
    @JsonFormat CompanyRepresentation company;
    @JsonFormat
    String S3_etag;

    public DocumentRepresentation(CompanyRepresentation company, String s3Etag) {
        this.company = company;
        this.S3_etag = s3Etag;
    }

    public Document toModel() {
        return new Document(this.company.toModel(), this.S3_etag);
    }

}
