package br.com.registrolivre.representations;

import br.com.registrolivre.models.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRepresentation {

    @JsonFormat Long id;
    @JsonFormat String cnpj;
    @JsonFormat String tradeName;

    public Company toModel() {
        return new Company(this.cnpj, this.tradeName);
    }
}
