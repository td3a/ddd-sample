package com.td3a.ddd.feedback.application.query;

import com.td3a.ddd.core.application.PageResult;

import java.util.List;

public interface FeedbackQueryService {
	List<FeedbackResponse> page();

	PageResult<FeedbackResponse> page(FeedbackRequest.FeedbackPageRequest pageRequest);
}
