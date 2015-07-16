package br.com.aceleradora.registrolivre.validador.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.aceleradora.registrolivre.validador.validacoes.CPFValidador;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPFValidador.class)
public @interface CPFValido {
	
	String message() default "Os CPFs precisam ser válidos.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
