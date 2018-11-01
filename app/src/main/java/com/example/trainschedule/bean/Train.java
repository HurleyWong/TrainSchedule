package com.example.trainschedule.bean;

import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class Train{

    /**
     * status : 0
     * msg : ok
     * result : {"trainno":"G34","type":"高铁","list":[{"sequenceno":"1","station":"杭州东","day":"1","arrivaltime":"----","departuretime":"07:01","stoptime":"0","costtime":"0","distance":"0","isend":"0","pricesw":"0","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"0.0","priceed":"0.0"},{"sequenceno":"2","station":"湖州","day":"1","arrivaltime":"07:22","departuretime":"07:24","stoptime":"2","costtime":"21","distance":"71","isend":"0","pricesw":"103","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"55.0","priceed":"32.5"},{"sequenceno":"3","station":"宜兴","day":"1","arrivaltime":"07:42","departuretime":"07:44","stoptime":"2","costtime":"41","distance":"127","isend":"0","pricesw":"184","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"98.0","priceed":"58.5"},{"sequenceno":"4","station":"溧阳","day":"1","arrivaltime":"07:55","departuretime":"07:57","stoptime":"2","costtime":"54","distance":"158","isend":"0","pricesw":"229","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"122.0","priceed":"72.5"},{"sequenceno":"5","station":"溧水","day":"1","arrivaltime":"08:13","departuretime":"08:15","stoptime":"2","costtime":"72","distance":"0","isend":"0","pricesw":"304.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"162.5","priceed":"96.5"},{"sequenceno":"6","station":"南京南","day":"1","arrivaltime":"08:31","departuretime":"08:33","stoptime":"2","costtime":"90","distance":"256","isend":"0","pricesw":"371","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"198.0","priceed":"117.5"},{"sequenceno":"7","station":"宿州东","day":"1","arrivaltime":"09:33","departuretime":"09:35","stoptime":"2","costtime":"152","distance":"519","isend":"0","pricesw":"749.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"400.0","priceed":"237.5"},{"sequenceno":"8","station":"徐州东","day":"1","arrivaltime":"09:53","departuretime":"10:09","stoptime":"16","costtime":"172","distance":"587","isend":"0","pricesw":"838.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"447.0","priceed":"265.5"},{"sequenceno":"9","station":"泰安","day":"1","arrivaltime":"11:00","departuretime":"11:04","stoptime":"4","costtime":"239","distance":"0","isend":"0","pricesw":"1134.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"605.0","priceed":"359.5"},{"sequenceno":"10","station":"济南西","day":"1","arrivaltime":"11:21","departuretime":"11:24","stoptime":"3","costtime":"260","distance":"873","isend":"0","pricesw":"1211.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"646.0","priceed":"383.5"},{"sequenceno":"11","station":"沧州西","day":"1","arrivaltime":"12:10","departuretime":"12:12","stoptime":"2","costtime":"309","distance":"0","isend":"0","pricesw":"1457.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"777.5","priceed":"461.5"},{"sequenceno":"12","station":"北京南","day":"1","arrivaltime":"13:03","departuretime":"13:03","stoptime":"0","costtime":"362","distance":"1279","isend":"1","pricesw":"1701","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"907.0","priceed":"538.5","costtimetxt":"6时2分"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

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

    public ResultBean getResult(){
        return result;
    }

    public void setResult(ResultBean result){
        this.result=result;
    }

    public static class ResultBean{
        /**
         * trainno : G34
         * type : 高铁
         * list : [{"sequenceno":"1","station":"杭州东","day":"1","arrivaltime":"----","departuretime":"07:01","stoptime":"0","costtime":"0","distance":"0","isend":"0","pricesw":"0","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"0.0","priceed":"0.0"},{"sequenceno":"2","station":"湖州","day":"1","arrivaltime":"07:22","departuretime":"07:24","stoptime":"2","costtime":"21","distance":"71","isend":"0","pricesw":"103","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"55.0","priceed":"32.5"},{"sequenceno":"3","station":"宜兴","day":"1","arrivaltime":"07:42","departuretime":"07:44","stoptime":"2","costtime":"41","distance":"127","isend":"0","pricesw":"184","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"98.0","priceed":"58.5"},{"sequenceno":"4","station":"溧阳","day":"1","arrivaltime":"07:55","departuretime":"07:57","stoptime":"2","costtime":"54","distance":"158","isend":"0","pricesw":"229","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"122.0","priceed":"72.5"},{"sequenceno":"5","station":"溧水","day":"1","arrivaltime":"08:13","departuretime":"08:15","stoptime":"2","costtime":"72","distance":"0","isend":"0","pricesw":"304.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"162.5","priceed":"96.5"},{"sequenceno":"6","station":"南京南","day":"1","arrivaltime":"08:31","departuretime":"08:33","stoptime":"2","costtime":"90","distance":"256","isend":"0","pricesw":"371","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"198.0","priceed":"117.5"},{"sequenceno":"7","station":"宿州东","day":"1","arrivaltime":"09:33","departuretime":"09:35","stoptime":"2","costtime":"152","distance":"519","isend":"0","pricesw":"749.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"400.0","priceed":"237.5"},{"sequenceno":"8","station":"徐州东","day":"1","arrivaltime":"09:53","departuretime":"10:09","stoptime":"16","costtime":"172","distance":"587","isend":"0","pricesw":"838.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"447.0","priceed":"265.5"},{"sequenceno":"9","station":"泰安","day":"1","arrivaltime":"11:00","departuretime":"11:04","stoptime":"4","costtime":"239","distance":"0","isend":"0","pricesw":"1134.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"605.0","priceed":"359.5"},{"sequenceno":"10","station":"济南西","day":"1","arrivaltime":"11:21","departuretime":"11:24","stoptime":"3","costtime":"260","distance":"873","isend":"0","pricesw":"1211.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"646.0","priceed":"383.5"},{"sequenceno":"11","station":"沧州西","day":"1","arrivaltime":"12:10","departuretime":"12:12","stoptime":"2","costtime":"309","distance":"0","isend":"0","pricesw":"1457.5","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"777.5","priceed":"461.5"},{"sequenceno":"12","station":"北京南","day":"1","arrivaltime":"13:03","departuretime":"13:03","stoptime":"0","costtime":"362","distance":"1279","isend":"1","pricesw":"1701","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"0","pricerw2":"0","priceyw1":"0","priceyw2":"0","priceyw3":"0","priceyd":"907.0","priceed":"538.5","costtimetxt":"6时2分"}]
         */

        //车次
        private String trainno;
        //类型
        private String type;
        private List<ListBean> list;

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

        public List<ListBean> getList(){
            return list;
        }

        public void setList(List<ListBean> list){
            this.list=list;
        }

        public static class ListBean{
            /**
             * sequenceno : 1
             * station : 杭州东
             * day : 1
             * arrivaltime : ----
             * departuretime : 07:01
             * stoptime : 0
             * costtime : 0
             * distance : 0
             * isend : 0
             * pricesw : 0
             * pricetd :
             * pricegr1 :
             * pricegr2 :
             * pricerw1 : 0
             * pricerw2 : 0
             * priceyw1 : 0
             * priceyw2 : 0
             * priceyw3 : 0
             * priceyd : 0.0
             * priceed : 0.0
             * costtimetxt : 6时2分
             */

            public ListBean(String station,String arrivaltime,String stoptime,String departuretime){
                this.station=station;
                this.arrivaltime=arrivaltime;
                this.stoptime=stoptime;
                this.departuretime=departuretime;
            }

            //序号
            private String sequenceno;
            //车站
            private String station;
            //天数
            private String day;
            //到达时间
            private String arrivaltime;
            //出发时间
            private String departuretime;
            //停留时间
            private String stoptime;

            //时间段
            private String time=departuretime+"-"+arrivaltime;

            public String getTime(){
                return time;
            }

            public void setTime(String time){
                this.time=time;
            }


            //用时
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
            private String costtimetxt;

            public String getSequenceno(){
                return sequenceno;
            }

            public void setSequenceno(String sequenceno){
                this.sequenceno=sequenceno;
            }

            public String getStation(){
                return station;
            }

            public void setStation(String station){
                this.station=station;
            }

            public String getDay(){
                return day;
            }

            public void setDay(String day){
                this.day=day;
            }

            public String getArrivaltime(){
                return arrivaltime;
            }

            public void setArrivaltime(String arrivaltime){
                this.arrivaltime=arrivaltime;
            }

            public String getDeparturetime(){
                return departuretime;
            }

            public void setDeparturetime(String departuretime){
                this.departuretime=departuretime;
            }

            public String getStoptime(){
                return stoptime;
            }

            public void setStoptime(String stoptime){
                this.stoptime=stoptime;
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

            public String getCosttimetxt(){
                return costtimetxt;
            }

            public void setCosttimetxt(String costtimetxt){
                this.costtimetxt=costtimetxt;
            }
        }
    }
}
