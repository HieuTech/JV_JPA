package com.example.demo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtilsHelper {
    @Value("${jwt.privateKey}") // Using injected value from JwtConfig
    private String privateKey;
    public String generateToken(String data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        String jws = Jwts.builder().subject(data).signWith(key).compact();

        return jws;
    }
    public boolean verifyToken(String token){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        try{
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch (Exception e){
            return  false;
        }

    }

}
