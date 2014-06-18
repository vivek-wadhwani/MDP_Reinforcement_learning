import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Bellman {
	Double discountFactor;

	ArrayList<Solution> results;

	ArrayList<State> states;

	public Double getDiscountFactor() {
		return discountFactor;
	}

	public void setDiscountFactor(Double discountFactor) {
		this.discountFactor = discountFactor;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public ArrayList<Solution> getResults() {
		return results;
	}

	public void setResults(ArrayList<Solution> results) {
		this.results = results;
	}

	public Bellman(Double discountFactor) {
		this.discountFactor = discountFactor;

	}

	public void mdp() {
		results = new ArrayList<Solution>();
		try {
			Collections.sort(states, new Comparator<State>() {

				public int compare(State a, State b) {
					int x = Integer.parseInt(a.getName().substring(1)), y = Integer
							.parseInt(b.getName().substring(1));
					return x - y;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		for (int i = 0; i < 20; i++) {
			
			Solution result = new Solution();
			Solution r = results.size() > 0 ? results.get(results.size() - 1)
					: null;
			results.add(result);
			for (State s : states) {
				Map<String, Double> rwd = result.getRewards().get(s.getName());
				{
					rwd = new HashMap<String, Double>();
					result.getRewards().put(s.getName(), rwd);
				}
				String bestAction = "";
				double bestValue = Double.NEGATIVE_INFINITY;
				for (State a : s.getActions()) {
					double value = 0;
					if (r != null) {
						for (Map.Entry<State, Double> sd : a.getTransitions()
								.entrySet()) {
							value += r.getBestValue()
									.get(sd.getKey().getName()) * sd.getValue();
						}
						value = value *getDiscountFactor();
					}
					value += s.getReward().doubleValue();
					if (value > bestValue) {
						bestAction = a.getName();
						bestValue = value;
					}
					rwd.put(a.getName(), new Double(value));
				}
				result.getBestValue().put(s.getName(), bestValue);
				result.getBestAction().put(s.getName(), bestAction);
			}
		}
	}

}