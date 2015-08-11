package br.com.registrolivre.representations;

import br.com.registrolivre.models.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRepresentation {

    @JsonFormat String cnpj;
    @JsonFormat String tradeName;

    public Company toModel() {
        return new Company(this.cnpj, this.tradeName);
    }
}
