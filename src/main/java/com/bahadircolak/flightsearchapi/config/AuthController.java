package com.bahadircolak.flightsearchapi.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final String SECRET = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    @GetMapping("/generate-token")
    public String generateToken() {
        Key hmacKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET));

        Instant now = Instant.now();
        return Jwts.builder()
                .claim("name", "Bahadir Colak")
                .claim("email", "bahadir@example.com")
                .setSubject("bahadir")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5, ChronoUnit.MINUTES)))
                .signWith(hmacKey, SignatureAlgorithm.HS256)
                .compact();
    }
}

