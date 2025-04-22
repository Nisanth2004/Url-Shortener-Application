package com.url.shortener.controller;


import com.url.shortener.dto.UrlMappingDto;
import com.url.shortener.service.UrlMappingService;
import com.url.shortener.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/urls")
@AllArgsConstructor
public class UrlMappingController {

    private UrlMappingService urlMappingService;
    private UserService userService;

    // {"key":"value"}
    // {"originalUrl":"https://example.com"}
    @PostMapping("/shorten")
    public ResponseEntity<UrlMappingDto> createShortenUrl(@RequestBody Map<String,String> request,
                                                          Principal principal
                                                          )
    {
        String originalUrl=request.get("originalUrl");

        return null;


    }
}
