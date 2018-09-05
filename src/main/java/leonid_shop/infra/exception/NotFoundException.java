package main.java.leonid_shop.infra.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Class kClass) {
        super(kClass.getName());
    }
}
