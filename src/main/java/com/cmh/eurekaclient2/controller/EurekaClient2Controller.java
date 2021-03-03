package com.cmh.eurekaclient2.controller;

import com.cmh.eurekaclient2.service.impl.ParamsValidationDiscoveryClient;
import com.cmh.eurekaclient2.service.impl.ParamsValidationFeignClient;
import com.cmh.eurekaclient2.service.impl.ParamsValidationOriginalClient;
import com.cmh.eurekaclient2.service.impl.ParamsValidationRestTemplateClient;
import com.cmh.eurekaclient2.value.BookQueryCondition;
import com.cmh.eurekaclient2.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EurekaClient2Controller {

    @Autowired
    private ParamsValidationOriginalClient originalClient;

    @Autowired
    private ParamsValidationDiscoveryClient paramsValidationDiscoveryClient;

    @Autowired
    private ParamsValidationRestTemplateClient restTemplateClient;

/*
    @Autowired
    private ParamsValidationFeignClient feignClient;
*/

    @GetMapping("/original_invoke")
    public ResponseVO invokeByOriginalMethod() {
        originalClient.invokeParamsValidationServiceByOriginal();
        return ResponseVO.success("BINGO! invoke paramsValidation service  by original success!");
    }

    @GetMapping("/discovery_client")
    public ResponseVO invokeByDiscoveryClient() {
        paramsValidationDiscoveryClient.invokeParamsValidationService();
        return ResponseVO.success("BINGO! invoke paramsValidation service  by discover_client success!");
    }

    @GetMapping("/ribbon_rest_template")
    public ResponseVO invokeByRibbonRestTemplate() {
        restTemplateClient.invokeParamsValidationService();
        return ResponseVO.success("BINGO! invoke paramsValidation service  by ribbon rest success!");
    }

    @GetMapping("/feign")
    public ResponseVO invokeByFeiginClient() {
/*
        String result = feignClient.invokeParamsValidationService(new BookQueryCondition());
        log.info("feign invoke result is :{}", result);
        return ResponseVO.success(result);
*/
        return null;
    }

}
