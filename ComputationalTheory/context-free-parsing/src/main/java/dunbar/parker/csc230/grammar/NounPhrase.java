package dunbar.parker.csc230.grammar;

public class NounPhrase extends Grammar {
	
	private Article article;
	private Noun noun;
	private Preposition preposition;
	private NounPhrase nounPhrase;
	
	public NounPhrase() {}
	
	public NounPhrase(Article a, Noun n) {
		this.article = a;
		this.noun = n;
	}
	
	public NounPhrase(Article a, Noun n, Preposition p, NounPhrase np) {
		this.article = a;
		this.noun = n;
		this.preposition = p;
		this.nounPhrase = np;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Noun getNoun() {
		return noun;
	}

	public void setNoun(Noun noun) {
		this.noun = noun;
	}

	public Preposition getPreposition() {
		return preposition;
	}

	public void setPreposition(Preposition preposition) {
		this.preposition = preposition;
	}

	public NounPhrase getNounPhrase() {
		return nounPhrase;
	}

	public void setNounPhrase(NounPhrase nounPhrase) {
		this.nounPhrase = nounPhrase;
	}

	@Override
	public String toString() {
		return "NounPhrase";
	}
}
