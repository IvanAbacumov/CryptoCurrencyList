package com.tatootest.cryptocurrencylist.contracts;

import com.tatootest.cryptocurrencylist.net.model.Value;

import java.util.ArrayList;

public interface Contract {
    interface MainCryptoCurrency{

        interface PresenterCryptoCurrency{
            void loadCryptoCurrencyData();
            void clickCryptoCurrencyItem(String item);
        }

        interface ViewCryptoCurrency{
            void showCryptoCurrency(ArrayList<Value> cryptoCurrencyList);
            //void update();
        }
    }
}
