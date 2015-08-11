package br.com.registrolivre.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    @Column(name = "cnpj")
    String cnpj;

    @Column(name = "trade_name")
    String tradeName;

}
