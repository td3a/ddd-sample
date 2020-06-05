package com.td3a.ddd.feedback.domain;

import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Feedback {
	private Long id;
	private String userId;
	private String userName;
	private String content;
	private String publishTime;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;


	public static Feedback fromDO(FeedbackDO feedback) {
		return Feedback.builder()
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
