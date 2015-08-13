package br.com.registrolivre.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Document {

    public Document(Long companyId, String s3Etag) {
        this.companyId = companyId;
        this.s3Etag = s3Etag;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @OneToOne
    @JoinColumn(name="company_id")
    Long companyId;

    @Column(name = "s3_etag")
    String s3Etag;


}
