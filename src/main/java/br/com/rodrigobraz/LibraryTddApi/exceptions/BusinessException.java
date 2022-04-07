package br.com.rodrigobraz.LibraryTddApi.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg);
    }
}
