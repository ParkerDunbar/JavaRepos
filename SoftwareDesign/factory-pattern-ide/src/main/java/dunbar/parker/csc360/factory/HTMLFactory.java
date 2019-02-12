package dunbar.parker.csc360.factory;

public class HTMLFactory extends ComponentFactory {

	@Override
	public Component chooseLanguage(ComponentEnum componentType) {
		Component c;
		
		switch (componentType) {
		case Button:
			c = new HTMLButton();
			break;
		case Label:
			c = new HTMLLabel();
			break;
		case TextField:
			c = new HTMLTextField();
			break;
		case H1:
			c = new HTMLH1Tag();
			break;
		default:
			throw new IllegalArgumentException("invalid component type");
		}
		
		c.setLang(LanguageEnum.HTML);
		return c;
	}

}