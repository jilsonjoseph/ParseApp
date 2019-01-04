package com.example.jilson.parseapp;

import java.util.HashMap;

final class DataModel {

    private Field<Double> prices;
    private Field<Details> stats;

    // Setter
    void setPrices(Field<Double> prices) {
        this.prices = prices;
    }

    void setStats(Field<Details> stats) {
        this.stats = stats;
    }

    // Getter
    Field getPrices() {
        return prices;
    }

    Field<Details> getStats() {
        return stats;
    }
}

 class Field<V> {
    private HashMap<String,V> inr;
    private HashMap<String,V> bitcoin;
    private HashMap<String,V> ether;
    private HashMap<String,V> ripple;

    // Setters
    void setInr(HashMap<String, V> inr) {
     this.inr = inr;
    }

    void setBitcoin(HashMap<String, V> bitcoin) {
     this.bitcoin = bitcoin;
    }

    void setEther(HashMap<String, V> ether) {
     this.ether = ether;
    }

    void setRipple(HashMap<String, V> ripple) {
     this.ripple = ripple;
    }

    //Getters


     HashMap<String, V> getInr() {
         return inr;
     }

     HashMap<String, V> getBitcoin() {
         return bitcoin;
     }

     HashMap<String, V> getEther() {
         return ether;
     }

     HashMap<String, V> getRipple() {
         return ripple;
     }
 }

 class Details{
    private Double highestBid;
    private Double lowestAsk;
    private Double lastTradedPrice;
    private Double min24Hrs;
    private Double max24Hrs;
    private Double vol24Hrs;
    private String currencyFullForm;
    private String currencyShortForm;
    private Double perChange;
    private Double tradeVolume;

    //Setters


     void setHighestBid(Double highestBid) {
         this.highestBid = highestBid;
     }

     void setLowestAsk(Double lowestAsk) {
         this.lowestAsk = lowestAsk;
     }

     void setLastTradedPrice(Double lastTradedPrice) {
         this.lastTradedPrice = lastTradedPrice;
     }

     void setMin24Hrs(Double min24Hrs) {
         this.min24Hrs = min24Hrs;
     }

     void setMax24Hrs(Double max24Hrs) {
         this.max24Hrs = max24Hrs;
     }

     void setVol24Hrs(Double vol24Hrs) {
         this.vol24Hrs = vol24Hrs;
     }

     void setCurrencyFullForm(String currencyFullForm) {
         this.currencyFullForm = currencyFullForm;
     }

     void setCurrencyShortForm(String currencyShortForm) {
         this.currencyShortForm = currencyShortForm;
     }

     void setPerChange(Double perChange) {
         this.perChange = perChange;
     }

     void setTradeVolume(Double tradeVolume) {
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

     public Double getMax24Hrs() {
         return max24Hrs;
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
