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
    @JsonFormat Long company_id;
    @JsonFormat String S3_etag;

    public DocumentRepresentation(Long companyId, String s3Etag) {
        this.company_id = companyId;
        this.S3_etag = s3Etag;
    }
    public Document toModel() {
        return new Document(this.company_id, this.S3_etag);
    }

}
