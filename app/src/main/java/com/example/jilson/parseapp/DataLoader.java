package com.example.jilson.parseapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.net.URL;

final class DataLoader extends AsyncTaskLoader<DataModel> {

    private String requestUrl;
    private static final String LOG_TAG = DataLoader.class.getName();

    DataLoader(Context context, String requestUrl) {
        super(context);
        this.requestUrl = requestUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public DataModel loadInBackground() {
        if(requestUrl == null )
        return null;

        DataModel data = HttpRequest.fetchData(requestUrl);
        return data;
    }
}
