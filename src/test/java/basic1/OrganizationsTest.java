package basic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrganizationsTest {
	
	@Test
	public void CreateOrganizations() throws InterruptedException
	{
WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//click on organizations
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//click on create new org +
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		//search tf enter name
		driver.findElement(By.name("accountname")).sendKeys("Jio1");
		
		//To click on radio button
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
		//To handle dropdown
		WebElement TargetedWE = driver.findElement(By.name("assigned_group_id"));

		Select s=new Select(TargetedWE);
		s.selectByVisibleText("Support Group");
		
		//To click on save button 
		driver.findElement(By.name("button")).click();
		
		//To logout mouse hover on an image
		Thread.sleep(2000);
		WebElement img= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(img);
		a.perform();
		
		//to click on signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
