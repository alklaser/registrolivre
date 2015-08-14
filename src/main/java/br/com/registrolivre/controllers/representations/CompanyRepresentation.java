package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Company;
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
public class CompanyRepresentation {

    @JsonFormat Long id;
    @JsonFormat String cnpj;
    @JsonFormat String tradeName;

    public CompanyRepresentation(String cnpj, String tradeName) {
        this.cnpj = cnpj;
        this.tradeName = tradeName;
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

        public CompanyRepresentation build() {
            return new CompanyRepresentation(null, null, null);
        }

        public CompanyRepresentation toRepresentation(Company company) {
            return new CompanyRepresentation()
                    .withId(company.getId())
                    .withCnpj(company.getCnpj())
                    .withTradeName(company.getTradeName());
        }
    }
}
