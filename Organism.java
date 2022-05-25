
public abstract class Organism {
	protected int energy;
	
	/**
	 * Constructor, sets energy to 0.
	 */
	public Organism() {
		energy = 0;
	}
	
	/**
	 * Increments energy by 1.
	 */
	public void update() {
		energy++;
	}
	
	/**
	 * Returns the current energy.
	 * @returns int energy
	 */
	public int getEnergy() {
		return energy;
	}
	
	/**
	 * Increments energy by 1.
	 */
	public void incrementEnergy() {
		energy++;
	}
	
	/**
	 * Decrements energy by 1.
	 */
	public void decrementEnergy() {
		if(energy > 0) { //Only if its larger than 0
		energy--;
		}
	}
	
	/**
	 * Returns the type of this Organism as a string.
	 * @returns String
	 */
	abstract String getType();
	
	/**
	 * Called by update when the organism can reproduce. Creates an offspring organism and returns it.
	 * @returns Organism
	 */
	abstract Organism reproduce();
	
	/**
	 * Returns the cooperation probability of this organism.
	 * @returns double
	 */
	abstract double getCooperationProbability();
	
	/**
	 * Returns whether or not the organism cooperates.
	 * @returns boolean
	 */
	abstract boolean cooperate();
	

}
