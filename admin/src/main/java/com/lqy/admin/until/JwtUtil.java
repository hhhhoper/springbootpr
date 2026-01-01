package com.lqy.admin.until;

import io.jsonwebtoken.Jwts;

public class JwtUtil {
    private static final String SECRET="lqy-admin-secret";
    private static final long EXPIRATION=1000*60*60*24;
    
    public static String generateToken(String username) {
        // Implementation for generating JWT token
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new java.util.Date())
                .setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, SECRET)
                .compact();
}
}