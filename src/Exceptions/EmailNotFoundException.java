package Exceptions;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EmailNotFoundException(String message){
        super(message);
    }
    public EmailNotFoundException(){
        super();
    }
    public EmailNotFoundException(Throwable cause){
        super(cause);
    }
}
