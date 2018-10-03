package com.tatootest.cryptocurrencylist.source;

import com.tatootest.cryptocurrencylist.asynctask.LoadCryptoCurrencyAsyncTask;
import com.tatootest.cryptocurrencylist.net.model.Value;

import java.util.ArrayList;

public class MainModel implements IModel{
    @Override
    public void getAllCryptoCurrency(CryptoCurrencyServiceCallback<ArrayList<Value>> callback) {

        new LoadCryptoCurrencyAsyncTask(callback).execute();

    }
}
