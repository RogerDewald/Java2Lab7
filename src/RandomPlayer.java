import java.util.Random;

public class RandomPlayer extends Player {
	
	private Random generator;
	
	public RandomPlayer(String name) {
		super(name);
		generator = new Random();
	}
	
	public int[] getMove(int[] pileSizes) {
		int pileIndex = generator.nextInt(pileSizes.length);
	    while (pileSizes[pileIndex] == 0) {
	        pileIndex = generator.nextInt(pileSizes.length);
	    }
	    int numToRemove = generator.nextInt(pileSizes[pileIndex]) + 1;
	    return new int[]{pileIndex, numToRemove};
	}

}
