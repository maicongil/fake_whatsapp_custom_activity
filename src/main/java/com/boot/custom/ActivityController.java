package com.boot.custom;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activity", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
@Slf4j
public class ActivityController {

  private static final String SECRET_KEY = "mkt&quicksilver";

  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody String payload) {
    Claims claims = decodeJWT(payload);
    claims.entrySet().stream()
        .forEach(
            entry ->
                log.info(
                    String.format(
                        "JWT ENTRY - KEY: %s VALUE: %s", entry.getKey(), entry.getValue())));

    return new ResponseEntity<>("Save", HttpStatus.OK);
  }

  @PostMapping("/publish")
  public ResponseEntity<String> publish(@RequestBody String payload) {
    return new ResponseEntity<>("Publish", HttpStatus.OK);
  }

  @PostMapping("/validate")
  public ResponseEntity<String> validate(@RequestBody String payload) {
    return new ResponseEntity<>("Validate", HttpStatus.OK);
  }

  @PostMapping("/stop")
  public ResponseEntity<String> stop(@RequestBody String payload) {
    return new ResponseEntity<>("Stop", HttpStatus.OK);
  }

  @PostMapping("/execute")
  public ResponseEntity<String> execute(@RequestBody ExecutePayload payload) {
    for (Map<String, String> inArgument : payload.getInArguments()) {
      if (inArgument.containsKey("mobileNumber")) {
        System.out.println("WhatsApp message sent to: " + inArgument.get("mobileNumber"));
      }
    }
    return new ResponseEntity<>("Executed", HttpStatus.OK);
  }

  public Claims decodeJWT(String jwt) {
    // This line will throw an exception if it is not a signed JWS (as expected)
    Claims claims =
        Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
            .parseClaimsJws(jwt)
            .getBody();
    return claims;
  }
}
