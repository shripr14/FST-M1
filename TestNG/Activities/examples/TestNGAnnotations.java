package examples;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @Test
    public void ab(){
        System.out.println("Test A");
    }
    @Test
    public void bc(){
        System.out.println("Test B");
    }
    @Test
    public void cd(){
        System.out.println("Test C");
    }
    @Test
    public void ef(){
        System.out.println("Test D");
    }
    @BeforeTest
    public void abBT(){
        System.out.println("Before test A");
    }
    @BeforeTest
    public void bcBT(){
        System.out.println("Before test B");
    }
    @AfterTest
    public void abAT(){
        System.out.println("After test A");
    }
    @AfterTest
    public void bcAT(){
        System.out.println("After test B");
    }
    @BeforeMethod
    public void abBM(){
        System.out.println("Before method A");
    }
    @BeforeMethod
    public void bcBM(){
        System.out.println("Before method B");
    }
    @AfterMethod
    public void abAM(){
        System.out.println("After method A");
    }
    @AfterMethod
    public void bcAM(){
        System.out.println("After method B");
    }
    @BeforeSuite
    public void abBS(){
        System.out.println("Before Suite A");
    }
    @BeforeSuite
    public void bcBS(){
        System.out.println("Before Suite B");
    }
    @AfterSuite
    public void abAS(){
        System.out.println("After Suite A");
    }
    @AfterSuite
    public void bcAS(){
        System.out.println("After Suite B");
    }

}
