package com.eneko.policy.test.unit.domain;

import com.eneko.policy.domain.Policy;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by eneko on 10/06/17.
 */
public class PolicyTest {


    @Test
    public void canCreatePolicy(){
        String policyName = "myPolicyName";
        Policy policy=Policy.builder().name(policyName).build();
        assertThat(policy,notNullValue());
        assertThat(policy.getName(),equalTo(policyName));
    }

}
