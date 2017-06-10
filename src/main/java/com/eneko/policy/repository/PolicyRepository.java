package com.eneko.policy.repository;

import com.eneko.policy.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 10/06/17.
 */
@Component
public interface PolicyRepository extends MongoRepository<Policy, String> {

}