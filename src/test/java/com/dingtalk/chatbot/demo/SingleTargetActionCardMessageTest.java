package com.dingtalk.chatbot.demo;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.SingleTargetActionCardMessage;
import org.junit.Test;

/**
 * Created by dustin on 2017/3/19.
 */
public class SingleTargetActionCardMessageTest {

    private DingtalkChatbotClient client = new DingtalkChatbotClient();

    @Test
    public void testSingleTargetActionCardMessage() throws Exception {
        SingleTargetActionCardMessage message = new SingleTargetActionCardMessage();
        message.setBannerUrl("http://img01.taobaocdn.com/top/i1/LB1GCdYQXXXXXXtaFXXXXXXXXXX");
        message.setTitle("2017年你要读的十本书");
        message.setBriefTitle("2017年你要读的十本书");
        message.setBriefText("书籍是人类进步的阶梯.生活里没有书籍,就好像大地没有阳光;智慧里没有书籍,就好像鸟儿没有翅膀.一本好书就是一位好老师,它可以塑造一个完美的灵魂");
        message.setSingleTitle("查看更多");
        message.setSingleURL("http://www.dingtalk.com");

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);

    }

    @Test
    public void testSendSingleTargetActionCardMessageWithoutBanner() throws Exception {
        SingleTargetActionCardMessage message = new SingleTargetActionCardMessage();
        message.setTitle("2017年你要读的十本书");
        message.setBriefTitle("2017年你要读的十本书");
        message.setBriefText("书籍是人类进步的阶梯”.生活里没有书籍,就好像大地没有阳光;智慧里没有书籍,就好像鸟儿没有翅膀.一本好书就是一位好老师,它可以塑造一个完美的灵魂");
        message.setSingleTitle("查看更多");
        message.setSingleURL("http://www.dingtalk.com");

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendSingleTargetActionCardMessageHideAvatar() throws Exception {
        SingleTargetActionCardMessage message = new SingleTargetActionCardMessage();
        message.setTitle("2017年你要读的十本书");
        message.setBriefTitle("2017年你要读的十本书");
        message.setHideAvatar(true);
        message.setBriefText("书籍是人类进步的阶梯”.生活里没有书籍,就好像大地没有阳光;智慧里没有书籍,就好像鸟儿没有翅膀.一本好书就是一位好老师,它可以塑造一个完美的灵魂");
        message.setSingleTitle("查看更多");
        message.setSingleURL("http://www.dingtalk.com");

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }
}