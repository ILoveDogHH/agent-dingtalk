package com.dingtalk.chatbot.message;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * Created by dustin on 2017/3/18.
 */
public class LinkMessage implements Message {

	private String title;
	private String text;
	private String picUrl;
	private String messageUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMessageUrl() {
		return messageUrl;
	}

	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}


	@Override
	public String toJsonString() {
		Map<String, Object> items = new HashMap<>();
		items.put("msgtype", "link");

		Map<String, String> linkContent = new HashMap<>();
		if (StringUtils.isBlank(title)) {
			throw new IllegalArgumentException("title should not be blank");
		}
		linkContent.put("title", title);

		if (StringUtils.isBlank(messageUrl)) {
			throw new IllegalArgumentException("messageUrl should not be blank");
		}
		linkContent.put("messageUrl", messageUrl);

		if (StringUtils.isBlank(text)) {
			throw new IllegalArgumentException("text should not be blank");
		}
		linkContent.put("text", text);

		if (StringUtils.isNotBlank(picUrl)) {
			linkContent.put("picUrl", picUrl);
		}

		items.put("link", linkContent);

		return JSON.toJSONString(items);
	}
}
