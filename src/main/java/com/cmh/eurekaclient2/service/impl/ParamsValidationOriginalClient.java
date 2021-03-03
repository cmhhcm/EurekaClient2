package com.cmh.eurekaclient2.service.impl;

import com.cmh.eurekaclient2.value.BookQueryCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ParamsValidationOriginalClient {

    public String invokeParamsValidationServiceByOriginal() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(new BookQueryCondition(), headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://192.168.1.102:8080/ParamsValidation/params_validation/book/list", HttpMethod.POST, httpEntity, String.class, "");
        String result = "";
        if (exchange != null) {
            result = exchange.getBody();
            log.info("invoked body is:{}", result);
        }
        return result;
    }
}
