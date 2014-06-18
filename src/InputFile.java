import java.io.*;
import java.util.*;

public class InputFile {
    Integer numberOfStates;
    Integer numberOfActions;
    String inputFileName;
    
    public Integer getNumberOfStates() {
		return numberOfStates;
	}

	public void setNumberOfStates(Integer numberOfStates) {
		this.numberOfStates = numberOfStates;
	}

	public Integer getNumberOfActions() {
		return numberOfActions;
	}

	public void setNumberOfActions(Integer numberOfActions) {
		this.numberOfActions = numberOfActions;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	    

    public InputFile(Integer numberOfActions, Integer numberOfStates,
			String inputFileName) {
    	super();
		this.inputFileName = inputFileName;
		this.numberOfActions = numberOfActions;
		this.numberOfStates = numberOfStates;
	}

   public void extractData(Bellman mdp) throws IOException,FileNotFoundException,NumberFormatException
    {
       Scanner scanner = new Scanner(new File(inputFileName));
       ArrayList<State> states = new ArrayList<State>();
       Map<String, Integer> mapOfState = new HashMap<String, Integer>();
       
       
       while(scanner.hasNext()){
       String eachLine = scanner.nextLine();
       Scanner scr = new Scanner(eachLine).useDelimiter("[()\\p{Blank}]+");
       String state = scr.next();
       Double reward = scr.nextDouble();
       State currentState = null;
       if(mapOfState.get(state)==null)
       {
        states.add(new State(state, reward, new ArrayList<State>()));
        mapOfState.put(state, new Integer(states.size()-1));
        currentState = states.get(states.size()-1);
       }
       else
            {
                currentState = states.get(mapOfState.get(state).intValue());
                currentState.setReward(reward);
            }
       while(scr.hasNext()){
        State curr = null;
        String action = scr.next();
        for(State a : currentState.getActions())
        {
            if(a.getName().equals(action))
            {
                curr = a;
                break;
            }
         }
         if(curr == null)
         {
            curr = new State(action, new HashMap<State, Double>());
            currentState.getActions().add(curr);
         }
            State next = null;
            String stateName = scr.next();
            for(State s: states)
            {
                if(s.getName().equals(stateName))
                {
                    next = s;
                    break;
                }
            }
            if(next == null)
            {
                next = new State(stateName, new Double(0.0), new ArrayList<State>());
                states.add(next);
                mapOfState.put(next.getName(), new Integer(states.size()-1));
            }
            Double transitionProbability = scr.nextDouble();
            curr.getTransitions().put(next, transitionProbability);
       }
       scr.close();
       }
    scanner.close();
    
    mdp.setStates(states);
	
    }
  

}