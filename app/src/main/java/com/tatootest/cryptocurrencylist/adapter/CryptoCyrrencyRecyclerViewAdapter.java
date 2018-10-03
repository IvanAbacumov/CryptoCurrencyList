package com.tatootest.cryptocurrencylist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tatootest.cryptocurrencylist.R;
import com.tatootest.cryptocurrencylist.net.model.Value;

import java.util.ArrayList;

public class CryptoCyrrencyRecyclerViewAdapter extends RecyclerView.Adapter<CryptoCyrrencyRecyclerViewAdapter.ViewHolder>{


    private Context ctx;
    private ArrayList<Value> cryptoCurrencyList; // = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView title_symbol, title_name;

        public ViewHolder(View view) {
            super(view);

            title_symbol = view.findViewById(R.id.title_symbol);
            title_name = view.findViewById(R.id.title_name);

        }
    }


    public CryptoCyrrencyRecyclerViewAdapter(Context ctx, ArrayList<Value> cryptoCurrencyList) {

        this.ctx = ctx;
        this.cryptoCurrencyList = cryptoCurrencyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(itemView);
    }

    public void update(ArrayList<Value> cryptoCurrencyListUpdate) {
        cryptoCurrencyList = cryptoCurrencyListUpdate;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //String urlPhoto = photosList.get(position);

        holder.title_symbol.setText(cryptoCurrencyList.get(position).getSymbol());
        holder.title_name.setText(cryptoCurrencyList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(),
                        "Open image!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cryptoCurrencyList.size();
    }
}
