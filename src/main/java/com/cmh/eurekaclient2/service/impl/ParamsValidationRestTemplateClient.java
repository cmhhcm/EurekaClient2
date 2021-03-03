package com.cmh.eurekaclient2.service.impl;

import com.cmh.eurekaclient2.value.BookQueryCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ParamsValidationRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public String invokeParamsValidationService() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        BookQueryCondition queryCondition = new BookQueryCondition();
        HttpEntity httpEntity = new HttpEntity(queryCondition, headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://ParamsValidation/ParamsValidation/params_validation/book/list", HttpMethod.POST, httpEntity, String.class, "");
        String result = "";
        if (exchange != null) {
            result = exchange.getBody();
            log.info("rest template invoke result: {}", result);
        }
        return result;
    }
}
