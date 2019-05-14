package com.example.trainschedule.bean;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/9 2:20 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class User {

    /**
     * code : 002
     * result : {"tuser":{"id":52,"usercode":"13657936306","username":null,"password":"123456","gender":0,"realname":null,"wxnickname":null,"wxcity":null,"wxcountry":null,"wxprovince":null,"wxavatarurl":null,"wxunionid":null},"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMzY1NzkzNjMwNjEyMzQ1NiIsImNvZGUiOiIxMzY1NzkzNjMwNjEyMzQ1NiIsIm9wZW5pZCI6IiIsInVzZXJjb2RlIjoiMTM2NTc5MzYzMDYiLCJzZXNzaW9uX2tleSI6IiIsImlhdCI6MTU1NDc3ODA1MSwiZXhwIjoxNTU0ODg2MDUxfQ.bqqt3sU5WPRO7bUY40ViVvwVUbk_L3ulfaHtAkaOxSs"}
     */

    private String code;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * tuser : {"id":52,"usercode":"13657936306","username":null,"password":"123456","gender":0,"realname":null,"wxnickname":null,"wxcity":null,"wxcountry":null,"wxprovince":null,"wxavatarurl":null,"wxunionid":null}
         * token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMzY1NzkzNjMwNjEyMzQ1NiIsImNvZGUiOiIxMzY1NzkzNjMwNjEyMzQ1NiIsIm9wZW5pZCI6IiIsInVzZXJjb2RlIjoiMTM2NTc5MzYzMDYiLCJzZXNzaW9uX2tleSI6IiIsImlhdCI6MTU1NDc3ODA1MSwiZXhwIjoxNTU0ODg2MDUxfQ.bqqt3sU5WPRO7bUY40ViVvwVUbk_L3ulfaHtAkaOxSs
         */

        private TuserBean tuser;
        private String token;

        public TuserBean getTuser() {
            return tuser;
        }

        public void setTuser(TuserBean tuser) {
            this.tuser = tuser;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class TuserBean {
            /**
             * id : 52
             * usercode : 13657936306
             * username : null
             * password : 123456
             * gender : 0
             * realname : null
             * wxnickname : null
             * wxcity : null
             * wxcountry : null
             * wxprovince : null
             * wxavatarurl : null
             * wxunionid : null
             */

            private int id;
            private String usercode;
            private Object username;
            private String password;
            private int gender;
            private Object realname;
            private Object wxnickname;
            private Object wxcity;
            private Object wxcountry;
            private Object wxprovince;
            private Object wxavatarurl;
            private Object wxunionid;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsercode() {
                return usercode;
            }

            public void setUsercode(String usercode) {
                this.usercode = usercode;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public Object getRealname() {
                return realname;
            }

            public void setRealname(Object realname) {
                this.realname = realname;
            }

            public Object getWxnickname() {
                return wxnickname;
            }

            public void setWxnickname(Object wxnickname) {
                this.wxnickname = wxnickname;
            }

            public Object getWxcity() {
                return wxcity;
            }

            public void setWxcity(Object wxcity) {
                this.wxcity = wxcity;
            }

            public Object getWxcountry() {
                return wxcountry;
            }

            public void setWxcountry(Object wxcountry) {
                this.wxcountry = wxcountry;
            }

            public Object getWxprovince() {
                return wxprovince;
            }

            public void setWxprovince(Object wxprovince) {
                this.wxprovince = wxprovince;
            }

            public Object getWxavatarurl() {
                return wxavatarurl;
            }

            public void setWxavatarurl(Object wxavatarurl) {
                this.wxavatarurl = wxavatarurl;
            }

            public Object getWxunionid() {
                return wxunionid;
            }

            public void setWxunionid(Object wxunionid) {
                this.wxunionid = wxunionid;
            }
        }
    }
}
