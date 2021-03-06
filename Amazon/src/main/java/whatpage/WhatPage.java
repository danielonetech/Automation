package whatpage;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class WhatPage {
	WebDriver driver;

	public WhatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void searchhimanshu() {
		// List<WebElement> elements =
		// driver.findElements(By.xpath("//*[@id='dealTitle']//parent::div//following-sibling::div[3]/div/span/span/span/button"));
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dealTitle']"));
		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Radio button text:" + elements.get(i).getAttribute("href"));
		}

	}

}
