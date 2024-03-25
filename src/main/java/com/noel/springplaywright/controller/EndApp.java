package com.noel.springplaywright.controller;

import com.noel.springplaywright.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/endApp")
public class EndApp {
    @Autowired
    private ScreenshotService screenshotService;
    @RequestMapping(path = "/getScreenshot",method = RequestMethod.GET)
    public ResponseEntity<String> getScreenShot(){
        try{
            screenshotService.takeScreenshot();
            return ResponseEntity.ok("Hello World");
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().header("ERROR",ex.getMessage()).build();
        }
    }
}
