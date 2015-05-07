package uebung03;
import static gdi.MakeItSimple.*;

public class InsertionSort 
{
    final static int NUMBERS = 10; // Amount of Numbers in Array
    final static int RUNSTOTAL = 100; // Runs for Average (out commented code in main)
    public static int[] numbers = new int[NUMBERS];
    
    public static int runs = 0;
    public static int comparisons = 0;
    public static int changes = 0;
    
    public static void main(String args[]) 
    {
//        for (int y = 1; y <= RUNSTOTAL; y++)
//        {
            print("Ausgangsfolge: \t");
            for (int i = 0; i < numbers.length; i++)
            {
                numbers[i] = (int) Math.floor(Math.random()*100);
                print(numbers[i]+"\t");
            }

            println();

//            insertionSort();
            insertionSortBinary();

            printArray("Endfolge", -1);
        
//        }
//            println("Durchläufe: \t"+(runs/RUNSTOTAL));
//            println("Vergleiche: \t"+(comparisons/RUNSTOTAL));
//            println("Vertauschungen:\t"+(changes/RUNSTOTAL));
    }

    /**
     * Sorts the array with Insertion Sort
     */
    static void insertionSort() 
    {
        // From 1 - array end
        for (int i = 1; i < numbers.length; i++) 
        {
            int savedIndex = i;
            int savedValue = numbers[i];
            
            // while i > 0 and the number at the position behind the current index is bigger than the current number
            while (savedIndex > 0 && numbers[savedIndex - 1] > savedValue) 
            {
                comparisons++;
                numbers[savedIndex] = numbers[savedIndex - 1]; // Swap the numbers
//                printArray("Getauscht", savedIndex-1);
                savedIndex--;	
                changes++;
            }
            
            // Swap the savedValue to the right position
            numbers[savedIndex] = savedValue;
            changes++;
            runs++;
            
//            printArray(i+". Durchlauf", -1);
        }
    }

    /**
     * Sorts the array with Insertion Sort Binary
     */
    static void insertionSortBinary()
    {	
        // From 1 - array end				
        for (int i = 1; i < numbers.length; i++) 
        {	
            int savedIndex = binarySearch(numbers[i], 0, i);
            int savedValue = numbers[i];

            // swap the positions of all values between savedIndex and "i-1" as long as i>=savedIndex
            for (int n = i-1; n >= savedIndex; n--)
            {			
                changes++;
                numbers[n+1] = numbers[n]; // Swap the numbers
//                printArray("Getauscht", savedIndex-1);
            }

            numbers[savedIndex] = savedValue;
            changes++;
            runs++;
            
            printArray(i+". Durchlauf", -1);
        }
    }
	
    
    /**
     * Binary Recursive Search
     */
    public static int binarySearch(int search, int start, int end)
    {        
        // Get the center index
        int center = start+((end-start)/2);
        
        if (start == end)
        {
            // Array has only one value left
            comparisons++;
            return start;
        }
        else if (search < numbers[center])
        {
            // smaller then current value -> use next time the left value set
            comparisons+=2;
            return binarySearch(search, start, center);
        }
        else if (search > numbers[center])
        {
            // bigger then current value -> use next time the right value set
            comparisons+=2;
            return binarySearch(search, center+1, end);
        }
        
        return center;
    }
    
    
    /**
     * Prints an array as a line
     * 
     * @param LineName  Name of Line
     * @param change    -1: no Change
     *                  0 - Array length: Prints an arrow after this index
     * 
     */
    public static void printArray(String LineName, int change)
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
