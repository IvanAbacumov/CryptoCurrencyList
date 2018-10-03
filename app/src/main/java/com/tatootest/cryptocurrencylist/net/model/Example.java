package com.tatootest.cryptocurrencylist.net.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("data")
    @Expose
    private List<Value> values = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}