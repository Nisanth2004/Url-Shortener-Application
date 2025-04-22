package com.url.shortener.controller;


import com.url.shortener.dto.ClickEventDto;
import com.url.shortener.dto.UrlMappingDto;
import com.url.shortener.entity.User;
import com.url.shortener.service.UrlMappingService;
import com.url.shortener.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
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
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UrlMappingDto> createShortenUrl(@RequestBody Map<String,String> request,
                                                          Principal principal
                                                          )
    {
        String originalUrl=request.get("originalUrl");
        User user=userService.findByUsername(principal.getName());
        // call the service
        UrlMappingDto urlMappingDto=urlMappingService.createShortUrl(originalUrl,user);

        return ResponseEntity.ok(urlMappingDto);
    }

    @GetMapping("/myurls")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UrlMappingDto>> getUserUrls(Principal principal)
    {
        User user=userService.findByUsername(principal.getName());
        List<UrlMappingDto> urls=urlMappingService.getUrlsByUser(user);
        return ResponseEntity.ok(urls);
    }


    @GetMapping("/analytics/[shortUrl}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ClickEventDto> getUrlAnalytics(@PathVariable String shortUrl,
                                                         @RequestParam("startDate") String startDate,
                                                         @RequestParam("endDate") String endDate
                                                         )
    {
        return null;

    }
}
