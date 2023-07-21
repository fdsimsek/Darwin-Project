package com.etiya.darwinproject1.core.utilities.responseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {

        LinkedHashMap<String, Object> response = new LinkedHashMap<>();
        response.put("returnCode", httpStatus);
        response.put("returnMessage", message);
        response.put("data", responseObject);


        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, Object responseObject) {

        LinkedHashMap<String, Object> response = new LinkedHashMap<>();
        response.put("returnCode", httpStatus);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }

}
