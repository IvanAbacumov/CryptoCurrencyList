package com.tatootest.cryptocurrencylist.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.tatootest.cryptocurrencylist.net.RestManager;
import com.tatootest.cryptocurrencylist.net.model.Example;
import com.tatootest.cryptocurrencylist.net.model.Value;
import com.tatootest.cryptocurrencylist.source.IModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLProtocolException;

import retrofit2.Call;
import retrofit2.Response;

public class LoadCryptoCurrencyAsyncTask extends AsyncTask<Void, Void, ArrayList<Value>> {

    public RestManager mRestManager;
    Call<Example> listCall;
    Response<Example> responseInfo;
    Example a;

    ArrayList<Value> listCryptoCurrencyValue;
    private final IModel.CryptoCurrencyServiceCallback mCallback;

    public LoadCryptoCurrencyAsyncTask(IModel.CryptoCurrencyServiceCallback callback) {
        mCallback = callback;
    }

    @Override
    protected ArrayList<Value> doInBackground(Void... voids) {

        mRestManager = new RestManager();
        listCall = mRestManager.getCryptoCurrencyService().getListObject();

        Log.d("listCall",listCall.request().url().toString());

        try {
            responseInfo = listCall.execute();
            //Log.d("responseInfo",responseInfo.message());
             a = responseInfo.body();
            listCryptoCurrencyValue = new ArrayList<>();

            listCryptoCurrencyValue.addAll(a.getValues());
             Log.d("responseInfo",String.valueOf(listCryptoCurrencyValue.size()));

        }
        catch (IOException e) {
            Log.d("IOException",e.getMessage());
        }


        return listCryptoCurrencyValue;
    }


    @Override
    protected void onPostExecute(ArrayList<Value> listCryptoCurrencyValue) {


        if (listCryptoCurrencyValue != null) {
            mCallback.onSuccess(listCryptoCurrencyValue);
        } else {
            mCallback.onFailure();
        }
    }

}