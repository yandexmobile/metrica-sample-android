package com.yandex.sample.metrica.authlibrary;

public class AuthenticationError {

    private final int mErrorCode;
    private final String mDescription;

    public AuthenticationError(int errorCode, String description) {
        mErrorCode = errorCode;
        mDescription = description;
    }

    public int getErrorCode() {
        return mErrorCode;
    }
    public String getDescription() {
        return mDescription;
    }

}
