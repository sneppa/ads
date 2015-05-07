package uebung04;

import static gdi.MakeItSimple.*;

public class ShellSort {
	
	static final int LENGTH = 4096;
	static final int RUNS = 1;
	static int comparisons = 0;
	static int writes = 0;
	static int executions = 0;
	static boolean protocol = false;
	    
	public static void main(String[] args) {

		int[] array = {99,6,3,8,5,12,23,62,7,8,0,1,6,4,6,1,2,0,0};
                
                
		printArray(array, "Sortiert", -1);
                
		//printProtocol(array);
		calculateEffort(array);
                
//		printArray(array, "Sortiert", -1);
	}
	
	
	/**
	 * Prints the sorting protocol for the given array.
	 * @param array Array which has to be protocolled.
	 */
	public static void printProtocol(int[] array) {
		
		protocol = true;
		shellSort(array);
		protocol = false;
	}
	
	
	/**
	 * Calculates the amount of comparisons and swaps that is needed to shellsort an array of LENGTH on average.
	 */
	public static void calculateEffort(int[] array) {
		
//		int[] values = new int[LENGTH];
//        
//		for (int i = 1; i <= RUNS; i++) {
//            for (int k = 0; k < LENGTH; k++) {
//            	values[k] = (int) Math.floor(Math.random()*LENGTH);
//            }
            shellSort(array);
//        }
		
        println("Durchschnittliche Anzahl der Vergleiche: " + comparisons/RUNS + " - Anzahl der Arrayzugriffe: " + writes/RUNS + " - Anzahl der Ausführungen: " + executions/RUNS);
	}
	
	/**
	 * Uses the shellSort algorithm to sort given array. ShellSort does basically InsertionSort but with first with runs of larger distances while
	 * the distance decreases every time.
	 * @param array The array which has to be sorted.
	 */
	static void shellSort (int[] array) { 
	 
	    int[] rows = {9,7,4,1};
            executions++;
	 
	    //First sort all values with rows[k] distance then k-1, etc...
	    for (int k = 0; k < rows.length; k++) { 
	        int distance = rows[k];
	        //o = offset. Example: at distance = 9 first run will be array[0], array[9], array[18]... second: array[1], array[10], array[19]...

                for (int i = distance; i < array.length; i += distance) 
                {
                    int savedIndex = i;
                    int savedValue = array[i];
                    
//                    println(i + " - " + distance + " - " + savedIndex);

                    // while i > 0 and the number at the position behind the current index is bigger than the current number
                    while (savedIndex > distance-1 && array[savedIndex - distance] > savedValue) 
                    {
                        comparisons++;
                        array[savedIndex] = array[savedIndex - distance]; // Swap the numbers
                        writes++;
        //                printArray("Getauscht", savedIndex-1);
                        savedIndex-=distance;	
                    }

                    // Swap the savedValue to the right position
                    array[savedIndex] = savedValue;
                    writes++;
                    
                    printArray(array, "Swap\t", -1);
                }
                    printArray(array, k+". Durchlauf", -1);
            }
	}
    /**
     * Prints an array as a line
     * 
     * @param LineName  Name of Line
     * @param change    -1: no Change
     *                  0 - Array length: Prints an arrow after this index
     * 
     */
    public static void printArray(int[] numbers, String LineName, int change)
    {
        print(LineName+":\t");
        for (int i = 0; i < numbers.length; i++)
        {
            print(numbers[i]);
            if (i == change)
                print("  <> ");
            print("\t");
        }
        println("");
    }
}
