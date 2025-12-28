package com.vocabularysrs.domain.dictionary;

class InvalidWordException extends RuntimeException {

    InvalidWordException(String message) {
        super(message);
    }

    static InvalidWordException wordIsNull() {
        return new InvalidWordException("Word must not be null");
    }

    static InvalidWordException translateIsNull() {
        return new InvalidWordException("Translate must not be null");
    }
}