import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BellatrixTest {
	private WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demos.bellatrix.solutions/");
	}
	@Test
	public void TC01() throws InterruptedException {
		//Click on 'Add to cart' button
		driver.findElement(By.xpath("//a[contains(@aria-label,'Falcon 9')]")).click();
		driver.findElement(By.xpath("//a[@title='View cart']")).click();
		driver.findElement(By.id("coupon_code")).clear();
		driver.findElement(By.id("coupon_code")).sendKeys("coupon_code");
		driver.findElement(By.name("apply_coupon")).click();
		Thread.sleep(5000);
		Assert.assertTrue(!driver.findElement(By.cssSelector("div.blockUI.blockOverlay")).isDisplayed());
		driver.findElement(By.cssSelector("input.input-text.qty.text")).clear();
		driver.findElement(By.cssSelector("input.input-text.qty.text")).sendKeys("2");
		driver.findElement(By.cssSelector("button[value='Update cart']")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//bdi[text()='45.00']")), "45.00");
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.id("billing_first_name")).clear();
		driver.findElement(By.id("billing_first_name")).sendKeys("dat");
		driver.findElement(By.id("billing_last_name")).clear();
		driver.findElement(By.id("billing_last_name")).sendKeys("le");
		driver.findElement(By.id("select2-billing_country-container")).click();
		driver.findElement(By.className("//input[@class='select2-search__field']")).clear();
		driver.findElement(By.className("//input[@class='select2-search__field']")).sendKeys("Vietnam");
		driver.findElement(By.xpath("//li[text()='Vietnam']")).click();
		driver.findElement(By.id("billing_address_1")).clear();
		driver.findElement(By.id("billing_address_1")).sendKeys("421 tl864");
		driver.findElement(By.id("billing_city")).clear();
		driver.findElement(By.id("billing_city")).sendKeys("Tien Giang");
		driver.findElement(By.id("billing_phone")).clear();
		driver.findElement(By.id("billing_phone")).sendKeys("0345864246");
		driver.findElement(By.id("billing_email")).clear();
		driver.findElement(By.id("billing_email")).sendKeys("datle.testing03@gmail.com");
		driver.findElement(By.id("place_order")).click();
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(),"Order received");
		//Fill all required information then click on 'Place order' button
		//When next page is loaded, verify the order was placed
	}

	@Test
	public void TC02() {
		System.out.println("hello");
		Assert.assertEquals("hello", null);
	}

	@Test
	public void TC03() {
		System.out.println("hello");
		Assert.assertEquals("hello", null);
	}
}
