package dunbar.parker.csc230.grammar;

public class Sentence extends Grammar {
	
	private NounPhrase nounPhrase;
	private VerbPhrase verbPhrase;
	
	public Sentence() {}
	
	public Sentence(NounPhrase np, VerbPhrase vp) {
		this.nounPhrase = np;
		this.verbPhrase = vp;
	}

	public NounPhrase getNounPhrase() {
		return nounPhrase;
	}

	public void setNounPhrase(NounPhrase nounPhrase) {
		this.nounPhrase = nounPhrase;
	}

	public VerbPhrase getVerbPhrase() {
		return verbPhrase;
	}

	public void setVerbPhrase(VerbPhrase verbPhrase) {
		this.verbPhrase = verbPhrase;
	}

	@Override
	public String toString() {
		return "Sentence";
	}
}
