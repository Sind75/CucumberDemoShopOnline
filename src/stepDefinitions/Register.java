package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register {
	WebDriver driver; 

	@Given("^launch register url$")
	public void launchUrl() {
		System.setProperty("webdriver.edge.driver", "E:\\Download\\Tools\\TEST\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	@When("^provide valid info to input fields$")
	public void inputDetail(DataTable table) {
		List<List<String>> data = table.raw();
		driver.findElement(By.name("firstname")).sendKeys(data.get(1).get(0));
		driver.findElement(By.name("lastname")).sendKeys(data.get(1).get(1));
		driver.findElement(By.name("email")).sendKeys(data.get(1).get(2));
		driver.findElement(By.name("telephone")).sendKeys(data.get(1).get(3));
		driver.findElement(By.name("password")).sendKeys(data.get(1).get(4));
		driver.findElement(By.name("confirm")).sendKeys(data.get(1).get(5));
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	}
	@Then("^verify account registed$")
	public void verifyRegisted() {
		System.out.println(driver.findElement(By.id("content")).isDisplayed());
		driver.quit();
	}
}
