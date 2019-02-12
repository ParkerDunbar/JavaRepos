package dunbar.parker.csc360.utilities;

public interface Command {

	void execute();
	
	void undo();
	
	Command clone();
	
}
