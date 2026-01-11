package com.vocabularysrs.domain.words;

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

    static InvalidWordException translationFailed(final String word) {
        return new InvalidWordException("Automatic translation failed for word: '" + word + "'. Please enter translation manually.");
    }
}