package com.td3a.ddd.feedback.application.command;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 客户反馈信息上传数据
 */

@Data
@Builder
public class FeedbackRequest {
	private String content;
	private List<String> files;
}
