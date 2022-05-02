package com.example.trainschedule.api;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/2 10:40 AM
 *      github  : https://github.com/HurleyWong
 *      desc    : Url 集合类
 * </pre>
 */
public class UrlContainer {

    private static final String TAG = "UrlContainer";

    public static final String MY_BASE_URL = "https://wherewego.top:8200/";

    public static final String baseUrl = "https://aip.baidubce.com/";

    /**
     * 登录
     */
    public static final String LOGIN = "login";

    /**
     * 百度api的Token
     */
    public static final String ACCESS_TOKEN = "oauth/2.0/token";

    /**
     * 通用识别
     */
    public static final String GENERAL_BASIC = "rest/2.0/ocr/v1/general_basic";

    /**
     * 火车票识别
     */
    public static final String TRAIN_TICKET = "rest/2.0/ocr/v1/train_ticket";

}