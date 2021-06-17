package fr.kevin.cmo.mails;

public class CompteInconnuException extends Throwable {

    public CompteInconnuException(String message) {
        super(message);
    }

    public CompteInconnuException(String message, Throwable cause) {
        super(message, cause);
    }

}
