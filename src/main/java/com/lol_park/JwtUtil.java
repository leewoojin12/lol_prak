package com.lol_park;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



    @Component
    public class JwtUtil {
        private final String SECRET_KEY = "9238yrhowfesdv089y2hgu3wesv9d08yguob21ip39r0wefy8hof29038tfweuvbjsn239084u"; // 비밀키는 환경변수로 관리하는 것이 좋습니다.
        private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간
        private SecretKey secretKey;


        public JwtUtil() {
            secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
        }
        public String generateToken(String username, String role) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("ROLE", role);
            return createToken(claims, username);
        }

        private String createToken(Map<String, Object> claims, String subject) {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(subject)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(secretKey)
                    .compact();
        }

        public boolean validateToken(String token, String username) {
            final String extractedUsername = extractUsername(token);
            return (extractedUsername.equals(username) && !isTokenExpired(token));
        }

        public String extractUsername(String token) {
            return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("userName", String.class);
        }

        private boolean isTokenExpired(String token) {

            return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
        }
    }


