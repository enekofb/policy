package com.eneko.policy.test.unit.repository;

import com.eneko.policy.domain.Policy;
import com.eneko.policy.repository.PolicyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyRepositoryTest {
    private static Logger LOG = LoggerFactory.getLogger(PolicyRepositoryTest.class);

    @Autowired
    PolicyRepository policyRepository;

    @Test
    public void canCreatePolicyRepository(){
        assertThat(policyRepository,notNullValue());
    }

    @Test
    public void canInsertPolicy(){
        Policy policy =policyRepository.insert(Policy.builder().name("policyName").build());
        LOG.debug(policy.toString());
        assertThat(policy,notNullValue());
        assertThat(policy.getName(),equalToIgnoringCase("policyName"));
    }

}