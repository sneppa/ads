package uebung04;
import static gdi.MakeItSimple.*;

/**
 * Sorts numbers in a file (numbers parted by spaces) with the MergeSort
 * @author pi
 */
public class MergeSort 
{
    public static String tempTapeFile1 = "tempTape1.txt";
    public static String tempTapeFile2 = "tempTape2.txt";

    public static void main(String[] args) 
    {
        print("Bitte zu sortierende Datei eingeben: ");
        String tape = readLine(); //readLine();
        sortNatural(tape);
    }
    
    /**
     * Sorts numbers in a file (numbers parted by spaces) with the natural MergeSort
     * @param tape file with numbers
     */
    public static void sortNatural(String tape)
    {
        if (isFilePresent(tape) && isFileReadable(tape))
        {
            boolean go = true;
            
            // while the file is not sorted
            while (go)
            {
                printruns("Tape",tape);
                
                // Split the File
                int runs = split(tape);
                //println("Runs: "+runs);

                printruns("TempTape1",tempTapeFile1);
                printruns("TempTape2",tempTapeFile2);
                
                // Merge the files
                merge(tape, runs);
                
                // If there was a run, go on
                if (runs == 1)
                    go = false;
            }
            
            printruns("Sorted Tape",tape);
        }
        else
        {
            // File not readable
            println("Datei nicht lesbar");
        }
    }

    /**
     * Splits a file in two new temp files.
     * Counts the max runs of the two files (presorted numbers are one run).
     * @param file
     * @return int: counted max runs of the two temp files (presorted numbers are one run)
     */
    public static int split(String file) 
    {
        Object tape = openInputFile(file);
        Object tempTape1 = openOutputFile(tempTapeFile1);
        Object tempTape2 = openOutputFile(tempTapeFile2);
        Object currentFile = tempTape1;
        int index = 0;
        int lastNumber = 0;
        int runs = 0;
        int indexTape1 = 1;
        int indexTape2 = 0;
        
        // Read all numbers in the file
        while (!isEndOfInputFile(tape))
        {
            int number = readInt(tape);
            
            // Not the first number and the numbers aren't sorted anymore
            if (index != 0 && lastNumber > number)
            {
                // Change the save temp file
                if (currentFile == tempTape1)
                    currentFile = tempTape2;
                else 
                    currentFile = tempTape1;
                
                runs++;
            }
            
            // Calc Spaces
            if (currentFile == tempTape1)
            {
                // Not the first number in the file temptape1 -> space
                if (indexTape1 > 1)
                    print(currentFile, " ");
                indexTape1++;
            }
            else
            {
                // Not the first number in the file temptape2 -> space
                if (indexTape2 >= 1)
                    print(currentFile, " ");
                indexTape2++;
            }
            
            // Save Number in the temp File
            print(currentFile, number);
            
            
            lastNumber = number;
            index++;
        }
        
        closeInputFile(tape);
        closeOutputFile(tempTape1);
        closeOutputFile(tempTape2);
        
        // Calc total max runs, if they are not equal, return the bigger one
        if (runs % 2 != 0)
            runs++;
        
        return runs/2+1;
    }
    
    public static void merge(String file, int runs)
    {
        Object tape = openOutputFile(file); // +".new"
        Object tempTape1 = openInputFile(tempTapeFile1);
        Object tempTape2 = openInputFile(tempTapeFile2);
        Object lastFile = tempTape1;
        
        int runsTape1, runsTape2;
        
        int numberTape1 = 0;
        int numberTape2 = 0;
        int lastNumber = 0;
        int index = 0;
        
        // All runs
        for (int i = 0; i < runs; i++)
        {
            index = 0;
            lastNumber = 0;
            
            runsTape1 = getRunLength(tempTapeFile1, i);
            runsTape2 = getRunLength(tempTapeFile2, i);
            
            // While there are elements in the tempTapes of this run
            while(runsTape1 > 0 && runsTape2 > 0)
            {
                if (index > 0)
                {
                    // Read one new Element, the last was saved in Number
                    if (lastFile == tempTape1)
                    {
                        numberTape1 = lastNumber;
                        numberTape2 = readInt(tempTape2);
                    }
                    else
                    {
                        numberTape1 = readInt(tempTape1);
                        numberTape2 = lastNumber;
                    }
                }
                else
                {
                    // Read First Elements
                    numberTape1 = readInt(tempTape1);
                    numberTape2 = readInt(tempTape2);
                }
                
                if (numberTape1 > numberTape2)
                {
                    // Number of tape1 is bigger then number of tape2
                    
                    if (index+i > 0) // if its not the first number, insert a space
                        print(tape, " ");
                    
                    print(tape, numberTape2); // Write number in merged file
                    lastNumber = numberTape1; // Save other number for the next comparison
                    lastFile = tempTape1; // Save the other file for the next comparison
                    runsTape2--; // Remove element from counter
                }
                else
                {
                    // Number of tape2 is bigger then number of tape1
                    
                    if (index+i > 0) // if its not the first number, insert a space
                        print(tape, " ");
                    
                    print(tape, numberTape1); // Write number in merged file
                    lastNumber = numberTape2; // Save other number for the next comparison
                    lastFile = tempTape2; // Save the other file for the next comparison
                    runsTape1--; // Remove element from counter
                }
                
                index++;
            }
            
            if (index > 0)
            {
                // Write the last saved Number in the file
                print(tape, " " + lastNumber);
                
                // Remove element from counter
                if (lastFile == tempTape1)
                    runsTape1--;
                else
                    runsTape2--;
            }
            
            // If there are elements in the tempTape1, write them in the merged file
            if (runsTape1 > 0)
            {
                while (runsTape1 > 0) // while there are elements
                {
                    numberTape1 = readInt(tempTape1);
                    if (index+i > 0) // if its not the first number, insert a space
                        print(tape, " ");
                    print(tape, numberTape1);
                    index++;
                    runsTape1--; // Remove element from counter
                }
            }
            // If there are elements in the tempTape2, write them in the merged file
            else if (runsTape2 > 0)
            {
                while (runsTape2 > 0) // while there are elements
                {
                    numberTape2 = readInt(tempTape2);
                    if (index+i > 0) // if its not the first number, insert a space
                        print(tape, " ");
                    print(tape, numberTape2); // Write number to merged file
                    index++;
                    runsTape2--; // Remove element from counter
                }
            }
        }
        
        closeOutputFile(tape);
        closeInputFile(tempTape1);
        closeInputFile(tempTape2);
    }
    
    /**
     * Counts number of elements of current run of a file
     * @param file Path + Filename
     * @param indexRun Index of the run to count
     * @return int Length of the current run
     */
    public static int getRunLength(String file, int indexRun)
    {
        int runslength = 0;
        int index = 0;
        int lastNumber = 0;
        int indexruns = 0;
        
        Object tape = openInputFile(file);
        
        while(!isEndOfInputFile(tape))
        {
            int number = readInt(tape);
            
            if (index != 0 && lastNumber > number)
            {
                indexruns++;
            }
            
            if (indexRun == indexruns)
                runslength++;
            
            index++;
            lastNumber = number;
        }
        
        closeInputFile(tape);
        
        return runslength;
    }
    
    /**
     * Prints an file with the runs
     * @param description Description of File
     * @param file Path to file
     */
    public static void printruns(String description, String file)
    {
        int index = 0;
        int lastNumber = 0;
        
        Object tape = openInputFile(file);
        
        print(description+":");
        
        print("[");
        
        while(!isEndOfInputFile(tape))
        {
            int number = readInt(tape);
            
            if (index != 0 && lastNumber > number)
            {
                print(" ] [");
            }
            
            print(" "+number);
            
            index++;
            lastNumber = number;
        }
        
        print(" ]");
        
        println();
        
        closeInputFile(tape);
    }
}