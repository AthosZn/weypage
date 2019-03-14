package com.weypage.auth.validate.code;

import com.weypage.auth.validate.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成器
 */
public interface ValidateCodeGenerator {

    ImageCode createCode(ServletWebRequest request);
}
