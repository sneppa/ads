package uebung04;
import static gdi.MakeItSimple.*;

/**
 * QuickSort3 implements the third variant of the QuickSort algorithm presented in the lecture and counts the amount of comparisons between elements of the array and the amount of swap operations.
 * @author Mike Hukiewitz & Martin Weber
 *
 */
public class QuickSort3 extends MergeSort {

    static final int LENGTH = 10;
    static final int RUNS = 100;
    static int comparisons = 0;
    static int swaps = 0;
    static int executions = 0;
    static boolean protocol = false;
    
	public static void main(String[] args) {
		
		int[] array = {2, 17, 23, 13, 18, 3, 19, 11, 14, 16, 8};
		printProtocol(array);
		
		calculateEffort();
	}
	
	
	/**
	 * Prints the sorting protocol for the given array.
	 * @param array Array which has to be protocolled.
	 */
	public static void printProtocol(int[] array) {
		
		String output = "";
		for(int i = 0; i < array.length; i++) {
			output = output + array[i] + " ";
		}
		
		println(output);
		
		protocol = true;
		quickSort(array,0,array.length - 1);
		protocol = false;
	}
	
	
	/**
	 * Calculates the amount of comparisons and swaps that is needed to quicksort an array of LENGTH on average.
	 */
	public static void calculateEffort() {
		
		int[] values = new int[LENGTH];
        
		for (int i = 1; i <= RUNS; i++) {
            for (int k = 0; k < LENGTH; k++) {
            	values[k] = (int) Math.floor(Math.random()*LENGTH);
            }
            quickSort(values,0,LENGTH-1);
        }
		
        println("Durchschnittliche Anzahl der Vergleiche: " + comparisons/RUNS + " - Anzahl der Vertauschungen: " + swaps/RUNS + " - Anzahl der Ausführungen: " + executions/RUNS);
	}
	
	
	/**
	 * Implementation of the QuickSort algorithm, can sort parts of an array or the entirety of it.
	 * @param array The array which has to be sorted.
	 * @param bottom Starting index of the run.
	 * @param top Last index of the run.
	 */
	public static void quickSort(int[] array, int bottom, int top) {
		
		//Runs of shellSort
        executions++;
		
		if(bottom < top) {
			int i = split(array, bottom, top);
			
			if(protocol) {
				String output = "";
				for(int k = 0; k < array.length; k++) {
					if(k == i)
						output = output + "[" + array[k] + "] ";
					else
						output = output + array[k] + " ";
				}
				println(output);
			}
			
			quickSort(array, bottom, i-1);
			quickSort(array, i+1, top);
		}
	}
	
	
	/**
	 * Takes a pivot element and puts it into the right place, thus dividing the array into the left side of the pivot element and the right side of the element.
	 * Every element <= pivot is on the left side, every element > pivot is on the right side.
	 * @param array The array which has to be accessed.
	 * @param bottom Starting index of the run.
	 * @param top Last index of the run.
	 * @return Index of the pivot element.
	 */
	public static int split(int[] array, int bottom, int top) {
		
		int index = bottom;
		int pivot = top;
		
		for(int m = bottom; m < top; m++) {
			if(array[m] <= array[pivot]) {
				swap(array, m, index);	//swap the current element smaller than pivot with index and increment index afterwards
				index++;
			}
			comparisons++;
		}
		
		
		swap(array, index, pivot);
		
		return index;
	}
	
	
	/**
	 * Swaps two elements in an array.
	 * @param array The array which has to be accessed. 
	 * @param a Index of the first element.
	 * @param b Index of the second element.
	 */
	public static void swap(int[] array, int a, int b) {
		
		int m = array[a];
		array[a] = array[b];
		array[b] = m;
		swaps++;
	}

}
