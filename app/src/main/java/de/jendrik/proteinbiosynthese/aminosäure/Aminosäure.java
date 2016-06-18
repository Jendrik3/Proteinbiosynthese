package de.jendrik.proteinbiosynthese.aminosäure;

public abstract class Aminosäure {

	public String name() {
		return getClass().getSimpleName();
	}

	public abstract String abk();

	@Override
	public String toString() {
		return abk();
	}
}
