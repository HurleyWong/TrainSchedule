package com.example.trainschedule.api;

import com.example.trainschedule.bean.Ticket;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/2 10:39 AM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public interface ApiService {

    /**
     * 通过图片获取图片内文字信息
     * @param token                 通过API Key和Secret Key获取的access_token
     * @param image                 图像数据base64编码后进行urlencode后的String
     * @return
     */
    @POST(UrlContainer.TRAIN_TICKET)
    @FormUrlEncoded
    Observable<Ticket.WordsResultBean> getTicket(@Field("access_tocken") String token,
                                                 @Field("image") String image);

}
