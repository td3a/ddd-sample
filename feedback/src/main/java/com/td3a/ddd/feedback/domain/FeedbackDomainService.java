package com.td3a.ddd.feedback.domain;

import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FeedbackDomainService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	public List<Feedback> findByUserId(String userId) {
		List<FeedbackDO> re =feedbackRepository.findByUserId( userId);
		return re.stream().map(Feedback::fromDO).collect(Collectors.toList());
	}
}
