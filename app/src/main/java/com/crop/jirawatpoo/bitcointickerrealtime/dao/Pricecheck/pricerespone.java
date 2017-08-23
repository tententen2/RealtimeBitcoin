package com.crop.jirawatpoo.bitcointickerrealtime.dao.Pricecheck;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jirawat.poo on 8/22/2017 AD.
 */

public class pricerespone {


    @SerializedName("trades")
    private List<TradesBean> trades;
    @SerializedName("lowask")
    private List<LowaskBean> lowask;
    @SerializedName("highbid")
    private List<HighbidBean> highbid;
    @SerializedName("user_orders")
    private List<?> userOrders;

    public List<TradesBean> getTrades() {
        return trades;
    }

    public void setTrades(List<TradesBean> trades) {
        this.trades = trades;
    }

    public List<LowaskBean> getLowask() {
        return lowask;
    }

    public void setLowask(List<LowaskBean> lowask) {
        this.lowask = lowask;
    }

    public List<HighbidBean> getHighbid() {
        return highbid;
    }

    public void setHighbid(List<HighbidBean> highbid) {
        this.highbid = highbid;
    }

    public List<?> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<?> userOrders) {
        this.userOrders = userOrders;
    }

    public static class TradesBean {
        /**
         * trade_id : 1322848
         * rate : 134800.00000000
         * amount : 0.01494837
         * trade_date : 2017-08-22 17:45:05
         * order_id : 5312956
         * trade_type : sell
         * reference_id : 0
         * seconds : 238
         */

        @SerializedName("trade_id")
        private String tradeId;
        @SerializedName("rate")
        private String rate;
        @SerializedName("amount")
        private String amount;
        @SerializedName("trade_date")
        private String tradeDate;
        @SerializedName("order_id")
        private String orderId;
        @SerializedName("trade_type")
        private String tradeType;
        @SerializedName("reference_id")
        private String referenceId;
        @SerializedName("seconds")
        private int seconds;

        public String getTradeId() {
            return tradeId;
        }

        public void setTradeId(String tradeId) {
            this.tradeId = tradeId;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTradeDate() {
            return tradeDate;
        }

        public void setTradeDate(String tradeDate) {
            this.tradeDate = tradeDate;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getReferenceId() {
            return referenceId;
        }

        public void setReferenceId(String referenceId) {
            this.referenceId = referenceId;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }
    }

    public static class LowaskBean {
        /**
         * order_id : 5313042
         * rate : 135495.00000000
         * amount : 1.54321000
         * date_added : 2017-08-22 17:49:00
         * order_type : sell
         * display_vol1 : 209,097.24 THB
         * display_vol2 : 1.54321000 BTC
         */

        @SerializedName("order_id")
        private String orderId;
        @SerializedName("rate")
        private String rate;
        @SerializedName("amount")
        private String amount;
        @SerializedName("date_added")
        private String dateAdded;
        @SerializedName("order_type")
        private String orderType;
        @SerializedName("display_vol1")
        private String displayVol1;
        @SerializedName("display_vol2")
        private String displayVol2;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(String dateAdded) {
            this.dateAdded = dateAdded;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getDisplayVol1() {
            return displayVol1;
        }

        public void setDisplayVol1(String displayVol1) {
            this.displayVol1 = displayVol1;
        }

        public String getDisplayVol2() {
            return displayVol2;
        }

        public void setDisplayVol2(String displayVol2) {
            this.displayVol2 = displayVol2;
        }
    }

    public static class HighbidBean {
        /**
         * order_id : 5312991
         * rate : 134500.00
         * amount : 0.37081784
         * date_added : 2017-08-22 17:41:58
         * order_type : buy
         * display_vol1 : 49,875.00 THB
         * display_vol2 : 0.37081784 BTC
         */

        @SerializedName("order_id")
        private String orderId;
        @SerializedName("rate")
        private String rate;
        @SerializedName("amount")
        private String amount;
        @SerializedName("date_added")
        private String dateAdded;
        @SerializedName("order_type")
        private String orderType;
        @SerializedName("display_vol1")
        private String displayVol1;
        @SerializedName("display_vol2")
        private String displayVol2;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(String dateAdded) {
            this.dateAdded = dateAdded;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getDisplayVol1() {
            return displayVol1;
        }

        public void setDisplayVol1(String displayVol1) {
            this.displayVol1 = displayVol1;
        }

        public String getDisplayVol2() {
            return displayVol2;
        }

        public void setDisplayVol2(String displayVol2) {
            this.displayVol2 = displayVol2;
        }
    }
}
