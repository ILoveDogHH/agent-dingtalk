package com.dingtalk.chatbot.demo;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.ActionButtonStyle;
import com.dingtalk.chatbot.message.ActionCardAction;
import com.dingtalk.chatbot.message.ActionCardMessage;
import org.junit.Test;

import java.net.URLEncoder;

/**
 * Created by dustin on 2017/3/19.
 */
public class ActionCardMessageTest {

    private DingtalkChatbotClient client = new DingtalkChatbotClient();

    @Test
    public void testSendActionCardMessage() throws Exception {
        ActionCardMessage message = new ActionCardMessage();
        message.setBriefText("亲，小秘没有看懂你的问题哦，换个说法问问小秘看~你也可以试试以下问题");
        ActionCardAction action1 = new ActionCardAction("考勤打卡", "http://www.dingtalk.com");
        message.addAction(action1);
        ActionCardAction action2 = new ActionCardAction("办公电话", "http://www.dingtalk.com");
        message.addAction(action2);
        ActionCardAction action3 = new ActionCardAction("智能客服", "http://www.dingtalk.com");
        message.addAction(action3);
        ActionCardAction action4 = new ActionCardAction("更多问题", "http://www.dingtalk.com");
        message.addAction(action4);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendActionCardMessageWithTitle() throws Exception {
        ActionCardMessage message = new ActionCardMessage();
        message.setTitle("钉钉功能推荐");

        message.setBriefTitle("创建团队，让工作沟通更加安全高效");
        message.setBriefText("国内广受认可的企业级应用市场入驻标准高、产品质量高，入驻即代表得到市场认可，实力获得钉钉背书");
        ActionCardAction action1 = new ActionCardAction("邀请群成员创建团队", "http://www.dingtalk.com");
        message.addAction(action1);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendActionCardMessageWithBanner() throws Exception {
        ActionCardMessage message = new ActionCardMessage();
        message.setTitle("钉钉功能推荐");
        message.setBannerURL("http://img01.taobaocdn.com/top/i1/LB1GCdYQXXXXXXtaFXXXXXXXXXX");
        message.setBriefTitle("创建团队，让工作沟通更加安全高效");
        message.setBriefText("国内广受认可的企业级应用市场入驻标准高、产品质量高，入驻即代表得到市场认可，实力获得钉钉背书");
        ActionCardAction action1 = new ActionCardAction("查看详情", "http://www.dingtalk.com");
        message.addAction(action1);

        ActionCardAction action2 = new ActionCardAction("不感兴趣", "http://www.dingtalk.com");
        message.addAction(action2);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendActionCardMessageWithHorizontalButton() throws Exception {
        ActionCardMessage message = new ActionCardMessage();
        message.setBannerURL("http://img01.taobaocdn.com/top/i1/LB1GCdYQXXXXXXtaFXXXXXXXXXX");
        message.setTitle("创建团队，让工作沟通更加安全高效");
        message.setBriefText("国内广受认可的企业级应用市场入驻标准高、产品质量高，入驻即代表得到市场认可，实力获得钉钉背书");
        ActionCardAction action1 = new ActionCardAction("查看详情", "http://www.dingtalk.com");
        message.addAction(action1);

        ActionCardAction action2 = new ActionCardAction("不感兴趣", "http://www.dingtalk.com");
        message.addAction(action2);
        message.setActionButtonStyle(ActionButtonStyle.HORIZONTAL);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendActionCardMessageWithHorizontalButtonWithoutAvatar() throws Exception {
        ActionCardMessage message = new ActionCardMessage();
        message.setBannerURL("http://img01.taobaocdn.com/top/i1/LB1GCdYQXXXXXXtaFXXXXXXXXXX");
        message.setTitle("创建团队，让工作沟通更加安全高效");
        message.setBriefText("国内广受认可的企业级应用市场入驻标准高、产品质量高，入驻即代表得到市场认可，实力获得钉钉背书");
        ActionCardAction action1 = new ActionCardAction("查看详情", "dtmd://dingtalkclient/sendMessage?content=world");
        message.addAction(action1);


        ActionCardAction action2 = new ActionCardAction("不感兴趣", URLEncoder.encode("dtmd://dingtalkclient/sendMessage?content=不感兴趣", "UTF-8"));
        message.addAction(action2);
        message.setActionButtonStyle(ActionButtonStyle.HORIZONTAL);
        message.setHideAvatar(true);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }
}