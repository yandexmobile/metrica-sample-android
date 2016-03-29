package com.yandex.sample.metrica.authlibrary;

import android.accounts.Account;

public interface AuthenticationListener {

    void onSuccess(Account account, String authToken);
    void onError(AuthenticationError error);

}
