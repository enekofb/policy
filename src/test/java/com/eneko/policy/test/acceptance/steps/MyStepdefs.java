package com.eneko.policy.test.acceptance.steps;

import com.eneko.policy.PolicyApplication;
import com.eneko.policy.domain.Policy;
import com.eneko.policy.rest.PolicyClient;
import com.eneko.policy.service.PolicyService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by eneko on 10/06/17.
 */
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MyStepdefs {
    @Autowired
    PolicyService policyService;

    PolicyClient policyClient =PolicyClient.builder()
            .endpoint("http://localhost:8080").build();

    private Collection<Policy> policyList;


    @Given("^a policy \"([^\"]*)\"$")
    public void a_policy(String policyName) throws Throwable {
        Policy policy = Policy.builder().name(policyName).build();
        Policy addedPolicy = policyService.add(policy);
        assertThat(policy, equalTo(addedPolicy));
    }

    @When("^get all policies$")
    public void get_all_policies() throws Throwable {
        policyList = policyClient.getAll();
        assertThat(policyList, notNullValue());
    }

    @Then("^I receive (\\d+) policy$")
    public void i_receive_policy(int numPolicies) throws Throwable {
        List<Policy> policyList = policyService.getAll();
        assertThat(policyList.size(), equalTo(numPolicies));
    }

    @Then("^its name is \"([^\"]*)\"$")
    public void its_name_is(String policyName) throws Throwable {
        Optional<Policy> policyOptional =policyList.stream().filter(policy -> policy.getName().equalsIgnoreCase(policyName)).findFirst();
        assert(policyOptional.isPresent());
    }

}
