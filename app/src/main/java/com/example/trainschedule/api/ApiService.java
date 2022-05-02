package com.example.trainschedule.api;

import com.example.trainschedule.bean.Ticket;
import com.example.trainschedule.bean.Token;
import com.example.trainschedule.bean.User;
import com.example.trainschedule.bean.Word;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/2 10:39 AM
 *      github  : https://github.com/HurleyWong
 *      desc    : Api 服务类
 * </pre>
 */
public interface ApiService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @POST(UrlContainer.LOGIN)
    @FormUrlEncoded
    Observable<User> login(@Field("username") String username,
                           @Field("password") String password);

    @POST(UrlContainer.ACCESS_TOKEN)
    Observable<Token> getAccessToken(@Query("grant_type") String grantType,
                                     @Query("client_id") String clientId,
                                     @Query("client_secret") String clientSecret);

    /**
     * 通过图片获取图片内文字信息
     *
     * @param token 通过API Key和Secret Key获取的access_token
     * @param image 图像数据base64编码后进行urlencode后的String
     * @return
     */
    @POST(UrlContainer.TRAIN_TICKET)
    @FormUrlEncoded
    Observable<Ticket> getTicket(@Field("access_token") String token,
                                 @Field("image") String image);

    /**
     * 通过图片获取关键词
     *
     * @param token
     * @param image
     * @return
     */
    @POST(UrlContainer.GENERAL_BASIC)
    @FormUrlEncoded
    Observable<Word> getWord(@Field("access_token") String token,
                             @Field("image") String image);
}
