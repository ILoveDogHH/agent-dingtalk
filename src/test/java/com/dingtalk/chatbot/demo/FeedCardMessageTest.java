package com.dingtalk.chatbot.demo;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.FeedCardMessage;
import com.dingtalk.chatbot.message.FeedCardMessageItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dustin on 2017/3/19.
 */
public class FeedCardMessageTest {

    private DingtalkChatbotClient client = new DingtalkChatbotClient();

    @Test
    public void testSendMultipleFeedCardMessage() throws Exception {
        FeedCardMessage message = new FeedCardMessage();

        List<FeedCardMessageItem> items = new ArrayList<FeedCardMessageItem>();
        FeedCardMessageItem item1 = new FeedCardMessageItem();
        item1.setTitle("心灵鸡汤1");
        item1.setPicURL("https://img.alicdn.com/tps/TB1XLjqNVXXXXc4XVXXXXXXXXXX-170-64.png");
        item1.setMessageURL("http://www.dingtalk.com");
        items.add(item1);

        FeedCardMessageItem item2 = new FeedCardMessageItem();
        item2.setTitle("心灵鸡汤2");
        item2.setPicURL("https://img.alicdn.com/tps/TB1XLjqNVXXXXc4XVXXXXXXXXXX-170-64.png");
        item2.setMessageURL("http://www.dingtalk.com");
        items.add(item2);

        FeedCardMessageItem item3 = new FeedCardMessageItem();
        item3.setTitle("心灵鸡汤3");
        item3.setPicURL("https://img.alicdn.com/tps/TB1XLjqNVXXXXc4XVXXXXXXXXXX-170-64.png");
        item3.setMessageURL("http://www.dingtalk.com");
        items.add(item3);

        message.setFeedItems(items);

        System.out.println(message.toJsonString());

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

}