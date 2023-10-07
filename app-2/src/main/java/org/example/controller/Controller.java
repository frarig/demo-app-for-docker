package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.RedirectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private RedirectRequest redirectRequest;

    @GetMapping("/")
    public ResponseEntity<String> basicRequest() {
        final String msg = redirectRequest.redirect();
        return response(msg);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> requestWithName(@PathVariable String name) {
        final String msg = redirectRequest.redirect(name);
        return response(msg);
    }

    private ResponseEntity<String> response(String msg) {
        log.info("Response: {}", msg);
        return ResponseEntity.ok(msg);
    }

}
