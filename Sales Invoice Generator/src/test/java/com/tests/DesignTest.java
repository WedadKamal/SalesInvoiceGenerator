package com.tests;
import com.view.View;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class DesignTest {

    @Test(description = "Validate the initiate design of SIG",priority = 0 ,enabled = true)
    public void checkDesign() throws InterruptedException, IOException {
        View V = new View();
        V.setVisible(true);
        Thread.sleep(10000);
    }

}
