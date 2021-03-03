package com.cmh.eurekaclient2.service.impl;

import com.cmh.eurekaclient2.value.BookQueryCondition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(url = "/ParamsValidation/params_validation/book/list", value = "ParamsValidation")
public interface ParamsValidationFeignClient {

    @RequestMapping(method = RequestMethod.POST, path = "ParamsValidation/params_validation/book/list", consumes = "application/json")
    String invokeParamsValidationService(@RequestBody BookQueryCondition condition);
}
