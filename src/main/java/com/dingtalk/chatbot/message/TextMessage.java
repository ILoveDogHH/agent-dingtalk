package com.dingtalk.chatbot.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;


/**
 * Created by dustin on 2017/3/17.
 */
public class TextMessage implements Message {

	private String text;
	private List<String> atMobiles;
	private boolean isAtAll;

	public TextMessage(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getAtMobiles() {
		return atMobiles;
	}

	public void setAtMobiles(List<String> atMobiles) {
		this.atMobiles = atMobiles;
	}

	public boolean isAtAll() {
		return isAtAll;
	}

	public void setIsAtAll(boolean isAtAll) {
		this.isAtAll = isAtAll;
	}

	@Override
	public String toJsonString() {
		Map<String, Object> items = new HashMap<>();
		items.put("msgtype", "text");

		Map<String, String> textContent = new HashMap<>();
		if (StringUtils.isBlank(text)) {
			throw new IllegalArgumentException("text should not be blank");
		}
		textContent.put("content", text);
		items.put("text", textContent);

		Map<String, Object> atItems = new HashMap<>();
		if (atMobiles != null && !atMobiles.isEmpty()) {
			atItems.put("atMobiles", atMobiles);
		}
		if (isAtAll) {
			atItems.put("isAtAll", isAtAll);
		}
		items.put("at", atItems);

		return JSON.toJSONString(items);
	}
}
