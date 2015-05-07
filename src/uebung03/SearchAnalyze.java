package uebung03;
import static gdi.MakeItSimple.*;

public class SearchAnalyze 
{
    static final int LAENGE = 1024;
    static final int RUNS = 1;
    static int comparisonsRecursive = 0;
	
    /**
     * Main method for testing
     * @param args 
     */
    public static void main(String args[])
    {
        int[] values = new int[LAENGE];
        
        for (int i = 0; i < LAENGE; i++)
        {
            values[i] = i*3;
        }
        
        int linearLastCount = 0;
        int linearFirstCount = 0;
        int binaryIterativeCount = 0;
        int binaryRecursiveCount = 0;
        
        for (int i = 1; i <= RUNS; i++)
        {
            int random = (int) Math.floor(Math.random()*LAENGE+1025);
            
            linearLastCount += linearLast(values, random);

            linearFirstCount += linearFirst(values, random);

            binaryIterativeCount += binaryIterative(values, random);
            binaryRecursiveCount += binaryRecursive(values, random);
        }
        
        println("Lineare Suche (Letztes Vorkommen): " + linearLastCount/RUNS);
        println("Lineare Suche (Erstes Vorkommen): " + linearFirstCount/RUNS);
        println("Binäre Suche (Iterativ): " + binaryIterativeCount/RUNS);
        println("Binäre Suche (Rekursive): " + binaryRecursiveCount/RUNS);
    }
    
    /**
     * Searching for the last existence of param search with the linear search.
     * 
     * @param values array with numbers
     * @param search number you are searching for
     * @return int Number of comparisons
     */
    public static int linearLast(int[] values, int search)
    {
        int found = -1;
        int comparisons = 0;
        
        // From 0 - array end
        for (int i = 0; i < values.length; i++)
        {
            // if found safe index in var found
            if (values[i] == search)
                found = i;
            comparisons++;
        }
        
        return comparisons;
    }
    
    /**
     * Searching for the first existence of param search with the linear search.
     * 
     * @param values array with numbers
     * @param search number you are searching for
     * @return int Number of comparisons
     */
    public static int linearFirst(int[] values, int search)
    {
        int i = 0;
        int comparisons = 0;
        
        // From 0 - array end
        while (i < values.length)
        {
            comparisons++;
            // if found -> return number of comparisons
            if (values[i] == search)
                return comparisons;
            i++;
        }
        return comparisons;
    }
    
    /**
     * Searching for the existence of param search with the binary search iterative.
     * 
     * @param values sorted array with numbers
     * @param search number you are searching for
     * @return int Number of comparisons
     */
    public static int binaryIterative(int[] values, int search)
    {
        int start = 1;
        int end = values.length-1;
        int comparisons = 0;
        
        // While there are array possible elements
        while (start <= end)
        {
            // Center between start and end
            int center = (start+end)/2;
            
            if (values[center] == search)
            {
                comparisons++;
                // search was found in values -> return comparisons
                return comparisons;
            }
            else if (search < values[center])
            {
                // smaller then current value -> use next time the left value set
                end = center-1;
            	comparisons += 2;
            }
            else
            {
                // bigger then current value -> use next time the right value set
                start = center+1;
            	comparisons += 2;
            }
        }
        
        // Not found
        return comparisons;
    }
    
    
    /**
     * Searching for the existence of param search with the binary search recursive.
     * 
     * @param values sorted array with numbers
     * @param search number you are searching for
     * @return int Number of comparisons
     */
    public static int binaryRecursive(int[] values, int search)
    {
        comparisonsRecursive = 0;
        
        // Call the recursive function with all parameters
        return br(values, search, 1, values.length-1);
    }
    
    /**
     * Should not called  standalone, will be called by binaryRecursive()
     */
    public static int br(int[] values, int search, int start, int end)
    {           
        // If there are array possible elements
        if (start <= end)
        {
            int center = (start+end)/2;
            
            if (values[center] == search)
            {
                comparisonsRecursive++;
                // search was found in values
                return comparisonsRecursive;
            }
            else if (search < values[center])
            {
                comparisonsRecursive += 2;
                // smaller then current value -> use next time the left value set
                return br(values, search, start, center-1);
            }
            else
            {
                comparisonsRecursive += 2;
                // bigger then current value -> use next time the right value set
                return br(values, search, center+1, end);
            }
        }
        else
        {
            // Not found
            return comparisonsRecursive;
        }
    }
}

