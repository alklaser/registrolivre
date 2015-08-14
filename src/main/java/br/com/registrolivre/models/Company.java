package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Value
@Wither
@EqualsAndHashCode
public class Company {

    public Company(String cnpj, String tradeName) {
        this.cnpj = cnpj;
        this.tradeName = tradeName;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @NotNull @CNPJ
    @Column(name = "cnpj")
    String cnpj;

    @Column(name = "trade_name")
    String tradeName;

    @NoArgsConstructor
    @AllArgsConstructor
    @Value
    @Wither
    @FieldDefaults(level = PRIVATE)
    public static class Builder {

        Long id;
        String cnpj;
        String tradeName;

        public Company build() {
            return new Company(null, null, null);
        }

        public Company toModel(CompanyRepresentation companyRepresentation) {
            return new Company()
                    .withId(companyRepresentation.getId())
                    .withCnpj(companyRepresentation.getCnpj())
                    .withTradeName(companyRepresentation.getTradeName());
        }
    }

}
