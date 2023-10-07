package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class Controller {

    @GetMapping
    public ResponseEntity<String> basicHello() {
        final String msg = "Hi, dude! How are you?";
        return response(msg);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {
        final String msg = String.format("Hi, %s! How are you?", name);
        return response(msg);
    }

    private ResponseEntity<String> response(String msg) {
        log.info("Response: {}", msg);
        return ResponseEntity.ok(msg);
    }

}
