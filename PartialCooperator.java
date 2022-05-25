import java.util.Random;

public class PartialCooperator extends Organism{
private double cooperation;
	
	public PartialCooperator() {
		super();
		Random probability = new Random();
		cooperation = probability.nextInt(1);
	}
	
	/**
	 * Returns the type of this Organism as a string.
	 * @returns String
	 */
	@Override
	public String getType() {
		return "PartialCooperator";
	}
	
	/**
	 * Called by update when the organism can reproduce. Creates an offspring organism and returns it.
	 * @returns Organism
	 */
	@Override
	public Organism reproduce() {
		PartialCooperator newOrg = new PartialCooperator();
		return newOrg;
	}

	/**
	 * Returns the cooperation probability of this organism.
	 * @returns double
	 */
	@Override
	double getCooperationProbability() {
		return 0.5;
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



