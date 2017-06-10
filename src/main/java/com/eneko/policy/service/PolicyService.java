package com.eneko.policy.service;

import com.eneko.policy.domain.Policy;
import com.eneko.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eneko on 10/06/17.
 */
@Component
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    public Policy add(Policy policy) {
        return  policyRepository.insert(policy);
    }

    public List<Policy> getAll() {
        return policyRepository.findAll();
    }
}
