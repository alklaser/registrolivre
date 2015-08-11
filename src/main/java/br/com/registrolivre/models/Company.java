package br.com.registrolivre.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Company {

    public Company(String cnpj, String tradeName) {
        this.cnpj = cnpj;
        this.tradeName = tradeName;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    @Column(name = "cnpj")
    String cnpj;

    @Column(name = "trade_name")
    String tradeName;


}
