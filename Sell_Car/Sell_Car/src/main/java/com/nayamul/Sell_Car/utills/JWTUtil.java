package com.nayamul.Sell_Car.utills;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtil {

    private Key getSigningKey() {
        String SECRET = "SecretKeyToGenJWTs";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private JwtParserBuilder extractClaims(String token) {
        return (JwtParserBuilder) Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = (Claims) extractClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && isTokenExpired(token));
    }

    private String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
       return Jwts.builder().setClaims(extractClaims).
                setSubject(userDetails.getUsername()).
                setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).
                signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public String generateToken(UserDetails userDetails) {
       return generateToken(new HashMap<>(), userDetails);
    }
}
