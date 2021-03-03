package com.cmh.eurekaclient2.vo;


import com.cmh.eurekaclient2.annotation.PreventCsvInjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvInjectionVO {

    @NotEmpty(message = "不能为空")
    @NotNull(message = "不能为null")
    @PreventCsvInjection(message = "参数不合法")
    private String name;

    @Pattern(regexp = "^(?!@|=|-|_|\\+).*", message = "参数不合法")
    private String nameTestPatternAnnotation;

}
