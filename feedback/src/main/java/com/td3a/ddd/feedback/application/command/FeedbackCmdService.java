package com.td3a.ddd.feedback.application.command;

public interface FeedbackCmdService {

	/**
	 * 上传用户反馈信息
	 * @param feedbackRequest
	 */
	void add(FeedbackRequest feedbackRequest);
}
