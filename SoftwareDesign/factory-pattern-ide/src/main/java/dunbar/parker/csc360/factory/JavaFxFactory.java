package dunbar.parker.csc360.factory;

public class JavaFxFactory extends ComponentFactory {

	@Override
	public Component chooseLanguage(ComponentEnum componentType) {
		Component c;
		
		switch (componentType) {
		case Button:
			c = new JavaFxButton();
			break;
		case Label:
			c = new JavaFxLabel();
			break;
		default:
			throw new IllegalArgumentException("invalid component type");
		}
		
		c.setLang(LanguageEnum.JavaFX);
		return c;
	}

}
