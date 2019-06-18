package com.boot.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Map<String, Object> payload) {
        return new ResponseEntity<>("Save", HttpStatus.OK);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody Map<String, Object> payload) {
        return new ResponseEntity<>("Publish", HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validate (@RequestBody Map<String, Object> payload) {
        return new ResponseEntity<>("Validate", HttpStatus.OK);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stop (@RequestBody Map<String, Object> payload) {
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
