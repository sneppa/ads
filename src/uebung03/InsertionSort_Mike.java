package uebung03;

public class InsertionSort_Mike extends Search {

	public static void main(String[] args) {
		
		int[] values = new int[20];
		
		for(int i = 0; i < values.length; i++) {
			values[i] = (int) Math.floor(Math.random()*20);
			System.out.print(values[i] + " ");
		}
		
		insertionSort(values);
		System.out.println(" ");
		
		for(int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		
		System.out.println("\n");
		
		for(int i = 0; i < values.length; i++) {
			values[i] = (int) Math.floor(Math.random()*20);
			System.out.print(values[i] + " ");
		}
		
		binary(values);
		
		System.out.println(" ");
		
		for(int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}

	}
	
	public static int[] insertionSort(int[] input) {
		
		int j, carryover;
		
		for (int i = 1; i < input.length; i++) {
			j = i;
			carryover = input[i];
			
			//Gr��ere Elemente nach rechts verschieben
			while (j > 0 && input [j-1] > carryover) {
				input [j] = input [j-1];
				j--;
			}
			
			// Setze m auf das freie Feld
			input[j] = carryover;
		}
		
		return input;
	}
	
	public static int[] binary(int[] input) {

		int carryover, j;

		//Jede unsortierte Zahl in die sortierte Folge links von Ihr einsortieren (aufsteigend und durch bin�re Suche)
		for(int i = 1; i < input.length; i++) {
			carryover = input[i];
			
			//Nur die Suche starten wenn carryover nicht bereits das gr��te Glied der Reihe ist.
			if(input[i] < input[i-1]) {
			
				j=i/2;
				
				if(j != 0) {
					while( !(input[j-1] <= carryover && input[j] >= carryover) ) {
						if(input[j] > carryover)
							j = j/2;
						else
							j = j+(i-j)/2;
					}
				}
			}
			else {
				j = i;
			}

			//Gr��ere Elemente nach rechts verschieben
			for(int k = i; k > j; k--)
				input[k] = input [k-1];

			input[j] = carryover;
		}
		return input;
	}

}
