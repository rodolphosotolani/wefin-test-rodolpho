package br.com.rts.wefin.test.wefintestrodolpho.configurations.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientErrorResponse {

    public static final String USERNAME_IS_EMPTY = "username.is.empty";
    public static final String PASSWORD_IS_EMPTY = "password.is.empty";
    public static final String USERNAME_DOES_NOT_EXIST = "user.does.not.exist";
    public static final String USER_OR_PASSWORD_IS_INVALID = "user.or.password.is.invalid";

    public static final String USER_DOES_NOT_EXIST = "user.does.not.exist";
    public static final String PERSON_DOES_NOT_EXIST = "person.does.not.exist";

    public static final String INCONSISTENT_DATA_CHECK_RELATIONSHIPS = "inconsistent.data.check.relationships";

    String clientMessage;
    String developerMessage;

    public static ClientErrorResponse of(String clientMessage, String developerMessage) {
        return new ClientErrorResponse(clientMessage, developerMessage);
    }

    public static ClientErrorResponse singleMessage(String singleMessage) {
        return new ClientErrorResponse(singleMessage, singleMessage);
    }

}
