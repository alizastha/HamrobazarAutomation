package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Elements.SearchItem;




public class SearchItemTest {
	@Test
	public void SearchItemTesting() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver.exe");
		ChromeDriver chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		chromedriver.get("https://hamrobazaar.com/");

		SearchItem obj = new SearchItem(chromedriver);

		obj.SetSearchKeyword("laptop");
		Thread.sleep(2000);
		obj.GoButtonClick();
		Thread.sleep(2000);
		obj.LowToHighOption();
		Thread.sleep(2000);

		
		
	    int i = 6;
	    List<Integer> pricelist = new ArrayList<Integer>(); // array without predefine size

	    WebElement pricetag = chromedriver.findElement(By.xpath(".//table[" + (i) + "]/tbody/tr[1]/td[5]/b"));
	    for(i=6; i<=25; i++)
	    {

	        Pattern p = Pattern.compile("\\d+");
	        Matcher m = p.matcher(pricetag.getText());
	        String s = "";
	        while (m.find()) {
	            s = m.group();
	            System.out.println(s);
	        }
	        int price = Integer.parseInt(s);
	        pricelist.add(price);
	        i++;
	        pricetag = chromedriver.findElement(By.xpath(".//table[" + (i) + "]/tbody/tr[1]/td[5]/b"));
	    } 
	    if (pricelist.size() == 0)
	        System.out.println("No data");

	    List<Integer> ascSorted = new ArrayList<Integer>();

	    ascSorted.addAll(pricelist);
	    Collections.sort(ascSorted);
	    if (ascSorted.equals(pricelist))
	        System.out.println("price are sorted in ascending order");

	    chromedriver.quit();

	}
}