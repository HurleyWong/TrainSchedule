package com.example.trainschedule.bean;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/16
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class License{
    private String license_name;
    private String license_link;

    public License(String license_name,String license_link){
        this.license_name=license_name;
        this.license_link=license_link;
    }

    public String getLicense_name(){
        return license_name;
    }

    public void setLicense_name(String license_name){
        this.license_name=license_name;
    }

    public String getLicense_link(){
        return license_link;
    }

    public void setLicense_link(String license_link){
        this.license_link=license_link;
    }
}
