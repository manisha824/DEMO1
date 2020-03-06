package com.model.portfolio.page;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class verifySPDRValue
{
	WebDriver driver;
	
	public verifySPDRValue(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//div[@role='tabpanel']//div[@class='card-block']//ul/li[1]//div[3]/span[1]")

	WebElement value;
	
	public float getSPDRValue()
	{	
		float v=Float.parseFloat(value.getText());
		return v;
	}
}
	