package com.example.trainschedule.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/17
 * </pre>
 */

public class FileUtils {

    /**
     * 读取位于 assets 文件夹下的 JSON 文件
     *
     * @param fileName
     * @param context
     * @return
     */
    public static String getJSON(String fileName, Context context) {
        // 将 JSON 数据转变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // 获取 assets 资源管理器
            AssetManager assetManager = context.getAssets();
            // 通过管理器打开文件并读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)
            ));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    /*public static String readJSONFile(String path){
        String lastStr="";
        //打开文件
        File file=new File(path);
        BufferedReader reader=null;
        try{
            FileInputStream in=new FileInputStream(file);
            //读取文件
            reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String tempString=null;
            while((tempString=reader.readLine())!=null){
                lastStr+=tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return lastStr;
    }*/
}















