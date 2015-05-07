package uebung03;
import static gdi.MakeItSimple.*;

public class ShakerSort 
{
    final static int NUMBERS = 10; // Amount of Numbers in Array
    final static int RUNSTOTAL = 1; // Runs for Average (out commented code in main)
    public static int[] numbers = new int[NUMBERS];
    
    public static boolean changedLeft = true;
    public static boolean changedRight = true;
    
    public static int runs = 0;
    public static int comparisons = 0;
    public static int changes = 0;
    
    /**
     * Main method with testings
     * 
     * @param args 
     */
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

            println("");

            sort();
            changedLeft = true;
            changedRight = true;

            // Comment out if you don't want see the statistic
            println("");
            println("Durchläufe: \t"+runs);
            println("Vergleiche: \t"+comparisons);
            println("Vertauschungen:\t"+changes);
//        }
//            println("Durchläufe: \t"+(runs/RUNSTOTAL));
//            println("Vergleiche: \t"+(comparisons/RUNSTOTAL));
//            println("Vertauschungen:\t"+(changes/RUNSTOTAL));
    }
    
    /**
     * Sorts the array with ShakerSort
     */
    public static void sort()
    {
        int start = 0, end = numbers.length-1;
        
        // While the array has changed in order
        while (changedRight && changedLeft)
        {
            // Sort from left to right
            changedRight = shakeRight(start, end);
            end--;
            runs++;
            printArray(runs+". Durchlauf", -1); // comment out if you don't want see the run logs
            
            if (changedRight)
            {
                // Sort from right to left
                changedLeft = shakeLeft(start, end);
                start++;
                runs++;
                printArray(runs+". Durchlauf", -1); // comment out if you don't want see the run logs
            }
        }
    }
    
    
    /**
     * Compares an array from left to right.
     * 
     * @param start Start index of Array
     * @param end End index of Array
     * @return  true: Array order changed
     *          false: Array didn't changed
     */
    public static boolean shakeRight(int start, int end)
    {
        boolean changed = false;
        
        // Array from start to end
        for (int i = start; i < end; i++)
        {
            if (numbers[i] > numbers[i+1])
            {
                // Number bigger, then swap them
                int copy = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = copy;
                printArray("Vertauscht", i); // comment out if you don't want see the swap logs
                changed = true;
                changes++;
            }
            comparisons++;
        }
        
        return changed;
    }
    
    /**
     * Compares an array from right to left.
     * 
     * @param start Start index of Array
     * @param end End index of Array
     * @return  true: Array order changed
     *          false: Array didn't changed
     */
    public static boolean shakeLeft(int start, int end)
    {
        boolean changed = false;
        
        // Array from end to start
        for (int i = end; i >= start; i--)
        {
            if (numbers[i] > numbers[i+1])
            {
                // Number bigger, then swap them
                int copy = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = copy;
                printArray("Vertauscht", i); // comment out if you don't want see the swap logs
                changed = true;
                changes++;
            }
            comparisons++;
        }
        
        return changed;
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
