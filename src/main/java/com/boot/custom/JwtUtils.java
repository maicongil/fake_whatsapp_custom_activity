package com.boot.custom;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;

public class JwtUtils {

  public static DecodedJWT decode(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("796f75722d3235362d6269742d736563726574");
      JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
      return verifier.verify(token);
    } catch (JWTVerificationException exception) {
      // Invalid signature/claims
      exception.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    try {
      Algorithm algorithm = Algorithm.HMAC256("your-256-bit-secret");
      JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
      return verifier.verify(token);
    } catch (JWTVerificationException exception) {
      // Invalid signature/claims
      exception.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
