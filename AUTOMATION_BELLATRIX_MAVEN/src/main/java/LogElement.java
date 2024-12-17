import org.openqa.selenium.By;

public class LogElement extends ElementDecorator{
	
	public LogElement(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public By getBy() {
		return element.getBy();
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		System.out.println(String.format("Element text = %s", element.getText()));
		return element.getText();
	}

	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		System.out.println(String.format("Element Enabled = %b", element.isEnable()));
		return element.isEnable();
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		System.out.println(String.format("Element Enabled = %b", element.isDisplayed()));
		return element.isDisplayed();
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Set text = %s",  text));
		element.setText(text);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("Element clicked");
		element.click();
	}

	@Override
	public String getAttribute(String attributeName) {
		// TODO Auto-generated method stub
		System.out.print("Element attribute: " + attributeName);
		return element.getAttribute(attributeName);
	}

}
