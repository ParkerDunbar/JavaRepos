package dunbar.parker.lab;

public interface DatabaseStorable {
	String serialize();
	void deserialize(String data);
	int serializedSize();
}