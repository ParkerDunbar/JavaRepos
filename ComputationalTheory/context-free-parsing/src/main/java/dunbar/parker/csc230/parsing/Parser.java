package dunbar.parker.csc230.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dunbar.parker.csc230.grammar.*;
import dunbar.parker.csc230.states.State;
import dunbar.parker.csc230.states.StateA;
import dunbar.parker.csc230.states.StateB;
import dunbar.parker.csc230.states.StateC;

public class Parser {
	private State state;
	private StateA stateA;
	private StateB stateB;
	private StateC stateC;
	private List<String> parsedTokens = new ArrayList<String>();
	private int currentIndex;
	private Article article = new Article();
	private Noun noun = new Noun();
	private Verb verb = new Verb();
	private Preposition preposition = new Preposition();

	public Parser() {
		this.stateA = new StateA(this);
		this.stateB = new StateB(this);
		this.stateC = new StateC(this);
	}

	public void run() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a valid sentence in Eliza's grammar.");

		while (true) {
			this.setState(stateA);
			String userInput = bf.readLine();
			userInput = userInput.toLowerCase();

			String word = "";
			parsedTokens.clear();
			for (char c : userInput.toCharArray()) {
				this.getState().change(c);

				if (this.getState().equals(stateC)) {
					parsedTokens.add(word);
					word = "";
					this.setState(stateA);
				} else {
					word += c;
				}
			}
			if (this.getState().equals(stateB)) {
				parsedTokens.add(word);
				word = "";
			}

			Stack<Object> reducedStack = shiftAndReduceStack();
			respond(reducedStack);
		}
	}

	private Stack<Object> shiftAndReduceStack() {
		Stack<Object> stack = new Stack<Object>();
		currentIndex = 0;
		for (String s : parsedTokens) {
			stack.push(s);
			if (article.articles.contains(s)) {
				stack.pop();
				stack.push(new Article(s));
			} else if (noun.nouns.contains(s)) {
				stack.pop();
				stack.push(new Noun(s));
			} else if (verb.verbs.contains(s)) {
				stack.pop();
				stack.push(new Verb(s));
			} else if (preposition.prepostions.contains(s)) {
				stack.pop();
				stack.push(new Preposition(s));
			}
			reduceStack(stack);
			reduceStack(stack);
			currentIndex++;
		}
		reduceStack(stack);
		return stack;
	}

	private void reduceStack(Stack<Object> stack) {
		Stack<Object> moving = new Stack<Object>();

		if (stack.peek() instanceof VerbPhrase) {
			moving.push(stack.pop());
			if (stack.size() != 0 && stack.peek() instanceof NounPhrase) {
				moving.push(stack.pop());
				stack.push(new Sentence((NounPhrase) moving.pop(), (VerbPhrase) moving.pop())); //
				moving.clear();
			} else {
				stack.push(moving.pop());
			}
		}

		if (checkAhead("with")) {
			if (stack.peek() instanceof Noun) {
				moving.push(stack.pop());
				if (stack.size() != 0 && stack.peek() instanceof Article) {
					moving.push(stack.pop());
					stack.push(new NounPhrase((Article) moving.pop(), (Noun) moving.pop())); //
					moving.clear();
				} else {
					stack.push(moving.pop());
				}
			}
		}

		if (stack.peek() instanceof NounPhrase) {
			moving.push(stack.pop());
			if (stack.size() != 0 && stack.peek() instanceof Preposition) {
				moving.push(stack.pop());
				if (stack.size() != 0 && stack.peek() instanceof Noun) {
					moving.push(stack.pop());
					if (stack.size() != 0 && stack.peek() instanceof Article) {
						moving.push(stack.pop());
						stack.push(new NounPhrase((Article) moving.pop(), (Noun) moving.pop(),
								(Preposition) moving.pop(), (NounPhrase) moving.pop())); //
						moving.clear();
					} else {
						stack.push(moving.pop());
						stack.push(moving.pop());
						stack.push(moving.pop());
					}
				} else {
					stack.push(moving.pop());
					stack.push(moving.pop());
				}
			} else {
				stack.push(moving.pop());
			}
		}

		if (checkAhead("a") && checkAhead("the") && checkAhead("dog") && checkAhead("cat") && checkAhead("fish")) {
			if (stack.peek() instanceof Verb) {
				moving.push(stack.pop());
				stack.push(new VerbPhrase((Verb) moving.pop()));
				moving.clear();
			}
		}

		if (stack.peek() instanceof NounPhrase) {
			moving.push(stack.pop());
			if (stack.size() != 0 && stack.peek() instanceof Verb) {
				moving.push(stack.pop());
				stack.push(new VerbPhrase((Verb) moving.pop(), (NounPhrase) moving.pop()));
				moving.clear();
			} else {
				stack.push(moving.pop());
			}
		}
	}

	private boolean checkAhead(String string) {
		if (currentIndex + 1 >= parsedTokens.size()) {
			return true;
		} else if (string.equals(parsedTokens.get(currentIndex + 1))) {
			return false;
		}
		return true;
	}

	private void respond(Stack<Object> reducedStack) {
		if (reducedStack.size() == 1) {
			Sentence sentence = (Sentence) reducedStack.pop();

			if (sentence.getNounPhrase().getPreposition() != null) {
				if (sentence.getVerbPhrase().getVerb().getString().equals("bites")) {
					System.out.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " "
							+ sentence.getNounPhrase().getPreposition().getString() + " " + "that "
							+ sentence.getNounPhrase().getNounPhrase().getNoun().getString() + " " + "bite?");
				} else {
					System.out.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " "
							+ sentence.getNounPhrase().getPreposition().getString() + " " + "that "
							+ sentence.getNounPhrase().getNounPhrase().getNoun().getString() + " " + "chase?");
				}
			}

			else if (sentence.getVerbPhrase().getNounPhrase() != null
					&& sentence.getVerbPhrase().getNounPhrase().getPreposition() != null) {
				if (sentence.getVerbPhrase().getVerb().getString().equals("bites")) {
					System.out.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " " + "bite "
							+ "that " + sentence.getVerbPhrase().getNounPhrase().getNoun().getString() + " "
							+ sentence.getVerbPhrase().getNounPhrase().getPreposition().getString() + " " + "that "
							+ sentence.getVerbPhrase().getNounPhrase().getNounPhrase().getNoun().getString() + "?");
				} else {
					System.out.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " "
							+ "chase " + "that " + sentence.getVerbPhrase().getNounPhrase().getNoun().getString() + " "
							+ sentence.getVerbPhrase().getNounPhrase().getPreposition().getString() + " " + "that "
							+ sentence.getVerbPhrase().getNounPhrase().getNounPhrase().getNoun() + "?");
				}
			}

			else if (sentence.getVerbPhrase().getNounPhrase() != null) {
				if (sentence.getVerbPhrase().getVerb().getString().equals("bites")) {
					System.out.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " " + "bite "
							+ "that " + sentence.getVerbPhrase().getNounPhrase().getNoun().getString() + "?");
				} else {
					System.out
							.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " " + "chase "
									+ "that " + sentence.getVerbPhrase().getNounPhrase().getNoun().getString() + "?");
				}
			}

			else {
				if (sentence.getVerbPhrase().getVerb().getString().equals("bites")) {
					System.out
							.println("Why does that " + sentence.getNounPhrase().getNoun().getString() + " " + "bite?");
				} else {
					System.out.println(
							"Why does that " + sentence.getNounPhrase().getNoun().getString() + " " + "chase?");
				}
			}
		} else {
			System.out.println("Not sure what you said there.");
		}

	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public StateA getStateA() {
		return stateA;
	}

	public StateB getStateB() {
		return stateB;
	}

	public StateC getStateC() {
		return stateC;
	}

}
