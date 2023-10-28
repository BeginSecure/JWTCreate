package com.beginsecure.jwtcreate;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length != 3) {
            System.out.println("Usage: java App <secret> <userId> <userName>");
            System.exit(1);
        }

        String secret = args[0];
        String userId = args[1];
        String userName = args[2];

        Map<String, Object> payload = Map.of("userId", userId, "userName", userName);

        JWTCreator.Builder builder = JWT.create()
            .withClaim("data", payload)
            .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000));

            
        String jwt = builder.sign(Algorithm.HMAC256(secret));

        System.out.printf("Generate JWT %s%n", jwt);
        
    }
}
