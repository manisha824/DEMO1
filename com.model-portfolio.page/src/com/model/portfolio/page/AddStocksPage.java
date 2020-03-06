package com.model.portfolio.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddStocksPage
{
	WebDriver driver;
	
	public AddStocksPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.LINK_TEXT,using="+ Add Stock")
	WebElement addstocks;
	
	@FindBy(how=How.XPATH,using="//button[@data-isin=\"BT\"]")
	WebElement addstockBT;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"modal-1\"]/div/div/div[3]/button")
	WebElement doneelem;
	
	public void goToAddStocksPage() throws InterruptedException
	{
		addstocks.click();
		Thread.sleep(1000);
	}
	
	public void addStockForBT()
	{
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		addstockBT.click();
	}
	
	public void done()
	{
		doneelem.click();
		//driver.close();
	}
}

