package br.com.registrolivre.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
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


}
