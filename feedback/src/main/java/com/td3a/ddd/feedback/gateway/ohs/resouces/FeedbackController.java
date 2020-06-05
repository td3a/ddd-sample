package com.td3a.ddd.feedback.gateway.ohs.resouces;

import com.td3a.ddd.core.application.ResourceResult;
import com.td3a.ddd.feedback.application.query.FeedbackQueryService;
import com.td3a.ddd.feedback.application.query.FeedbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * 用户反馈信息
 *
 */

@RestController
@RequestMapping("/feedback")
public class FeedbackController {


	@Autowired
	private FeedbackQueryService feedbackQueryService;

	@GetMapping("/list")
	public ResponseEntity<?> findAll(){
		ResponseEntity re = ResourceResult.with("find feedback all")
				.onSuccess(HttpStatus.OK)
				.onError(HttpStatus.BAD_REQUEST)
				.onFailed(HttpStatus.NOT_FOUND)
				.execute(() -> feedbackQueryService.page());
		return re;
	}

	@GetMapping("/page")
	public ResponseEntity<?> page(FeedbackRequest.FeedbackPageRequest feedbackPageRequest){
		ResponseEntity re = ResourceResult.with("find feedback all")
				.onSuccess(HttpStatus.OK)
				.onError(HttpStatus.BAD_REQUEST)
				.onFailed(HttpStatus.NOT_FOUND)
				.execute(() -> feedbackQueryService.page(feedbackPageRequest));
		return re;
	}
}
