package com.yp.poc.gzip.controller;

import com.yp.poc.gzip.model.GetResponse;
import com.yp.poc.gzip.model.PostRequest;
import com.yp.poc.gzip.model.PostResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contains methods EXPOSED for Unicomer user-service
 */
@RestController
public class RequestController {

    @GetMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetResponse> getTest() {
        GetResponse getResponse = new GetResponse();
        getResponse.setMessage("Hello World !!!");
        return ResponseEntity.ok(getResponse);
    }

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostResponse getPost(@RequestBody PostRequest postRequest) {
        PostResponse postResponse = new PostResponse();
        postResponse.setGreeting("Hi " + postRequest.getFirstName() + " " + postRequest.getLastName());
        postResponse.setContact("You can contact me in: " + postRequest.getPhone());
        return postResponse;
    }
}
