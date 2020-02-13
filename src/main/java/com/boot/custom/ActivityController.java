package com.boot.custom;

import com.auth0.jwt.interfaces.DecodedJWT;
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
    logReceivedData(payload);
    return new ResponseEntity<>("Save", HttpStatus.OK);
  }

  @PostMapping("/publish")
  public ResponseEntity<String> publish(@RequestBody String payload) {
    logReceivedData(payload);
    return new ResponseEntity<>("Publish", HttpStatus.OK);
  }

  @PostMapping("/validate")
  public ResponseEntity<String> validate(@RequestBody String payload) {
    logReceivedData(payload);
    return new ResponseEntity<>("Validate", HttpStatus.OK);
  }

  @PostMapping("/stop")
  public ResponseEntity<String> stop(@RequestBody String payload) {
    logReceivedData(payload);
    return new ResponseEntity<>("Stop", HttpStatus.OK);
  }

  @PostMapping("/execute")
  public ResponseEntity<String> execute(@RequestBody String payload) {
    logReceivedData(payload);
    //    for (Map<String, String> inArgument : payload.getInArguments()) {
    //      if (inArgument.containsKey("mobileNumber")) {
    //        System.out.println("WhatsApp message sent to: " + inArgument.get("mobileNumber"));
    //      }
    //    }
    return new ResponseEntity<>("Executed", HttpStatus.OK);
  }

  private void logReceivedData(String payload) {
    DecodedJWT decode = JwtUtils.decode(payload);
    decode.getClaims().entrySet().stream()
        .forEach(
            entry ->
                log.info(
                    String.format(
                        "JWT decoded entry - KEY: %s - VALUE: %s",
                        entry.getKey(), entry.getValue())));
  }
}
