package org.drop;

import org.base.BaseClass;
import org.openqa.selenium.By;

public class Dropdown extends BaseClass {
	public static void main(String[] args) {
		browserLaunch();
		urlLaunch("http://demo.guru99.com/test/newtours/register.php");
		
		dropdownIndex(driver.findElement(By.name("country")), 2);
		
		textfromBox(driver.findElement(By.name("country")));
	}

}