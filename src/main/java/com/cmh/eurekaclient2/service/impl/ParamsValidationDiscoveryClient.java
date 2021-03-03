package com.cmh.eurekaclient2.service.impl;
import com.cmh.eurekaclient2.value.BookQueryCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class ParamsValidationDiscoveryClient {
    @Autowired
    private DiscoveryClient discoveryClient;

    public String invokeParamsValidationService() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("PARAMSVALIDATION");
        if (instances == null || instances.size() == 0) {
            log.info("instances is empty..");
            return "";
        }
        String uri = instances.get(0).getUri().toString();
        String serviceUrl = String.format("%s/ParamsValidation/params_validation/book/list", uri);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        BookQueryCondition condition = new BookQueryCondition();
        HttpEntity entity = new HttpEntity(condition, headers);
        log.info("uri is :{},formatted url is:{}", uri, serviceUrl);
        ResponseEntity<String> resultExchange = restTemplate.exchange(serviceUrl, HttpMethod.POST, entity, String.class, "");
        if (resultExchange == null) {
            log.info("invoke result is null");
            return "";
        }
        String body = resultExchange.getBody();
        log.info("body is :{}", body);
        return body;
    }
}
