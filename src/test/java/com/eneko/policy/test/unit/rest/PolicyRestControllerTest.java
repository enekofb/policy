package com.eneko.policy.test.unit.rest;

import com.eneko.policy.domain.Policy;
import com.eneko.policy.rest.PolicyRestController;
import com.eneko.policy.service.PolicyService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by eneko on 10/06/17.
 */
public class PolicyRestControllerTest {
    @Mock
    PolicyService policyService;

    @InjectMocks
    PolicyRestController policyController;

    @Test
    public void catGetAllPolicy(){
        when(policyService.getAll()).
                thenReturn(Collections.singletonList(
                        Policy.builder().name("Policy").build()));
        List<Policy> policies = policyController.getAll();
        assertThat(policies.size(),equalTo(1));
    }

}
