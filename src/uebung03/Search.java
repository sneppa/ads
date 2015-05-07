package uebung03;
import static gdi.MakeItSimple.*;

public class Search 
{
    /**
     * Main method for searching a number from 1-10
     * @param args 
     */
    public static void main(String args[])
    {
        int[] values = new int[10];
        
        for (int i = 0; i < values.length; i++)
        {
            values[i] = i+1;
        }
        
        print("Bitte Zahl zum Suchen (zwischen 1-10) eingeben: ");
        int search = readInt();
        
        println("Lineare Suche (Letztes Vorkommen): " + linearLast(values, search));
        println("Lineare Suche (Erstes Vorkommen): " + linearFirst(values, search));
        
        
        println("Binäre Suche (Iterativ): " + binaryIterative(values, search));
        println("Binäre Suche (Rekursive): " + binaryRecursive(values, search));
    }
    
    /**
     * Searching for the last existence of param search with the linear search.
     * 
     * @param values array with numbers
     * @param search number you are searching for
     * @return array index of the found number; if not found: -1
     */
    public static int linearLast(int[] values, int search)
    {
        int found = -1;
        
        // From 0 - array end
        for (int i = 0; i < values.length; i++)
        {
            // if found safe index in var found
            if (values[i] == search)
                found = i;
        }
        
        // return last index safed in var found
        return found;
    }
    
    
    /**
     * Searching for the first existence of param search with the linear search.
     * 
     * @param values array with numbers
     * @param search number you are searching for
     * @return array index of the found number; if not found: -1
     */
    public static int linearFirst(int[] values, int search)
    {
        int i = 0;
        
        // From 0 - array end
        while (i < values.length)
        {
            // if found -> return array index
            if (values[i] == search)
                return i;
            i++;
        }
        
        // if not found -> return -1
        return -1;
    }
    
    /**
     * Searching for the existence of param search with the binary search iterative.
     * 
     * @param values sorted array with numbers
     * @param search number you are searching for
     * @return array index of the found number; if not found: -1
     */
    public static int binaryIterative(int[] values, int search)
    {
        int start = 1;
        int end = values.length-1;
        
        // While there are array possible elements
        while (start <= end)
        {
            // Center between start and end
            int center = (start+end)/2;
            
            if (values[center] == search)
            {
                // search was found in values -> return index
                return center;
            }
            else if (search < values[center])
            {
                // smaller then current value -> use next time the left value set
                end = center-1;
            }
            else
            {
                // bigger then current value -> use next time the right value set
                start = center+1;
            }
        }
        
        // Not found
        return -1;
    }
    
    /**
     * Searching for the existence of param search with the binary search recursive.
     * 
     * @param values sorted array with numbers
     * @param search number you are searching for
     * @return array index of the found number; if not found: -1
     */
    public static int binaryRecursive(int[] values, int search)
    {
        // Call the recursive function with all parameters
        return br(values, search, 1, values.length-1);
    }
    
    /**
     * Should not called  standalone, will be called by binaryRecursive()
     */
    public static int br(int[] values, int search, int start, int end)
    {        
        // Get the center index
        int center = start+((end-start)/2);
        
        if (start == end)
        {
            // Array has only one value left
            return start;
        }
        else if (search < values[center])
        {
            // smaller then current value -> use next time the left value set
            return br(values, search, start, center);
        }
        else if (search > values[center])
        {
            // bigger then current value -> use next time the right value set
            return br(values, search, center+1, end);
        }
        
        return center;
    }
}
