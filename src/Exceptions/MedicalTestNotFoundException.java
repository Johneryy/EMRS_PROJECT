package Exceptions;

public class MedicalTestNotFoundException extends RuntimeException{
    public MedicalTestNotFoundException(){
        super();
    }
    public MedicalTestNotFoundException(String message){
        super(message);
    }
    public MedicalTestNotFoundException(Throwable cause){
        super(cause);
    }
    public MedicalTestNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
