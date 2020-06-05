package com.td3a.ddd.feedback.application.query;

import com.td3a.ddd.core.application.PageResult;
import com.td3a.ddd.feedback.domain.Feedback;
import com.td3a.ddd.feedback.domain.FeedbackDomainService;
import com.td3a.ddd.feedback.domain.FeedbackRepository;
import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackQueryServiceImpl implements FeedbackQueryService{

	@Autowired
	private FeedbackDomainService feedbackDomainService;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public List<FeedbackResponse> page() {
		List<FeedbackResponse> results = new ArrayList<>();
		String userId = null;
		//获取 当前用户，
		if(StringUtils.isEmpty(userId)){
			List<FeedbackDO> r = feedbackRepository.findByDesc();
			results = r.stream().map(FeedbackResponse::fromDO).collect(Collectors.toList());
		} else {
			List<Feedback> re = feedbackDomainService.findByUserId(userId);
			results = re.stream().map(FeedbackResponse::from).collect(Collectors.toList());
		}
		return results;
	}

	@Override
	public PageResult<FeedbackResponse> page(FeedbackRequest.FeedbackPageRequest feedbackPageRequest) {
		Page<FeedbackDO> r = feedbackRepository.page(feedbackPageRequest.getPageNumber(), feedbackPageRequest.getPageSize());
		PageResult<FeedbackResponse> pageResult = new PageResult();
		pageResult.setPageNo(r.getNumber());
		pageResult.setTotalPage(r.getTotalPages());
		pageResult.setTotalRecord(r.getTotalElements());
		pageResult.setList(r.toList().stream().map(FeedbackResponse::fromDO).collect(Collectors.toList()));
		return  pageResult;
	}
}
