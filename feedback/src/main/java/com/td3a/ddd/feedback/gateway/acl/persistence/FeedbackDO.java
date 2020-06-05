package com.td3a.ddd.feedback.gateway.acl.persistence;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fb_feedback")
@Data
public class FeedbackDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userId;
	private String userName;
	private String content;
	private String publishTime;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

}
