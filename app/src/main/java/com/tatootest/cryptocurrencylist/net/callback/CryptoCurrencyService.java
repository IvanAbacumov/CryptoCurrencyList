package com.tatootest.cryptocurrencylist.net.callback;

import com.tatootest.cryptocurrencylist.net.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoCurrencyService {
    @GET("/v2/listings/")
    Call<Example> getListObject();
}
