package com.model.portfolio.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllWeatherStrategyPage
{
	WebDriver driver;
	
	public AllWeatherStrategyPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"btn-explore79\"]")
	WebElement allweatherstrategy;
	
	public void goToAllWeatherStrategyPage()
	{
		allweatherstrategy.click();
	}
	
}