package com.example.base64converter.controller;

import com.example.base64converter.model.Base64Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/base64")
public class Base64ConverterController {

    @PostMapping("/encode")
    public ResponseEntity<Base64Response> encodeString(@RequestBody String input) {
        try {
            String encoded = Base64.getEncoder().encodeToString(input.getBytes());
            return new ResponseEntity<>(new Base64Response("Encoding successful", encoded), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Base64Response("Error encoding string", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/decode")
    public ResponseEntity<Base64Response> decodeString(@RequestBody String base64Input) {
        try {
            byte[] decodedBytes = Base64.getMimeDecoder().decode(base64Input);
            String decodedString = new String(decodedBytes);
            return new ResponseEntity<>(new Base64Response("Decoding successful", decodedString), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // This will handle cases where the input is not valid Base64
            return new ResponseEntity<>(new Base64Response("Invalid Base64 input", null), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new Base64Response("Error decoding string", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
