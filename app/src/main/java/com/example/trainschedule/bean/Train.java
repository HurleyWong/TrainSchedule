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
     * result : {"trainno":"G5305","startstation":"南昌西","endstation":"厦门北","type":"G","date":"2019-04-01","trainno12306":"","typename":"高铁","list":[{"sequenceno":"1","station":"南昌西","day":"1","arrivaltime":"----","departuretime":"07:52","stoptime":"0","costtime":"0","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"3","station":"鹰潭北","day":"1","arrivaltime":"08:26","departuretime":"08:28","stoptime":"2","costtime":"0","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"4","station":"上饶","day":"1","arrivaltime":"08:58","departuretime":"09:00","stoptime":"2","costtime":"32","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"5","station":"武夷山北","day":"1","arrivaltime":"09:23","departuretime":"09:25","stoptime":"2","costtime":"57","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"6","station":"武夷山东","day":"1","arrivaltime":"09:37","departuretime":"09:39","stoptime":"2","costtime":"71","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"7","station":"建瓯西","day":"1","arrivaltime":"09:55","departuretime":"09:57","stoptime":"2","costtime":"89","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"8","station":"南平北","day":"1","arrivaltime":"10:13","departuretime":"10:15","stoptime":"2","costtime":"107","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"9","station":"古田北","day":"1","arrivaltime":"10:29","departuretime":"10:31","stoptime":"2","costtime":"123","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"10","station":"闽清北","day":"1","arrivaltime":"10:42","departuretime":"10:44","stoptime":"2","costtime":"136","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"11","station":"福州","day":"1","arrivaltime":"11:04","departuretime":"11:07","stoptime":"3","costtime":"158","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"12","station":"福州南","day":"1","arrivaltime":"11:24","departuretime":"11:26","stoptime":"2","costtime":"178","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"13","station":"泉州","day":"1","arrivaltime":"12:17","departuretime":"12:19","stoptime":"2","costtime":"231","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"14","station":"厦门北","day":"1","arrivaltime":"12:44","departuretime":"12:44","stoptime":"0","costtime":"258","distance":"0","isend":"1","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":"","costtimetxt":"4时18分"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * trainno : G5305
         * startstation : 南昌西
         * endstation : 厦门北
         * type : G
         * date : 2019-04-01
         * trainno12306 :
         * typename : 高铁
         * list : [{"sequenceno":"1","station":"南昌西","day":"1","arrivaltime":"----","departuretime":"07:52","stoptime":"0","costtime":"0","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"3","station":"鹰潭北","day":"1","arrivaltime":"08:26","departuretime":"08:28","stoptime":"2","costtime":"0","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"4","station":"上饶","day":"1","arrivaltime":"08:58","departuretime":"09:00","stoptime":"2","costtime":"32","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"5","station":"武夷山北","day":"1","arrivaltime":"09:23","departuretime":"09:25","stoptime":"2","costtime":"57","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"6","station":"武夷山东","day":"1","arrivaltime":"09:37","departuretime":"09:39","stoptime":"2","costtime":"71","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"7","station":"建瓯西","day":"1","arrivaltime":"09:55","departuretime":"09:57","stoptime":"2","costtime":"89","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"8","station":"南平北","day":"1","arrivaltime":"10:13","departuretime":"10:15","stoptime":"2","costtime":"107","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"9","station":"古田北","day":"1","arrivaltime":"10:29","departuretime":"10:31","stoptime":"2","costtime":"123","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"10","station":"闽清北","day":"1","arrivaltime":"10:42","departuretime":"10:44","stoptime":"2","costtime":"136","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"11","station":"福州","day":"1","arrivaltime":"11:04","departuretime":"11:07","stoptime":"3","costtime":"158","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"12","station":"福州南","day":"1","arrivaltime":"11:24","departuretime":"11:26","stoptime":"2","costtime":"178","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"13","station":"泉州","day":"1","arrivaltime":"12:17","departuretime":"12:19","stoptime":"2","costtime":"231","distance":"0","isend":"0","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":""},{"sequenceno":"14","station":"厦门北","day":"1","arrivaltime":"12:44","departuretime":"12:44","stoptime":"0","costtime":"258","distance":"0","isend":"1","pricesw":"","pricetd":"","pricegr1":"","pricegr2":"","pricerw1":"","pricerw2":"","priceyw1":"","priceyw2":"","priceyw3":"","priceyd":"","priceed":"","costtimetxt":"4时18分"}]
         */

        private String trainno;
        private String startstation;
        private String endstation;
        private String type;
        private String date;
        private String trainno12306;
        private String typename;
        private List<ListBean> list;

        public String getTrainno() {
            return trainno;
        }

        public void setTrainno(String trainno) {
            this.trainno = trainno;
        }

        public String getStartstation() {
            return startstation;
        }

        public void setStartstation(String startstation) {
            this.startstation = startstation;
        }

        public String getEndstation() {
            return endstation;
        }

        public void setEndstation(String endstation) {
            this.endstation = endstation;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTrainno12306() {
            return trainno12306;
        }

        public void setTrainno12306(String trainno12306) {
            this.trainno12306 = trainno12306;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * sequenceno : 1
             * station : 南昌西
             * day : 1
             * arrivaltime : ----
             * departuretime : 07:52
             * stoptime : 0
             * costtime : 0
             * distance : 0
             * isend : 0
             * pricesw :
             * pricetd :
             * pricegr1 :
             * pricegr2 :
             * pricerw1 :
             * pricerw2 :
             * priceyw1 :
             * priceyw2 :
             * priceyw3 :
             * priceyd :
             * priceed :
             * costtimetxt : 4时18分
             */

            private String sequenceno;
            private String station;
            private String day;
            private String arrivaltime;
            private String departuretime;
            private String stoptime;
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

            public ListBean(String station, String arrivaltime, String stoptime, String departuretime) {
                this.station = station;
                this.arrivaltime = arrivaltime;
                this.stoptime = stoptime;
                this.departuretime = departuretime;
            }


            public String getSequenceno() {
                return sequenceno;
            }

            public void setSequenceno(String sequenceno) {
                this.sequenceno = sequenceno;
            }

            public String getStation() {
                return station;
            }

            public void setStation(String station) {
                this.station = station;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getArrivaltime() {
                return arrivaltime;
            }

            public void setArrivaltime(String arrivaltime) {
                this.arrivaltime = arrivaltime;
            }

            public String getDeparturetime() {
                return departuretime;
            }

            public void setDeparturetime(String departuretime) {
                this.departuretime = departuretime;
            }

            public String getStoptime() {
                return stoptime;
            }

            public void setStoptime(String stoptime) {
                this.stoptime = stoptime;
            }

            public String getCosttime() {
                return costtime;
            }

            public void setCosttime(String costtime) {
                this.costtime = costtime;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getIsend() {
                return isend;
            }

            public void setIsend(String isend) {
                this.isend = isend;
            }

            public String getPricesw() {
                return pricesw;
            }

            public void setPricesw(String pricesw) {
                this.pricesw = pricesw;
            }

            public String getPricetd() {
                return pricetd;
            }

            public void setPricetd(String pricetd) {
                this.pricetd = pricetd;
            }

            public String getPricegr1() {
                return pricegr1;
            }

            public void setPricegr1(String pricegr1) {
                this.pricegr1 = pricegr1;
            }

            public String getPricegr2() {
                return pricegr2;
            }

            public void setPricegr2(String pricegr2) {
                this.pricegr2 = pricegr2;
            }

            public String getPricerw1() {
                return pricerw1;
            }

            public void setPricerw1(String pricerw1) {
                this.pricerw1 = pricerw1;
            }

            public String getPricerw2() {
                return pricerw2;
            }

            public void setPricerw2(String pricerw2) {
                this.pricerw2 = pricerw2;
            }

            public String getPriceyw1() {
                return priceyw1;
            }

            public void setPriceyw1(String priceyw1) {
                this.priceyw1 = priceyw1;
            }

            public String getPriceyw2() {
                return priceyw2;
            }

            public void setPriceyw2(String priceyw2) {
                this.priceyw2 = priceyw2;
            }

            public String getPriceyw3() {
                return priceyw3;
            }

            public void setPriceyw3(String priceyw3) {
                this.priceyw3 = priceyw3;
            }

            public String getPriceyd() {
                return priceyd;
            }

            public void setPriceyd(String priceyd) {
                this.priceyd = priceyd;
            }

            public String getPriceed() {
                return priceed;
            }

            public void setPriceed(String priceed) {
                this.priceed = priceed;
            }

            public String getCosttimetxt() {
                return costtimetxt;
            }

            public void setCosttimetxt(String costtimetxt) {
                this.costtimetxt = costtimetxt;
            }
        }
    }
}
