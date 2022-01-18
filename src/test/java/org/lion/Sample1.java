package org.lion;

import org.base.BaseClass;
import org.openqa.selenium.By;

public class Sample1 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
          browserLaunch();
		
		
		
		urlLaunch("http://demo.automationtesting.in/Alerts.html");
		
		btnclick(driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")));
		btnclick(driver.findElement(By.xpath("//button[@class='btn btn-info']")));
		
		sendTextAlertBox("ramya");
		
	acceptAlert();
	btnclick(driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")));
	btnclick(driver.findElement(By.xpath("//button[@class='btn btn-primary']")));
	acceptAlert();
	
	
	ContextClickAction(driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")));
	}

}
