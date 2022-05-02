package examples;

import org.testng.annotations.Test;

public class SkipTestCase {
    @Test(priority = 0)
    public void One() {
        System.out.println("This is the Test Case number One");
    }

    @Test(priority = 1, enabled = false)
    public void Two() {
        System.out.println("This is the Test Case number Two");
    }
}
