import org.openqa.selenium.By;

public abstract class Element {
	public abstract By getBy();

	public abstract String getText();

	public abstract boolean isEnable();

	public abstract boolean isDisplayed();

	public abstract void setText(String text) ;

	public abstract void click();
	

	public abstract String getAttribute(String attributeName);
}
