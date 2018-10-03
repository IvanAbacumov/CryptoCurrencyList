package com.tatootest.cryptocurrencylist.presenters;

import android.util.Log;

import com.tatootest.cryptocurrencylist.contracts.Contract;
import com.tatootest.cryptocurrencylist.net.model.Value;
import com.tatootest.cryptocurrencylist.source.IModel;
import com.tatootest.cryptocurrencylist.source.MainModel;

import java.util.ArrayList;

public class MainPresenter implements Contract.MainCryptoCurrency.PresenterCryptoCurrency {

    private final Contract.MainCryptoCurrency.ViewCryptoCurrency mView;
    private final MainModel mainModel;

    private ArrayList<Value> cryptoCurrencyArrayList  ;

    public ArrayList<Value> getStringArrayList() {
        return cryptoCurrencyArrayList;
    }

    public void setStringArrayList(ArrayList<Value> cryptoCurrencyArrayList) {
        this.cryptoCurrencyArrayList = cryptoCurrencyArrayList;
    }

    public MainPresenter(Contract.MainCryptoCurrency.ViewCryptoCurrency mView, MainModel mainModel) {
        this.mView = mView;
        this.mainModel = mainModel;
        this.cryptoCurrencyArrayList = new ArrayList<>();
    }


    @Override
    public void loadCryptoCurrencyData() {

            mainModel.getAllCryptoCurrency(new IModel.CryptoCurrencyServiceCallback<ArrayList<Value>>() {
                @Override
                public void onSuccess(ArrayList<Value> cryptoCurrencyList) {

                    cryptoCurrencyArrayList = cryptoCurrencyList;
                    mView.showCryptoCurrency(cryptoCurrencyList);

                    Log.d("presenter","onSuccess");

                }

                @Override
                public void onFailure() {
                    Log.d("presenter","onFailure");
                }
            });

    }

    @Override
    public void clickCryptoCurrencyItem(String item) {

    }
}
