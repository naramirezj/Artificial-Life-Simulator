
public class Cooperator extends Organism{
	
	private double cooperation;
	
	public Cooperator() {
		super();
		cooperation = 1;
	}
	
	/**
	 * Returns the type of this Organism as a string.
	 * @returns String
	 */
	@Override
	public String getType() {
		return "Cooperator";
	}

	/**
	 * Called by update when the organism can reproduce. Creates an offspring organism and returns it.
	 * @returns Organism
	 */
	@Override
	public Organism reproduce() {
		Cooperator newOrg = new Cooperator();
		return newOrg;
	}
	
	/**
	 * Returns the cooperation probability of this organism.
	 * @returns double
	 */
	@Override
	double getCooperationProbability() {
		return 1;
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
