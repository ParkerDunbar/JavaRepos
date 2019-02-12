package dunbar.parker.csc230.grammar;

public class VerbPhrase extends Grammar {
	
	private Verb verb;
	private NounPhrase nounPhrase;
	
	public VerbPhrase() {}
	
	public VerbPhrase(Verb v) {
		this.verb = v;
	}
	
	public VerbPhrase(Verb v, NounPhrase np) {
		this.verb = v;
		this.nounPhrase = np;
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	public NounPhrase getNounPhrase() {
		return nounPhrase;
	}

	public void setNounPhrase(NounPhrase nounPhrase) {
		this.nounPhrase = nounPhrase;
	}

	@Override
	public String toString() {
		return "VerbPhrase";
	}
}
