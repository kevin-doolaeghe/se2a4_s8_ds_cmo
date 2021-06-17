package fr.kevin.cmo.mails;

public class CompteErreurException extends Exception {

    public CompteErreurException(String message) {
        super(message);
    }

    public CompteErreurException(String message, Throwable cause) {
        super(message, cause);
    }

}
