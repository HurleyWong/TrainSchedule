package com.example.trainschedule.bean;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/2 10:47 AM
 *      github  : https://github.com/HurleyWong
 *      desc    :
 * </pre>
 */
public class Ticket {

    /**
     * log_id : 574796674675110947
     * words_result_num : 8
     * words_result : {"name":"黄鹏远","destination_station":"南昌西站","seat_category":"二等座","ticket_rates":"￥83.0元","ticket_num":"G0Q4411","date":"2019年02月25日","train_num":"G4761","starting_station":"上饶站"}
     */

    private long log_id;
    private int words_result_num;
    private WordsResultBean words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public WordsResultBean getWords_result() {
        return words_result;
    }

    public void setWords_result(WordsResultBean words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * name : 黄鹏远
         * destination_station : 南昌西站
         * seat_category : 二等座
         * ticket_rates : ￥83.0元
         * ticket_num : G0Q4411
         * date : 2019年02月25日
         * train_num : G4761
         * starting_station : 上饶站
         */

        private String name;
        private String destination_station;
        private String seat_category;
        private String ticket_rates;
        private String ticket_num;
        private String date;
        private String train_num;
        private String starting_station;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDestination_station() {
            return destination_station;
        }

        public void setDestination_station(String destination_station) {
            this.destination_station = destination_station;
        }

        public String getSeat_category() {
            return seat_category;
        }

        public void setSeat_category(String seat_category) {
            this.seat_category = seat_category;
        }

        public String getTicket_rates() {
            return ticket_rates;
        }

        public void setTicket_rates(String ticket_rates) {
            this.ticket_rates = ticket_rates;
        }

        public String getTicket_num() {
            return ticket_num;
        }

        public void setTicket_num(String ticket_num) {
            this.ticket_num = ticket_num;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTrain_num() {
            return train_num;
        }

        public void setTrain_num(String train_num) {
            this.train_num = train_num;
        }

        public String getStarting_station() {
            return starting_station;
        }

        public void setStarting_station(String starting_station) {
            this.starting_station = starting_station;
        }
    }
}
