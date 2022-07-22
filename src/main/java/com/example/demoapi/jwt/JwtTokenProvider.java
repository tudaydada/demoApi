package com.example.demoapi.jwt;

import com.example.demoapi.until.CustomUserDetail;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Slf4j
public class JwtTokenProvider {
    private String jwtSecretKey = "duckwin";
    private final long expirationTime = 30 * 24 * 60 * 60;

    public String generateToken(CustomUserDetail customUserDetail) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Long.toString(customUserDetail.getAccount().getAccountId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();
    }

    public Long getUserId(String token) {
        return Long.parseLong(Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
