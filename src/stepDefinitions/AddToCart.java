package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCart {
	WebDriver driver; 
	
	@Given("^launch url$")
	public void launchUrl() {
		System.setProperty("webdriver.edge.driver", "E:\\Download\\Tools\\TEST\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}
	@When("^login home page$")
	public void login() {
		driver.findElement(By.name("email")).sendKeys("mantran.10012000@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	}
	@When("^search any item anf add it to cart$")
	public void addToCart() {
		driver.findElement(By.name("search")).sendKeys("iMac"+Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]")).click();
	}
	@When("^checkout with information$")
	public void checkout(DataTable table) throws Exception{
		List<List<String>> data = table.raw();
		Thread.sleep(1000);
//		driver.findElement(By.id("cart")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label")).click();
		driver.findElement(By.name("firstname")).sendKeys(data.get(1).get(0));
		driver.findElement(By.name("lastname")).sendKeys(data.get(1).get(1));
		driver.findElement(By.name("company")).sendKeys(data.get(1).get(2));
		driver.findElement(By.name("address_1")).sendKeys(data.get(1).get(3));
		driver.findElement(By.name("address_2")).sendKeys(data.get(1).get(4));
		driver.findElement(By.name("city")).sendKeys(data.get(1).get(5));
		driver.findElement(By.name("postcode")).sendKeys(data.get(1).get(6));
		Select country = new Select(driver.findElement(By.name("country_id")));
		country.selectByVisibleText(data.get(1).get(7));
		Select region = new Select(driver.findElement(By.name("zone_id")));
		region.selectByVisibleText(data.get(1).get(8));
		Thread.sleep(1000);
		driver.findElement(By.id("button-payment-address")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("button-confirm")).click();
		
	}
	@Then("^verify add successful$")
	public void verify() throws Exception{
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText());
		
	}
	@Then("^verify checkout successful$")
	public void verifyCheckout() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
		
	}
}
