package com.td3a.ddd.feedback.application.query;

import com.td3a.ddd.feedback.domain.Feedback;
import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackDO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// request DTO

@Data
@Builder
public class FeedbackResponse {
	private Long id;
	private String userId;
	private String userName;
	private String content;
	private String publishTime;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;


	public static FeedbackResponse from(Feedback feedback){
		return FeedbackResponse.builder()
				.id(feedback.getId())
				.userId(feedback.getUserId())
				.userName(feedback.getUserName())
				.content(feedback.getContent())
				.publishTime(feedback.getPublishTime())
				.createTime(feedback.getCreateTime())
				.updateTime(feedback.getUpdateTime())
				.build();
	}

	public static FeedbackResponse fromDO(FeedbackDO feedback) {
		return FeedbackResponse.builder()
				.id(feedback.getId())
				.userId(feedback.getUserId())
				.userName(feedback.getUserName())
				.content(feedback.getContent())
				.publishTime(feedback.getPublishTime())
				.createTime(feedback.getCreateTime())
				.updateTime(feedback.getUpdateTime())
				.build();
	}
}
