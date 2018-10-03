package com.tatootest.cryptocurrencylist.source;

import com.tatootest.cryptocurrencylist.net.model.Value;

import java.util.ArrayList;

public interface IModel {
    interface CryptoCurrencyServiceCallback<T> {
        void onSuccess(T cryptoCurrency);
        void onFailure();
    }

    void getAllCryptoCurrency(CryptoCurrencyServiceCallback<ArrayList<Value>> callback);
}
