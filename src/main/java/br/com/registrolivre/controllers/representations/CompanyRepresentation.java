package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Company;
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
public class CompanyRepresentation {

    @JsonFormat Long id;
    @JsonFormat String cnpj;
    @JsonFormat String tradeName;

    public CompanyRepresentation(String cnpj, String tradeName) {
        this.cnpj = cnpj;
        this.tradeName = tradeName;
    }

    public Company toModel() {
        return new Company(this.cnpj, this.tradeName);
    }

    public static CompanyRepresentation toRepresentation(Company company) {
        return new CompanyRepresentation()
                .withId(company.getId())
                .withCnpj(company.getCnpj())
                .withTradeName(company.getTradeName());
    }
}
