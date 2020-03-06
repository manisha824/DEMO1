package com.model.portfolio.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.model.portfolio.page.AddStocksPage;
import com.model.portfolio.page.AllWeatherStrategyPage;
import com.model.portfolio.page.CustomizePortfolioPage;
import com.model.portfolio.page.verifySPDRValue;

import Utility.BrowserFactory;

public class TestCases {
	
	WebDriver driver;
	
	@Test
	public void TestA()
	{
		driver=BrowserFactory.startBrowser("chrome","https://sfo-demo.herokuapp.com/model-portfolio");
		
		AllWeatherStrategyPage allwetherpage=PageFactory.initElements(driver, AllWeatherStrategyPage.class);
		allwetherpage.goToAllWeatherStrategyPage();
		
		CustomizePortfolioPage customizefoliopage=PageFactory.initElements(driver, CustomizePortfolioPage.class);
		customizefoliopage.goToCustomizePortfolioPage();
		customizefoliopage.goToCustomize();
		customizefoliopage.slideToXvalue(50);
		customizefoliopage.goToRebalance();
		customizefoliopage.goToInvest();
		
		verifySPDRValue vrifyspdrvalue=PageFactory.initElements(driver, verifySPDRValue.class);
		float v=vrifyspdrvalue.getSPDRValue();
		Assert.assertEquals(v, 50);
	}

	@Test
	public void TestB() throws InterruptedException
	{
		driver=BrowserFactory.startBrowser("chrome","https://sfo-demo.herokuapp.com/model-portfolio");
		
		AllWeatherStrategyPage allwetherpage=PageFactory.initElements(driver, AllWeatherStrategyPage.class);
		allwetherpage.goToAllWeatherStrategyPage();
		
		CustomizePortfolioPage customizefoliopage=PageFactory.initElements(driver, CustomizePortfolioPage.class);
		customizefoliopage.goToCustomizePortfolioPage();
		
		customizefoliopage.goToCustomize();
		customizefoliopage.verfyResetText();
		
		AddStocksPage addstock=PageFactory.initElements(driver, AddStocksPage.class);
		addstock.goToAddStocksPage();
		addstock.addStockForBT();
		addstock.done();
		
		Assert.assertTrue(customizefoliopage.checkBTStocksExists());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
