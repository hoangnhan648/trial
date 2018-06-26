package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class DebugTest {

    public static void main(String[] args) {
        launchBrowser("chrome");
        visit("http://www.calculator.net/bmi-calculator.html");
        click(How.XPATH, ".//a[.='Metric Units']");
        fillIn(How.ID, "cage","30");
        click(How.ID,"csex1");
        fillIn(How.ID, "cheightmeter", "220");
        fillIn(How.ID, "ckg", "50");
        click(How.XPATH, ".//input[@alt='Calculate']");
        String Result = getText(How.XPATH, ".='bigtext'");
        System.out.println(Result);


    }

}
