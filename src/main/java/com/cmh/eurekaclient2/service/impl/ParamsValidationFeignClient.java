package com.cmh.eurekaclient2.service.impl;

import com.cmh.eurekaclient2.value.BookQueryCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ParamsValidation")
public interface ParamsValidationFeignClient {

    @PostMapping("ParamsValidation/params_validation/book/list")
    String invokeParamsValidationService(@RequestBody BookQueryCondition condition);
}
