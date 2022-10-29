package com.youkeda.test.j3.c9;

import com.alibaba.fastjson.JSON;
import com.youkeda.test.j3.c9.model.Weather;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

/**
 * 调用天气API -> 读取天气数据 -> 数据反序列化为对象 -> 发送邮件带上数据
 */
public class WeatherNotice {
OkHttpClient okHttpClient = new OkHttpClient();
public String getWeather(String url) {
  Request request = new Request.Builder().url(url).build();
  Call call = okHttpClient.newCall(request);
  String result = null;
  try {
    Response response = call.execute();
    System.out.println("code "+response.code());
     result = response.body().string();
  } catch (IOException e) {
    e.printStackTrace();
  }
  return result;
}
  public static void main(String[] args) {
  String url = "http://www.weather.com.cn/data/sk/101210106.html";
  WeatherNotice weatherNotice = new WeatherNotice();
  String content = weatherNotice.getWeather(url);
    System.out.println(content);
    Map map = JSON.parseObject(content,Map.class);
    Map contentobj = (Map)map.get("weatherinfo");
    String city= (String) contentobj.get("city");
    String temp = (String) contentobj.get("temp");
    String con = city+temp+"夏天炎热注意休息";
Mail mail = new Mail();
    mail.sendMial(con);

  }
}