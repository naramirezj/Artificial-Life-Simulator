/*
 *Assignment Name: 
 * Assignment 5: Artificial Life
 *Due Date: 
 * May 13th 2022
 *Author:
 * Natalia Ramirez Jimenez
 *Written/Online sources used: None
 *Help obtained: None
 *Academic Honesty Statement: 
 * "I confirm that the above list of 
 * sources is complete AND that I/we have not talked to anyone 
 * else (e.g., CSC 207 students) about the solution to this problem."
 */
import java.util.HashMap;
import java.text.DecimalFormat;
import java.util.Map;

public class ALifeSim {
	private static final DecimalFormat form = new DecimalFormat("0.00");
	public static void main(String[] args) {
		int iterations = Integer.parseInt(args[0]);
		int cooperators= Integer.parseInt(args[1]);
		int defectors= Integer.parseInt(args[2]);
		int partialCoops= Integer.parseInt(args[3]);
		Map<String, Integer> counts = new HashMap<String, Integer>();
		counts.put("Cooperator", cooperators);
		counts.put("Defector", defectors);
		counts.put("PartialCooperator", partialCoops);
		Population petriDish = new Population(counts);
		for(int i = 0; i < iterations; i++) {
			petriDish.update();
		}
		
		Map<String, Integer> finalOrgs = petriDish.getPopulationCounts();
		System.out.println("After " + iterations + " ticks: ");
		System.out.println("Cooperators = " + finalOrgs.get("Cooperator"));
		System.out.println("Defectors = " + finalOrgs.get("Defector"));
		System.out.println("Partial = " + finalOrgs.get("PartialCooperator") + "\n");
		System.out.println("Mean Cooperation Probability = " + form.format(petriDish.calculateCooperationMean()));
		
		
	}

}
