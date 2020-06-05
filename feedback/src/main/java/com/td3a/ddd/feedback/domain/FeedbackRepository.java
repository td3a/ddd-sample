package com.td3a.ddd.feedback.domain;

import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FeedbackRepository {
	List<FeedbackDO> findByDesc();

	List<FeedbackDO> findByUserId(String userId);

	Page<FeedbackDO> page(int pageNumber, int pageSize);

}
