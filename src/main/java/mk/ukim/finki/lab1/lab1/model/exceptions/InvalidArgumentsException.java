package mk.ukim.finki.lab1.lab1.model.exceptions;

public class InvalidArgumentsException extends RuntimeException{
    public InvalidArgumentsException() {
        super("Please fill all inputs!");
    }
}
