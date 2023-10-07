package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public interface RedirectRequest {
    String redirect();

    String redirect(String name);

    @Slf4j
    @Service
    class Base implements RedirectRequest {

        @Value("${host}")
        private String host;

        @Autowired
        private RestTemplate template;

        @Override
        public String redirect() {
            return getMsg(host);
        }

        @Override
        public String redirect(String name) {
            return getMsg(host + name);
        }

        private String getMsg(String url) {
            ResponseEntity<String> response = null;
            log.info("Host: {}", url);

            try {
                response = template.getForEntity(url, String.class);
            } catch (Exception e) {
                log.error("Error: {}", e.getMessage());
            }

            if (response != null && response.getStatusCode() == HttpStatus.OK) {
                return  response.getBody();
            }

            return "";
        }
    }

}
