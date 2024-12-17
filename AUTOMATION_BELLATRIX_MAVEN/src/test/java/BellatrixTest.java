import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

public class BellatrixTest {
	private Driver driver;
	private static Stopwatch stopwatch;
	private String usernameString = "dat.le";
	private String password = "#Onimusha00";


	private void login(String username, String password) {

		driver.findElement(By.id("username")).setText(username);
		driver.findElement(By.id("password")).setText(password);
		driver.findElement(By.name("login")).click();
	}

	private void increaseProductQuantity(String quantity) {
		driver.findElement(By.cssSelector("input.input-text.qty.text")).setText(quantity);
		driver.findElement(By.cssSelector("button[value='Update cart']")).click();
	}

	private void addRocketToShoppingCart() {
		driver.findElement(By.xpath("//a[contains(@aria-label,'Falcon 9')]")).click();
		driver.findElement(By.xpath("//a[@title='View cart']")).click();
	}

	private void applyCoupon() throws InterruptedException {
		driver.findElement(By.id("coupon_code")).setText("happybirthday");
		driver.findElement(By.name("apply_coupon")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.className("woocommerce-message")).getText(),
				"Coupon code applied successfully.");
	}

	@BeforeTest
	public void beforeMethod() {
		stopwatch = Stopwatch.createStarted();
		driver = new LoggingDriver(new WebCoreDriver());
		driver.startBrowser(Driver.Browser.CHROME);
		driver.maximize();
		System.out.println(String.format("Browser init time: %d", stopwatch.elapsed(TimeUnit.SECONDS)));
	}

	@Test
	public void TC01() throws InterruptedException {
		System.out.println(String.format("Start TC01: %d", stopwatch.elapsed(TimeUnit.SECONDS)));
		driver.goToUrl("https://demos.bellatrix.solutions/");
		addRocketToShoppingCart();
		applyCoupon();
		driver.waitForAjax();
		increaseProductQuantity("2");
	    driver.waitForAjax();
		Assert.assertEquals(driver.findElement(By.xpath("//bdi[text()='114.00']")).getText(), "114.00€");
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
		driver.waitUntilPageLoadsCompletely();
		driver.findElement(By.id("billing_first_name")).setText("dat");
		driver.findElement(By.id("billing_last_name")).setText("le");
		driver.findElement(By.id("select2-billing_country-container")).click();
		driver.findElement(By.className("select2-search__field")).setText("Vietnam");
		driver.findElement(By.xpath("//li[text()='Vietnam']")).click();
		driver.findElement(By.id("billing_address_1")).setText("421 tl864");
		driver.findElement(By.id("billing_city")).setText("Tien Giang");
		driver.findElement(By.id("billing_phone")).setText("0345864246");
		driver.findElement(By.id("billing_email")).setText("datle.testing03@gmail.com");
		driver.findElement(By.id("place_order")).click();
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Order received");
		System.out.println(String.format("End TC01: %d", stopwatch.elapsed(TimeUnit.SECONDS)));
	}

	String orderNumberString;

	@Test
	public void TC02() throws InterruptedException {
		driver.goToUrl("https://demos.bellatrix.solutions/");
		addRocketToShoppingCart();
		applyCoupon();
		driver.waitForAjax();
		increaseProductQuantity("2");
		driver.waitForAjax();
		Assert.assertEquals(driver.findElement(By.xpath("//bdi[text()='95.00']")).getText(), "95.00€");
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
		driver.waitUntilPageLoadsCompletely();
		driver.findElement(By.cssSelector("a.showlogin")).click();
		login(usernameString, password);
		driver.findElement(By.id("place_order")).click();
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Order received");
		orderNumberString = driver.findElement(By.xpath("//li[contains(@class,'order order')]/strong")).getText();
	}

	@Test
	public void TC03() {
		driver.findElement(By.xpath("//a[text()='My account']")).click();
		driver.findElement(By.xpath("//a[text()='Orders']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'#" + orderNumberString
				+ "')]/ancestor::tr//descendant::a[contains(text(),'View')]")).click();
		String expectedOrderString = String.format("Order #%s", orderNumberString);
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), expectedOrderString);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println(String.format("After test: %d", stopwatch.elapsed(TimeUnit.SECONDS)));
		
	}
}
