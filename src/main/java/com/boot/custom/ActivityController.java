package com.boot.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/activity", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
public class ActivityController {

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody String payload) {
        return new ResponseEntity<>("Save", HttpStatus.OK);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody String payload) {
        return new ResponseEntity<>("Publish", HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validate (@RequestBody String payload) {
        return new ResponseEntity<>("Validate", HttpStatus.OK);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stop (@RequestBody String payload) {
        return new ResponseEntity<>("Stop", HttpStatus.OK);
    }

    @PostMapping("/execute")
    public ResponseEntity<String>  execute (@RequestBody ExecutePayload payload) {
        for (Map<String, String> inArgument : payload.getInArguments()) {
            if(inArgument.containsKey("mobileNumber")){
                System.out.println("WhatsApp message sent to: " + inArgument.get("mobileNumber"));
            }
        }
        return new ResponseEntity<>("Executed", HttpStatus.OK);
    }
}
