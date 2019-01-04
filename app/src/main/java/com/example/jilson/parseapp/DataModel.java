package com.example.jilson.parseapp;

import java.util.HashMap;

final class DataModel {

    private Field<Double> prices;
    private Field<Details> stats;

    // Setter
    public void setPrices(Field<Double> prices) {
        this.prices = prices;
    }

    // Getter
    public Field getPrices() {
        return prices;
    }
}

 class Field<V> {
    private HashMap<String,V> inr;
    private HashMap<String,V> bitcoin;
    private HashMap<String,V> ether;
    private HashMap<String,V> ripple;

    // Setters

    public void setInr(HashMap<String, V> inr) {
     this.inr = inr;
    }

    public void setBitcoin(HashMap<String, V> bitcoin) {
     this.bitcoin = bitcoin;
    }

    public void setEther(HashMap<String, V> ether) {
     this.ether = ether;
    }

    public void setRipple(HashMap<String, V> ripple) {
     this.ripple = ripple;
    }

    //Getters


     public HashMap<String, V> getInr() {
         return inr;
     }

     public HashMap<String, V> getBitcoin() {
         return bitcoin;
     }

     public HashMap<String, V> getEther() {
         return ether;
     }

     public HashMap<String, V> getRipple() {
         return ripple;
     }
 }

 class Details{
    private Double highestBid;
    private Double lowestAsk;
    private Double lastTradedPrice;
    private Double min24Hrs;
    private Double vol24Hrs;
    private String currencyFullForm;
    private String currencyShortForm;
    private Double perChange;
    private Double tradeVolume;

    //Setters


     public void setHighestBid(Double highestBid) {
         this.highestBid = highestBid;
     }

     public void setLowestAsk(Double lowestAsk) {
         this.lowestAsk = lowestAsk;
     }

     public void setLastTradedPrice(Double lastTradedPrice) {
         this.lastTradedPrice = lastTradedPrice;
     }

     public void setMin24Hrs(Double min24Hrs) {
         this.min24Hrs = min24Hrs;
     }

     public void setVol24Hrs(Double vol24Hrs) {
         this.vol24Hrs = vol24Hrs;
     }

     public void setCurrencyFullForm(String currencyFullForm) {
         this.currencyFullForm = currencyFullForm;
     }

     public void setCurrencyShortForm(String currencyShortForm) {
         this.currencyShortForm = currencyShortForm;
     }

     public void setPerChange(Double perChange) {
         this.perChange = perChange;
     }

     public void setTradeVolume(Double tradeVolume) {
         this.tradeVolume = tradeVolume;
     }

     //Getters

     public Double getHighestBid() {
         return highestBid;
     }

     public Double getLowestAsk() {
         return lowestAsk;
     }

     public Double getLastTradedPrice() {
         return lastTradedPrice;
     }

     public Double getMin24Hrs() {
         return min24Hrs;
     }

     public Double getVol24Hrs() {
         return vol24Hrs;
     }

     public String getCurrencyFullForm() {
         return currencyFullForm;
     }

     public String getCurrencyShortForm() {
         return currencyShortForm;
     }

     public Double getPerChange() {
         return perChange;
     }

     public Double getTradeVolume() {
         return tradeVolume;
     }
 }
