package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
@FieldDefaults(level = PRIVATE)
@Entity
@Value
@Wither
@EqualsAndHashCode
public class Document {

    public Document(Company company, String url) {
        this.company = company;
        this.url = url;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @OneToOne
    @JoinColumn(name = "company_id")
    Company company;

    @Column(name = "url")
    String url;

    @NoArgsConstructor
    @AllArgsConstructor
    @Value
    @Wither
    @FieldDefaults(level = PRIVATE)
    public static class Builder {
        Long id;
        Company company;
        String url;

        public Document build() {
            return new Document(null, null, null);
        }

        public Document toModel(DocumentRepresentation documentRepresentation) {
            Company company = new Company.Builder()
                    .withId(documentRepresentation.getCompany().getId())
                    .withCnpj(documentRepresentation.getCompany().getCnpj())
                    .withTradeName(documentRepresentation.getCompany().getTradeName())
                    .build();

            return new Document()
                    .withId(documentRepresentation.getId())
                    .withCompany(company)
                    .withUrl(documentRepresentation.getUrl());
        }
    }
}
