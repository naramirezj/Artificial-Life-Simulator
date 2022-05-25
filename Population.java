import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Population {
	private int numCooperators;
	private int numDefectors;
	private int numPartialCoop;
	private ArrayList<Organism> population;
	private Map<String, Integer> allOrganisms;
	private int finalCooperators;
	private int finalDefectors;
	private int finalPartialCoop;
	

	/**
	 * Constructor. It will get a map with counts for the three different types of organisms in the populations.
	 * It will generate the population in an ArrayList with the specified number of organisms.
	 * @throws IllegalArgumentException if there is another organism in the mapping that does not conform to the main three types.
	 */
	public Population(Map<String, Integer> counts) throws IllegalArgumentException{
			numCooperators = counts.get("Cooperator");
			counts.remove("Cooperator");
			numDefectors = counts.get("Defector");
			counts.remove("Defector");
			numPartialCoop = counts.get("PartialCooperator");
			counts.remove("PartialCooperator");
			population = new ArrayList<Organism>();

			if(!counts.isEmpty()) {
				throw new IllegalArgumentException("No such organism");
			}
			
			for(int index = 0; index < numCooperators; index++) {
				population.add(new Cooperator());
			}
			for(int index = 0; index < numDefectors; index++) {
				population.add(new Defector());
			}
			for(int index = 0; index < numPartialCoop; index++) {
				population.add(new PartialCooperator());
			}
			
	}
	
	/**
	 * Will update every organism in the ArrayList. Calls the update method, checks if the
	 * organism can cooperate and if it can reproduce.
	 */
	public void update() {
		for (Organism organism : population) {
			organism.update(); //call update
			if (organism.cooperate()) {
				organism.decrementEnergy(); //decrease energy by 1
				for (int i = 0; i < 8; i++) {
					Random num = new Random();
					int randomOrg = num.nextInt(population.size());
					population.get(randomOrg).incrementEnergy(); //increment energy of 8 random organisms
				}
			}
			if (organism.getEnergy() == 10) { //if they have 10 points they can reproduce
				Organism newOrg = organism.reproduce();
				Random num = new Random();
				int randomOrg = num.nextInt(population.size());
				population.set(randomOrg, newOrg);
			}
		}

	}
	
	/**
	 * Calculates the mean cooperation probability of all the organisms in 
	 * the population—the average of the cooperation probabilities of all the organisms in the population.
	 * @return double mean
	 */
	public double calculateCooperationMean() {
		double sum = 0;
		double mean = 0;
		
		for(int i = 0; i < population.size(); i++) {
			sum += population.get(i).getCooperationProbability();
		}
		mean = (sum/population.size())*100;
		return mean;
	}
	
	/**
	 * Returns the counts of all the organisms in the population as a hash map.
	 * @return  Map<String, Integer> allOrganisms
	 */
	public Map<String, Integer> getPopulationCounts(){
		finalCooperators = 0;
		finalDefectors = 0;
		finalPartialCoop = 0;
		for(int i = 0; i < population.size(); i++) {
			if(population.get(i).getType().equals("Cooperator")) {
				finalCooperators++;
			}
			else if(population.get(i).getType().equals("Defector")){
				finalDefectors++;
			}
			else if(population.get(i).getType().equals("PartialCooperator")) {
				finalPartialCoop++;
			}
		}
		allOrganisms = new HashMap<>();
		allOrganisms.put("Cooperator", finalCooperators);
		allOrganisms.put("Defector", finalDefectors);
		allOrganisms.put("PartialCooperator", finalPartialCoop);
		return allOrganisms;
		
	}
}
