package com.td3a.ddd.feedback.gateway.acl.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepositoryJPA extends JpaRepository<FeedbackDO, Long> {

	List<FeedbackDO> findByUserName(String username);
}
