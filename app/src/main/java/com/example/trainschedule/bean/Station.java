package com.example.trainschedule.bean;

import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/14
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class Station{

    /**
     * status : 0
     * msg : ok
     * result : [{"trainno":"G34","type":"高铁","station":"杭州东","endstation":"北京南","departuretime":"07:18","arrivaltime":"13:07","sequenceno":"1","costtime":"5时49分","distance":"1279","isend":"1","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0.0","pricerw2":"0.0","priceyw1":"0.0","priceyw2":"0.0","priceyw3":"0.0","priceyd":"907.0","priceed":"538.5"},{"trainno":"G32","type":"高铁","station":"杭州东","endstation":"北京南","departuretime":"08:30","arrivaltime":"13:28","sequenceno":"1","costtime":"4时58分","distance":"1279","isend":"1","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0.0","pricerw2":"0.0","priceyw1":"0.0","priceyw2":"0.0","priceyw3":"0.0","priceyd":"907.0","priceed":"538.5"}]
     */

    private String status;
    private String msg;
    private List<ResultBean> result;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg=msg;
    }

    public List<ResultBean> getResult(){
        return result;
    }

    public void setResult(List<ResultBean> result){
        this.result=result;
    }

    public static class ResultBean{
        /**
         * trainno : G34
         * type : 高铁
         * station : 杭州东
         * endstation : 北京南
         * departuretime : 07:18
         * arrivaltime : 13:07
         * sequenceno : 1
         * costtime : 5时49分
         * distance : 1279
         * isend : 1
         * pricesw :
         * pricetd :
         * pricegr1 :
         * pricegr2 :
         * pricerw1 : 0.0
         * pricerw2 : 0.0
         * priceyw1 : 0.0
         * priceyw2 : 0.0
         * priceyw3 : 0.0
         * priceyd : 907.0
         * priceed : 538.5
         */

        public ResultBean(String trainno,String station,String endstation,String departuretime,
                          String arrivaltime,String costtime,String priceed,String type){
            this.trainno=trainno;
            this.station=station;
            this.endstation=endstation;
            this.departuretime=departuretime;
            this.arrivaltime=arrivaltime;
            this.costtime=costtime;
            this.priceed=priceed;
            this.type=type;
        }

        private String trainno;
        private String type;
        private String station;
        private String endstation;
        private String departuretime;
        private String arrivaltime;
        private String sequenceno;
        private String costtime;
        private String distance;
        private String isend;
        private String pricesw;
        private String pricetd;
        private String pricegr1;
        private String pricegr2;
        private String pricerw1;
        private String pricerw2;
        private String priceyw1;
        private String priceyw2;
        private String priceyw3;
        private String priceyd;
        private String priceed;
        private String pricerz;             //软座
        private String priceyz;             //硬座

        public String getTrainno(){
            return trainno;
        }

        public void setTrainno(String trainno){
            this.trainno=trainno;
        }

        public String getType(){
            return type;
        }

        public void setType(String type){
            this.type=type;
        }

        public String getStation(){
            return station;
        }

        public void setStation(String station){
            this.station=station;
        }

        public String getEndstation(){
            return endstation;
        }

        public void setEndstation(String endstation){
            this.endstation=endstation;
        }

        public String getDeparturetime(){
            return departuretime;
        }

        public void setDeparturetime(String departuretime){
            this.departuretime=departuretime;
        }

        public String getArrivaltime(){
            return arrivaltime;
        }

        public void setArrivaltime(String arrivaltime){
            this.arrivaltime=arrivaltime;
        }

        public String getSequenceno(){
            return sequenceno;
        }

        public void setSequenceno(String sequenceno){
            this.sequenceno=sequenceno;
        }

        public String getCosttime(){
            return costtime;
        }

        public void setCosttime(String costtime){
            this.costtime=costtime;
        }

        public String getDistance(){
            return distance;
        }

        public void setDistance(String distance){
            this.distance=distance;
        }

        public String getIsend(){
            return isend;
        }

        public void setIsend(String isend){
            this.isend=isend;
        }

        public String getPricesw(){
            return pricesw;
        }

        public void setPricesw(String pricesw){
            this.pricesw=pricesw;
        }

        public String getPricetd(){
            return pricetd;
        }

        public void setPricetd(String pricetd){
            this.pricetd=pricetd;
        }

        public String getPricegr1(){
            return pricegr1;
        }

        public void setPricegr1(String pricegr1){
            this.pricegr1=pricegr1;
        }

        public String getPricegr2(){
            return pricegr2;
        }

        public void setPricegr2(String pricegr2){
            this.pricegr2=pricegr2;
        }

        public String getPricerw1(){
            return pricerw1;
        }

        public void setPricerw1(String pricerw1){
            this.pricerw1=pricerw1;
        }

        public String getPricerw2(){
            return pricerw2;
        }

        public void setPricerw2(String pricerw2){
            this.pricerw2=pricerw2;
        }

        public String getPriceyw1(){
            return priceyw1;
        }

        public void setPriceyw1(String priceyw1){
            this.priceyw1=priceyw1;
        }

        public String getPriceyw2(){
            return priceyw2;
        }

        public void setPriceyw2(String priceyw2){
            this.priceyw2=priceyw2;
        }

        public String getPriceyw3(){
            return priceyw3;
        }

        public void setPriceyw3(String priceyw3){
            this.priceyw3=priceyw3;
        }

        public String getPriceyd(){
            return priceyd;
        }

        public void setPriceyd(String priceyd){
            this.priceyd=priceyd;
        }

        public String getPriceed(){
            return priceed;
        }

        public void setPriceed(String priceed){
            this.priceed=priceed;
        }

        public String getPricerz(){
            return pricerz;
        }

        public void setPricerz(String pricerz){
            this.pricerz=pricerz;
        }

        public String getPriceyz(){
            return priceyz;
        }

        public void setPriceyz(String priceyz){
            this.priceyz=priceyz;
        }
    }
}
