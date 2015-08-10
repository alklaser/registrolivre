package br.com.registrolivre.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Empresa {

     @Getter String cnpj;
     @Getter String nomeFantasia;

}
