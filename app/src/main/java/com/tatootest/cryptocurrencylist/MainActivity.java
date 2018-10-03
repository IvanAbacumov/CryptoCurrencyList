package com.tatootest.cryptocurrencylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tatootest.cryptocurrencylist.adapter.CryptoCyrrencyRecyclerViewAdapter;
import com.tatootest.cryptocurrencylist.contracts.Contract;
import com.tatootest.cryptocurrencylist.net.model.Value;
import com.tatootest.cryptocurrencylist.presenters.MainPresenter;
import com.tatootest.cryptocurrencylist.source.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Contract.MainCryptoCurrency.ViewCryptoCurrency {

    private MainPresenter mPresenter;
    public ArrayList<Value> cryptoCurrencyList;

    public CryptoCyrrencyRecyclerViewAdapter mAdapter;
    RecyclerView cryptoCurrencyRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(MainActivity.this, new MainModel());
        createRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadCryptoCurrencyData();

    }

    @Override
    public void showCryptoCurrency(ArrayList<Value> cryptoCurrencyList) {
        mAdapter = new CryptoCyrrencyRecyclerViewAdapter(MainActivity.this, cryptoCurrencyList);
        cryptoCurrencyRecyclerView.setAdapter(mAdapter);
        //Log.d("TESTTESTTEST", String.valueOf(cryptoCurrencyList.size()));
    }



    public void  createRecyclerView() {

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);

        cryptoCurrencyList = new ArrayList<>();

        cryptoCurrencyRecyclerView = findViewById(R.id.recyclerViewPhotos);
        cryptoCurrencyRecyclerView.setHasFixedSize(true);
        cryptoCurrencyRecyclerView.setLayoutManager(llm);
        cryptoCurrencyRecyclerView.setAdapter(mAdapter);
    }

}
