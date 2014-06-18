
/**
 * @author Vivek
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	Map<String, String> bestAction; 
	Map<String, Map<String, Double>> reward; 
		Map<String, Double> bestValue; 

	public Solution() {
		reward = new HashMap<String, Map<String, Double>>();
		bestAction = new HashMap<String, String>();
		bestValue = new HashMap<String, Double>();
	}

	
	public Map<String, String> getBestAction() {
		return bestAction;
	}

	public void setBestAction(Map<String, String> bestAction) {
		this.bestAction = bestAction;
	}

	public Map<String, Map<String, Double>> getRewards() {
		return reward;
	}

	public void setRewards(Map<String, Map<String, Double>> reward) {
		this.reward = reward;
	}

	public Map<String, Double> getBestValue() {
		return bestValue;
	}

	public void setBestValue(Map<String, Double> bestValue) {
		this.bestValue = bestValue;
	}

}