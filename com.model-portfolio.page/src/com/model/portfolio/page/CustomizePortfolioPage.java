package com.model.portfolio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class CustomizePortfolioPage
{
	WebDriver driver;
	
	public CustomizePortfolioPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Customize Portfolio")
	WebElement customizeportfolio;
	
	@FindBy(how=How.LINK_TEXT,using="Customise")
	WebElement customize;
	
	@FindBy(how=How.CLASS_NAME,using="col-md-9")
	WebElement slider;
	
	@FindBy(how=How.XPATH,using="//*[@type=\"range\"]")
	WebElement slideattribute;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"customise-portfolio\"]/div/div[2]/div/div[1]/div[3]/a")
	WebElement reset;
	
	@FindBy(how=How.LINK_TEXT,using="BT Group plc")
	WebElement btstocks;
	
	@FindBy(how=How.LINK_TEXT,using="Rebalance")
	WebElement rebalance;
	
	@FindBy(how=How.LINK_TEXT,using="Invest Now")
	WebElement invest;
	
	public void goToCustomizePortfolioPage()
	{
		customizeportfolio.click();
	}
	
	public void goToCustomize()
	{
		customize.click();
	}
	
	public void slideToXvalue(int x)
	{
        Actions move = new Actions(driver);
        @SuppressWarnings("unused")
		int xCoord = slideattribute.getLocation().getX();
        @SuppressWarnings("unused")
		int yCoord = slideattribute.getLocation().getY();
        @SuppressWarnings("unused")
		int max=Integer.parseInt(slideattribute.getAttribute("max"));
        @SuppressWarnings("unused")
		int min=Integer.parseInt(slideattribute.getAttribute("min"));
        Action action = (Action) move.dragAndDropBy(slider, 1, 0).build();
        action.perform();
	}
	
	public void verfyResetText()
	{
		String str=reset.getText();
		//System.out.println(str);
		Assert.assertTrue(str.equalsIgnoreCase("Reset"));
	}
	
	public boolean checkBTStocksExists()
	{
		if (driver.findElements(By.linkText("BT Group plc") ).size() != 0) {
			return true;
		}
		return false;
	}
	
	public void goToRebalance()
	{
		rebalance.click();
	}
	
	
	public void goToInvest()
	{
		invest.click();
	}
	
}

