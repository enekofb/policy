package com.eneko.policy.rest;

import com.eneko.policy.domain.Policy;
import lombok.Builder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static java.lang.String.*;
import static java.util.Arrays.asList;

/**
 * Created by eneko on 10/06/17.
 */
@Builder
public class PolicyClient {

    @Builder.Default
    private RestTemplate restTemplate = new RestTemplate();

    private String endpoint;

    public List<Policy> getAll(){
        return asList(restTemplate.getForEntity(
                URI.create(format("%s/policies", endpoint))
                        ,Policy[].class).getBody());
    }
}
