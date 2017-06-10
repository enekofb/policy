package com.eneko.policy.rest;

import com.eneko.policy.domain.Policy;
import com.eneko.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by eneko on 10/06/17.
 */
@RestController
public class PolicyRestController {

    @Autowired
    private PolicyService policyService;

    @GetMapping(path = "/policies")
    public List<Policy> getAll() {
        return policyService.getAll();
    }
}
