package com.soraka.gateway.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 服务降级提示
 *
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.gateway.fallback
 */
@Slf4j
public class SorakaFallbackResponse implements ClientHttpResponse {
    private Throwable cause;
    private String service;
    private String message;

    public SorakaFallbackResponse(Throwable cause, String service, String message) {
        this.cause = cause;
        this.service = service;
        this.message = message;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return HttpStatus.SERVICE_UNAVAILABLE.value();
    }

    @Override
    public String getStatusText() throws IOException {
        return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
    }

    @Override
    public void close() {
    }

    @Override
    public InputStream getBody() {
        if (cause != null && cause.getMessage() != null) {
            log.error("调用:{} 异常：{}", service, cause.getMessage());
            return new ByteArrayInputStream(cause.getMessage().getBytes());
        } else {
            log.error("调用:{} 异常：{}", service, message);
            return new ByteArrayInputStream(message.getBytes());
        }
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
