package br.com.rts.wefin.test.wefintestrodolpho.configurations.validation;

import br.com.rts.wefin.test.wefintestrodolpho.exception.PessoaNotFoundException;
import br.com.rts.wefin.test.wefintestrodolpho.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class EntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(PessoaNotFoundException.class)
    public ClientErrorResponse handlePessoaNotFound(PessoaNotFoundException e) {
        return ClientErrorResponse.singleMessage(ClientErrorResponse.PERSON_DOES_NOT_EXIST);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ClientErrorResponse handleUsuarioNotFound(UsuarioNotFoundException e) {
        return ClientErrorResponse.singleMessage(ClientErrorResponse.USER_DOES_NOT_EXIST);
    }
}