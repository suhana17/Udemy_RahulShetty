import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableColumnSortingStrategy {
    public static void main(String[] args) {
        System.out.println("Sort table column in descending order");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fizza\\JPACT\\chromedriver.exe");
        WebDriver myD = new ChromeDriver();
        myD.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        myD.manage().window().maximize();

        List<WebElement> vegName = myD.findElements(By.cssSelector("tr td:nth-child(2)"));
        myD.findElement(By.cssSelector("tr th:nth-child(2)")).click();
        myD.findElement(By.cssSelector("tr th:nth-child(2)")).click();
        vegName.size();

        ArrayList<String> original = new ArrayList<String>();
        for (int i=0; i<vegName.size(); i++)
        {
            original.add(vegName.get(i).getText());
        }

        ArrayList<String> copied = new ArrayList<String>();
        for (int j=0; j<original.size(); j++)
        {
            copied.add(original.get(j));
        }
        System.out.println(">>>>>>>>>> copied <<<<<<<<<<<<");
        Collections.sort(copied);
        for (String s: copied)
        {
            System.out.println(s);
        }
        System.out.println(">>>>>>>>>>>> original <<<<<<<<<<<<");
        for (String s: original)
        {
            System.out.println(s);
        }

        Assert.assertTrue(original.equals(copied));
        myD.close();

    }
}
