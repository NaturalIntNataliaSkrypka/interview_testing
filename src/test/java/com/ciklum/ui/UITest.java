package com.ciklum.ui;

import com.ciklum.config.SpringConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UITest {

    @Autowired
    private WebDriver webDriver;

    /*
    1. Open page https://jobs.ciklum.com/
    2. Click on Open Vacancies
    3. Wait for first position to be shown
    4. Check first position title
     */
    @Test
    public void testOpenPage() {
        webDriver.get("https://jobs.ciklum.com/");
        webDriver.findElement(By.xpath("//a[contains(text(),'Open Vacancies')]")).click();
        new WebDriverWait(webDriver, 5).until(webDriver -> webDriver.findElement(By.xpath("//section[@class='published-jobs']//p[@class='job-title']")).isDisplayed());
        String title = webDriver.findElement(By.xpath("//section[@class='published-jobs']//p[@class='job-title']")).getText();
        Assertions.assertEquals("Senior iOS Developer for Mercedes Pay", title);
    }
}
