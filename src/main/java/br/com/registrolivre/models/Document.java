package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import lombok.*;
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
@EqualsAndHashCode(exclude = "company")
@ToString(exclude = "company")
public class Document {

    public Document(Company company, String url) {
        this.company = company;
        this.url = url;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
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

        public Document toModel(DocumentRepresentation representation) {
            return new Document()
                    .withId(representation.getId())
                    .withUrl(representation.getUrl());
        }
    }
}
