package com.dingtalk.chatbot.demo;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.TextMessage;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by dustin on 2017/3/18.
 */
public class TextMessageTest {

    private DingtalkChatbotClient client = new DingtalkChatbotClient();

    @Test
    public void testSendTextMessage() throws Exception {
        TextMessage message = new TextMessage("我就是我, 是不一样的烟火");
        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendTextMessageWithAt() throws Exception {
        TextMessage message = new TextMessage("我就是我, 是不一样的烟火");
        ArrayList<String> atMobiles = new ArrayList<String>();
        atMobiles.add("137xxxx3310");
        message.setAtMobiles(atMobiles);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendTextMessageWithAtAll() throws Exception {
        TextMessage message = new TextMessage("我就是我, 是不一样的烟火");
        message.setIsAtAll(true);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendTextMessageWithAtAndAtAll() throws Exception {
        TextMessage message = new TextMessage("我就是我, 是不一样的烟火");
        ArrayList<String> atMobiles = new ArrayList<String>();
        atMobiles.add("186xxxx0822");
        message.setAtMobiles(atMobiles);
        message.setIsAtAll(true);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }
}