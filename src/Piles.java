import java.util.Arrays;

public class Piles {
	
	private int[] sizes;
	
	public Piles(int... initSizes) throws IllegalArgumentException {
		if (initSizes == null || initSizes.length <= 0) {
			throw new IllegalArgumentException();
		}
		int[] copy = new int[initSizes.length];
		for (int i = 0; i< initSizes.length; i++) {
			if (initSizes[i] <= 0) {
				throw new IllegalArgumentException();
			}
			copy[i] = initSizes[i];
		}
		sizes = copy;
	}
	
	public int[] getSizes() {
		int[] copy = Arrays.copyOf(sizes, sizes.length);
		return copy;
	}
	public void removeObjects(int[] move) throws IllegalMoveException {
		if (move == null) {
			throw new IllegalMoveException ("null move");
		}
		if (move.length != 2) {
			throw new IllegalMoveException ("Invalid length: " + move.length);
		}
		if (move[0] < 0 || move[0] > sizes.length-1) {
			throw new IllegalMoveException ("Index out of bounds: " + move[0]);
		}
		if (sizes[move[0]] == 0) {
			throw new IllegalMoveException ("Pile " + move[0] + " is empty.");
		}
		if (move[1] <= 0) {
			throw new IllegalMoveException ("Nonpositive object number: " + move[1]);
		}
		if (move[1] > sizes[move[0]]) {
			throw new IllegalMoveException ("Object number greater than pile size: " + move[1] + " > " + sizes[move[0]]);
		}
		
		sizes[move[0]] = sizes[move[0]] - move[1];
		
	}
	public boolean isEmpty() {
		int counter = 0;
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i] == 0) {
				counter++;
			}
		}
		if (counter == sizes.length) {
			return true;
		}
		else {
			return false;
		}
	}
}
