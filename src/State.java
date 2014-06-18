
import java.util.ArrayList;
import java.util.Map;

public class State {
    ArrayList<State> actions;
    String name,aname; // State name, Action name
    Double reward; // Reward with that state
    Map<State, Double> transitions;

  
    public String getAname()
    {
        return name;
    }
    public void setAname(String aname)
    {
        this.aname = aname;
    }
    public Map<State, Double> getTransitions()
    {
        return transitions;
    }
    public void setTransitions(Map<State, Double> transitions)
    {
        this.transitions = transitions;
    }
    
    
    public State(String name, Map<State, Double> transitions)
    {
        super();
        this.name = name;
        this.transitions = transitions;
    }

    public State(String name, Double reward, ArrayList<State> actions)
    {
        super();
        this.name = name;
        this.reward = reward;
        this.actions = actions;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Double getReward()
    {
        return reward;
    }
    public void setReward(Double reward)
    {
        this.reward = reward;
    }
    public ArrayList<State> getActions()
    {
        return actions;
    }
    public void setActions(ArrayList<State> actions)
    {
        this.actions = actions;
    }
}