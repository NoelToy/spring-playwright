package com.noel.springplaywright.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Service
public class ScreenshotService {
    public void takeScreenshot(){
        try {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            browser.close();
            playwright.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
