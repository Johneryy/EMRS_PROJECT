package Exceptions;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(){
        super();
    }
    public DoctorNotFoundException(String message){
        super(message);
    }
    public DoctorNotFoundException(Throwable cause){
        super(cause);
    }
    public DoctorNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
