package com.dingtalk.chatbot;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.chatbot.message.Message;

/**
 * Created by dustin on 2017/3/17.
 */
public class DingtalkChatbotClient {
    HttpClient httpclient = HttpClients.createDefault();

    public SendResult send(String webhook, Message message) throws IOException{
        HttpPost httppost = new HttpPost(webhook);
		httppost.addHeader("Content-Type", "application/json; charset=utf-8");
		StringEntity entity = new StringEntity(message.toJsonString(), "utf-8");
		httppost.setEntity(entity);
		httppost.setConfig(RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000)
				.setSocketTimeout(5000).build());

        SendResult sendResult = new SendResult();
        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            JSONObject obj = JSONObject.parseObject(result);

            Integer errcode = obj.getInteger("errcode");
            sendResult.setErrorCode(errcode);
            sendResult.setErrorMsg(obj.getString("errmsg"));
            sendResult.setIsSuccess(errcode.equals(0));
        }

        return sendResult;
    }

}


