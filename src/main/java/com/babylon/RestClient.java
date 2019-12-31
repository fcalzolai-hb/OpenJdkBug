package com.babylon;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

  public void working() {
    RestTemplate restTemplate = null;
    ParameterizedTypeReference<Object> responseType = new ParameterizedTypeReference<>() {
    };
    ResponseEntity<Object> test = restTemplate.exchange(
        "https://example.com",
        HttpMethod.GET,
        new HttpEntity<>(null),
        responseType);
  }

  // NOT WORKING with OpenJdk version 11.0.3 because of the bug: JDK-8222754
  public void notWorking() {
    RestTemplate restTemplate = null;
    ResponseEntity<Object> test = restTemplate.exchange(
        "https://example.com",
        HttpMethod.GET,
        new HttpEntity<>(null),
        new ParameterizedTypeReference<>(){});
  }

}
