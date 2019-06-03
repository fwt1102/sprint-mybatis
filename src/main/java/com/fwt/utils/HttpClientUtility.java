package com.fwt.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwt.dto.TianQiResponseEntity;
import com.fwt.pojo.UserInfo;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/6/3.
 */
public class HttpClientUtility {
    /**
     * httpClient通过get方法访问网络示例
     * @param url 请求的第三方接口地址
     */
    public static String get(String url){
        //模拟一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //设置请求头连接属性为长连接
        httpGet.setHeader("Connection","keep-alive");
        //设置请求头的浏览器属性，欺骗服务器告诉它是一个浏览器向服务器发送请求
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        //新建一个响应对象
        CloseableHttpResponse httpResponse = null;

        try {
            //执行get请求
            httpResponse=httpClient.execute(httpGet);
            //通过httpResponse获取响应对象
            HttpEntity entity = httpResponse.getEntity();
            //将响应对象转换成json
            String jsonStr = EntityUtils.toString(entity);

//            System.out.println("hahaha"+jsonStr);
            return jsonStr;
            //创建对象映射类,用于转换字符串-->对象
//            ObjectMapper mapper = new ObjectMapper();
//            //设置忽略未知的属性
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////            mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
//            TianQiResponseEntity entity1 =mapper.readValue(jsonStr,TianQiResponseEntity.class);
//            System.out.println("xixi"+entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("有没有");
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(11111111);
        return null;
    }






    public static void post(String url,String cookie,ArrayList<BasicNameValuePair> params) {
        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpPost 请求
        HttpPost httpPost = new HttpPost(url);
        // 设置长连接
        httpPost.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        // 设置 Cookie(需要进行登录验证之后)
//        httpPost.setHeader("Cookie", cookie);

        // 创建 HttpPost 参数
//        List<BasicNameValuePair> paramsVal =  params;
//        params.add(new BasicNameValuePair("userId", "1"));
//        params.add(new BasicNameValuePair("start", "0"));
//        params.add(new BasicNameValuePair("length", "10"));

        CloseableHttpResponse httpResponse = null;
        try {
            // 设置 HttpPost 参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            // 输出请求结果
//            System.out.println(EntityUtils.toString(httpEntity));
            String jsonStr = EntityUtils.toString(httpEntity);
            System.out.println(jsonStr);
            //创建对象映射类,用于转换字符串-->对象
            ObjectMapper mapper = new ObjectMapper();
            //设置忽略未知的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
            List<UserInfo> entity1 = mapper.readValue(jsonStr,new TypeReference<List<UserInfo>>(){});
            System.out.println("result:"+entity1);
//                                      mapper.readValue(jsonString, new TypeReference<List<DtoBean>>(){});
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 无论如何必须关闭连接
        finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
