import org.openqa.selenium.By;

public class ElementDecorator extends Element{

	protected final Element element;
	
	public ElementDecorator(Element element) {
		this.element = element;
	}

	@Override
	public By getBy() {
		// TODO Auto-generated method stub
		return element.getBy();
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return element.getText();
	}

	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return element.isEnable();
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		element.setText(text);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		element.click();
	}

	@Override
	public String getAttribute(String attributeName) {
		// TODO Auto-generated method stub
		return element.getAttribute(attributeName);
	}

}
