package com.tatootest.cryptocurrencylist.net;

import com.tatootest.cryptocurrencylist.net.callback.CryptoCurrencyService;
import com.tatootest.cryptocurrencylist.net.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestManager {

    private CryptoCurrencyService cryptoCurrencyService;


    public CryptoCurrencyService getCryptoCurrencyService(){
        if(cryptoCurrencyService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            cryptoCurrencyService = retrofit.create(CryptoCurrencyService.class);
        }
        return cryptoCurrencyService;
    }

}
