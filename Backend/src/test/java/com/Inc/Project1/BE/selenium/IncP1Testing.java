package com.Inc.Project1.BE.selenium;
 
import static org.mockito.ArgumentMatchers.contains;

import java.time.Duration;
 
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.test.context.jdbc.Sql;

import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
 
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)

@TestMethodOrder(OrderAnnotation.class)

@Sql(scripts = { "classpath:shop-schema.sql",

		"classpath:shop-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
 
public class IncP1Testing {
 
	private RemoteWebDriver driver;

	private WebDriverWait wait;
 
	@LocalServerPort

	private int port;
 
	@BeforeEach

	void init() {

		this.driver = new ChromeDriver();

		this.driver.manage().window().maximize();

		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	}
 
	@Test

	@Order(1)
 
	void testLogin() throws InterruptedException {

		this.driver.get("http://localhost:" + this.port);
 
		WebElement clickUsername = this.driver

				.findElement(By.cssSelector("#root > div > div > div > form > label:nth-child(1) > input[type=text]"));

		clickUsername.click();
 
		WebElement typeUsername = this.driver

				.findElement(By.cssSelector("#root > div > div > div > form > label:nth-child(1) > input[type=text]"));

		typeUsername.sendKeys("Patryk");
 
		WebElement clickPassword = this.driver

				.findElement(By.cssSelector("#root > div > div > div > form > label:nth-child(3) > input[type=password]"));

		clickPassword.click();
 
		WebElement typePassword = this.driver

				.findElement(By.cssSelector("#root > div > div > div > form > label:nth-child(3) > input[type=password]"));

		typePassword.sendKeys("password");
 
		WebElement clickSignIn = this.driver.findElement(By.cssSelector("#root > div > div > div > form > div > button"));

		clickSignIn.click();
 
		WebElement confirmSignIn = this.driver.findElement(By.cssSelector("#root > div > div > div > h1"));

		Assertions.assertEquals(true, confirmSignIn.getText().contains("Aldi"));

	}
 
	@Test

	@Order(2)

	void testItems() throws InterruptedException {

		this.driver.get("http://localhost:" + this.port);
		
		WebElement navBasket = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(3) > a"));
		navBasket.click();
 
		WebElement clickCreateBasket = this.driver.findElement(By.cssSelector("#name"));
		clickCreateBasket.click();
		
		WebElement typeBasketName = this.driver.findElement(By.cssSelector("#name"));
		typeBasketName.sendKeys("Patryk");
		
		WebElement navAddItems = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(4) > a"));
		navAddItems.click();
 
		WebElement clickName = this.driver.findElement(By.cssSelector("#name"));
		clickName.click();
 
		WebElement typeName = this.driver.findElement(By.cssSelector("#name"));
		typeName.sendKeys("Beans");
 
		WebElement clickPrice = this.driver.findElement(By.cssSelector("#price"));
		clickPrice.click();
 
		WebElement typePrice = this.driver.findElement(By.cssSelector("#price"));
		typePrice.sendKeys("1.89");
 
		WebElement typeImage = this.driver.findElement(By.cssSelector("#image"));
		typeImage.sendKeys("https://assets.iceland.co.uk/i/iceland/heinz_baked_beans_415g_9104_T596.jpg?$pdpzoom$");
		
		WebElement ClickSubmit = this.driver.findElement(By.cssSelector("#SubmitCreateItem"));
		ClickSubmit.click();
 		
		WebElement confirmItem = this.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]"));
		Assertions.assertEquals(true, confirmItem.getText().contains("Beans"));
		
		WebElement clickSearchItem = this.driver.findElement(By.cssSelector("#root > div > div > div > input"));
		clickSearchItem.click();
		
		WebElement typeSearchItem = this.driver.findElement(By.cssSelector("#root > div > div > div > input"));
		typeSearchItem.sendKeys("Beans");
		
		WebElement confirmItemSearch = this.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div"));
		Assertions.assertEquals(true, confirmItemSearch.getText().contains("Beans"));
		
		WebElement clickItemEdit = this.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/button[3]"));
		clickItemEdit.click();
		
		WebElement clickEditItemName = this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/input[1]"));
		clickEditItemName.click();
		
		WebElement editItemName = this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/input[1]"));
		editItemName.sendKeys(" 4pack");
		
		WebElement clickEditItemImage = this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/input[3]"));
		clickEditItemImage.click();
		
		WebElement editItemSubmit = this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/button"));
		editItemSubmit.click();
		
		WebElement navItems = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(2) > a"));
		navItems.click();
		
		
		WebElement navHome = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(1) > a"));
		navHome.click();
		
		WebElement navItems2 = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(2) > a"));
		navItems2.click();

		WebElement confirmItemEdit = this.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]"));
		Assertions.assertEquals(true, confirmItemEdit.getText().contains("4pack"));
		
		WebElement itemDelete = this.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/button[2]"));
		itemDelete.click();
		
		Thread.sleep(1000);
		
		WebElement navHome2 = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(1) > a"));
		navHome2.click();
		
		WebElement navItems3 = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(2) > a"));
		navItems3.click();
		
		WebElement addItemToBasket = this.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/button[1]"));
		addItemToBasket.click();
		
		WebElement navBasket2 = this.driver.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(3) > a"));
		navBasket2.click();
		
		WebElement confirmBasketItems = this.driver.findElement(By.cssSelector("#root > div > div > div > div.card-group.flex-container.text-center > div > div > div:nth-child(2)"));
		Assertions.assertEquals(true, confirmBasketItems.getText().contains("Beans"));

		
	}
 
}
