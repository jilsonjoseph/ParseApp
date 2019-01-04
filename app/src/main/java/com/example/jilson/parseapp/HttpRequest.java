package com.example.jilson.parseapp;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

final class HttpRequest {

    // Tag for Log
    private static final String LOG_TAG = HttpRequest.class.getSimpleName();

    /**
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name HttpRequest (and an object instance of HttpRequest is not needed).
     */
    private HttpRequest() {
    }

    //Function to fetch data
    static DataModel fetchData(String requestUrl){
        Log.v(LOG_TAG,"in fetchData method ");
        URL url = createURL(requestUrl);

        if(url == null){
            return null;
        }

        String jsonResponse = null;

        try{
            jsonResponse = makeHttpRequest(url);
        }catch (IOException e){
            Log.e(LOG_TAG, "Error in making HttpRequest", e);
        }

        return extractDataFromJSON(jsonResponse);
    }

    //Creates a URL
    private static URL createURL(String stringUrl){
        Log.v(LOG_TAG,"in createURL method");
        URL url = null;
        try {
            url = new URL(stringUrl);
        }catch (MalformedURLException e){
            Log.e(LOG_TAG,"Error in creating URL",e);
        }
        return url;
    }

    // This function makes http request and returns JŚON response
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /*milliseconds*/);
            urlConnection.setConnectTimeout(15000 /*milliseconds*/);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //checking if the request was successfull
            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        }catch (IOException e) {
            Log.e(LOG_TAG, "Ērror in retrieving JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream)throws IOException{
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();

    }

    private static DataModel extractDataFromJSON(String jsonResponse) {
        Log.v(LOG_TAG," in extractDataFromJSON method");

        // Create an empty DataModel to add the extracted values
        DataModel dm = new DataModel();

        String inrKeys[] = {"ETH", "BTC", "LTC", "XRP", "OMG", "REQ", "ZRX", "GNT", "BAT",
                "AE", "TRX", "XLM", "NEO", "GAS", "XRB", "NCASH", "EOS", "CMT", "ONT", "ZIL",
                "IOST", "ACT", "ZCO", "SNT", "POLY", "ELF", "REP", "QKC", "XZC", "BCHABC",
                "TUSD", "BCHSV"};

        String bitcoinKeys[] = {"TUSD", "LTC", "NCASH", "XRP", "OMG", "EOS", "REQ", "ETH",
                "ZCO", "TRX", "BCHABC"};

        String etherKeys[] = {"XRP", "TRX", "TUSD", "LTC", "OMG", "EOS", "ZCO", "BCHABC"};

        String rippleKeys[] ={"CMT", "LTC", "NCASH", "AE", "EOS", "GNT", "REQ", "OMG", "ONT",
                "ZIL", "IOST", "ACT", "ZCO", "SNT", "POLY", "ELF", "TRX", "REP", "QKC", "XZC",
                "TUSD"};

        // Parsing JSON Response.
        try {
            JSONObject response = new JSONObject(jsonResponse);
            if(response.has("prices")){
                JSONObject prices = response.getJSONObject("prices");
                JSONObject inr = null, bitcoin = null, ether = null, ripple = null;
                if(prices.has("inr"))
                    inr = prices.getJSONObject("inr");
                if(prices.has("bitcoin"))
                    bitcoin = prices.getJSONObject("bitcoin");
                if(prices.has("ether"))
                    ether = prices.getJSONObject("ether");
                if(prices.has("ripple"))
                    ripple = prices.getJSONObject("ripple");

                HashMap<String,Double> inrMap = new HashMap<>();
                HashMap<String,Double> bitcoinMap = new HashMap<>();
                HashMap<String,Double> etherMap = new HashMap<>();
                HashMap<String,Double> rippleMap = new HashMap<>();

                for(int i = 0; (i< inrKeys.length)&& (inr != null);i++){
                    if(inr.has(inrKeys[i]))
                        inrMap.put(inrKeys[i],inr.getDouble(inrKeys[i]));
                }

                for(int i = 0; (i< bitcoinKeys.length)&& (bitcoin != null);i++){
                    if(bitcoin.has(bitcoinKeys[i]))
                        bitcoinMap.put(bitcoinKeys[i],bitcoin.getDouble(bitcoinKeys[i]));
                }

                for(int i = 0; (i< etherKeys.length)&& (ether != null);i++){
                    if(ether.has(etherKeys[i]))
                        etherMap.put(etherKeys[i],ether.getDouble(etherKeys[i]));
                }

                for(int i = 0; (i< rippleKeys.length)&& (ripple != null);i++){
                    if(ripple.has(inrKeys[i]))
                        rippleMap.put(rippleKeys[i],ripple.getDouble(rippleKeys[i]));
                }

                Field<Double> pricesObject = new Field<Double>();
                pricesObject.setInr(inrMap);
                pricesObject.setBitcoin(bitcoinMap);
                pricesObject.setEther(etherMap);
                pricesObject.setRipple(rippleMap);

                dm.setPrices(pricesObject);

            }


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Error in parsing story JSON results", e);
        }

        // Return the list of news stories
        return dm;
    }
}
