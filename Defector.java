
public class Defector extends Organism{
private double cooperation;
	
	public Defector() {
		super();
		cooperation = 0;
	}
	
	/**
	 * Returns the type of this Organism as a string.
	 * @returns String
	 */
	@Override
	public String getType() {
		return "Defector";
	}

	/**
	 * Called by update when the organism can reproduce. Creates an offspring organism and returns it.
	 * @returns Organism
	 */
	@Override
	public Organism reproduce() {
		Defector newOrg = new Defector();
		return newOrg;
	}

	/**
	 * Returns the cooperation probability of this organism.
	 * @returns double
	 */
	@Override
	double getCooperationProbability() {
		return 0;
	}

	/**
	 * Returns whether or not the organism cooperates.
	 * @returns boolean
	 */
	@Override
	boolean cooperate() {
		if(cooperation == 1) {
		return true;
		}
		else
			return false;
	}
}
