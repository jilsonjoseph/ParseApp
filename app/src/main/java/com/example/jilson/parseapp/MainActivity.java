package com.example.jilson.parseapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<DataModel> {

    private static final String REQUEST_URL = "https://koinex.in/api/ticker";
    public static final String LOG_TAG = MainActivity.class.getName();

    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);

        // Using Loader to fetch data in a bockground thread
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(1,null,this);
    }

    private void updateUi(DataModel data){
        Log.v(LOG_TAG,"in updateUi method");
        text1.setText(data.getPrices().getInr().get("ETH").toString());
    }

    @Override
    public Loader<DataModel> onCreateLoader(int i, Bundle bundle) {
        return new DataLoader(this,REQUEST_URL);
    }


    @Override
    public void onLoadFinished(Loader<DataModel> loader, DataModel data) {
        if(data == null) {
            Log.v(LOG_TAG," null is returned to onLoad finish method");
            return;
        }
        updateUi(data);
    }

    @Override
    public void onLoaderReset(Loader<DataModel> loader) {

    }
}
