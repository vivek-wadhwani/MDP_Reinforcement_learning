/**
 * @author Vivek
 *
 */
import java.util.ArrayList;

public class MdpReinforcement {

	static InputFile read;
	static Bellman bellman;

	public static void main(String[] args) {

		//String pkgPath = System.getProperty("user.dir") + "\\src";

		if (args.length == 4) {

			try {

				Integer numberOfStates = Integer.valueOf(args[0]);
				Integer numberOfActions = Integer.valueOf(args[1]);
				Double discountFactor = Double.valueOf(args[3]);
				String inputfile = args[2].toString();
				bellman = new Bellman(discountFactor);
				read = new InputFile(numberOfActions, numberOfStates, inputfile);
				read.extractData(bellman);
				bellman.mdp();
				
				ArrayList <State> states = bellman.getStates();
				ArrayList<Solution> results = bellman.getResults();
				
				int i = 0;
				for (Solution result : results)
			        {
					i++;
					System.out.println("After Iteration " + i + ":: ");
					for (State state : states)
			                {
					  System.out.print(String.format(" (%s %s %.4f)", state.getName(), result.getBestAction().get(state.getName()), result.getBestValue()
									.get(state.getName())));
						}
						System.out.println("");
					}
				
			} 
			catch (Exception e) {
				System.out.println("Error!");
				e.printStackTrace();
				System.exit(1);
			}

			
		} else {

			System.out.println("Usage Error: #ofStates #ofActions InputFile DiscountFactor");
			System.exit(1);

		}
	}
}