package com.weypage.auth.support;

import lombok.Data;

/**
 * @author shiweinan
 */
@Data
public class SimpleResponse {

    /**
     * 返回 内容
     */
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public SimpleResponse() {
    }
}
