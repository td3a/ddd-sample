package com.td3a.ddd.feedback.gateway.acl.repository;

import com.td3a.ddd.feedback.domain.FeedbackRepository;
import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackDO;
import com.td3a.ddd.feedback.gateway.acl.persistence.FeedbackRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {

	@Autowired
	private FeedbackRepositoryJPA repositoryJPA;

	@Override
	public List<FeedbackDO> findByDesc() {
		return repositoryJPA.findAll(Sort.by(Sort.Direction.DESC, "createTime"));
	}

	@Override
	public List<FeedbackDO> findByUserId(String userId) {

		return repositoryJPA.findByUserName(userId);
	}


	@Override
	public Page<FeedbackDO> page(int pageNumber, int pageSize) {
		Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
		Pageable pageable1 = PageRequest.of(pageNumber, pageSize, sort);
		return repositoryJPA.findAll(pageable1);
	}
}
