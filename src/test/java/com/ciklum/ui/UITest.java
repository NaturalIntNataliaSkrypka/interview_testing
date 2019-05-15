package com.ciklum.ui;

import com.ciklum.config.SpringConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
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
}
