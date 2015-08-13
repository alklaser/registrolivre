package br.com.registrolivre.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Document {

    public Document(Company company, String s3Etag) {
        this.company = company;
        this.s3Etag = s3Etag;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @OneToOne
    @JoinColumn(name="company_id")
    Company company;

    @Column(name = "s3_etag")
    String s3Etag;
}
