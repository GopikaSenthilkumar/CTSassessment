package com.example.springrest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class Controller {
    @GetMapping("/hello.txt")
    public ResponseEntity<String> getHelloText() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Date", ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        headers.add("Server", "Apache");
        headers.add("Last-Modified", "Sat, 12 Jul 2025 19:15:56 GMT");
        headers.add("ETag", "\"34aa387-d-1568eb00\"");
        headers.add("Accept-Ranges", "bytes");
        headers.add("Vary", "Accept-Encoding");
        headers.add("Content-Type", "text/plain");

        String body = "Hello World! My payload includes a trailing CRLF.";

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(body);
    }
}