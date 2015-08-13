package br.com.registrolivre.controllers;


import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DocumentController {

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ResponseEntity getDocumentUrl(DocumentRepresentation documentRepresentation) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
