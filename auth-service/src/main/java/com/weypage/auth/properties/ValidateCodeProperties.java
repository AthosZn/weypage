package com.weypage.auth.properties;

import lombok.Data;

/**
 * 验证码属性类
 *
 * @author shiweinan
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();
}
