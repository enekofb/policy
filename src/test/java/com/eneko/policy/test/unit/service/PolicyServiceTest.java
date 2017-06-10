package com.eneko.policy.test.unit.service;

import com.eneko.policy.domain.Policy;
import com.eneko.policy.repository.PolicyRepository;
import com.eneko.policy.service.PolicyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static java.util.function.Predicate.isEqual;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by eneko on 10/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyServiceTest {

    @Mock
    PolicyRepository policyRepository;

    @InjectMocks
    PolicyService policyService;

    @Test
    public void canAddPolicy() {
        Policy policy = Policy.builder().name("policyName").build();
        when(policyRepository.insert(policy)).thenReturn(policy);
        Policy addedPolicy = policyService.add(policy);
        assertThat(policy,equalTo(addedPolicy));
    }

    @Test
    public void canGetAllPolicy() {
        Policy policy = Policy.builder().name("policyName").build();
        when(policyRepository.findAll()).thenReturn(Collections.singletonList(policy));
        List<Policy> policies = policyService.getAll();
        assertThat(policies.size(),equalTo(1));
        assertThat(policies,hasItems(policy));
    }
}
