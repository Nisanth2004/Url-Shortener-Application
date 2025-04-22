package com.url.shortener.repository;

import com.url.shortener.entity.UrlMapping;
import com.url.shortener.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlMappingRepository extends JpaRepository<UrlMapping,Long> {

    UrlMapping findByShortUrl(String shortUrl);
    List<UrlMapping> findByUser(User user);
}
