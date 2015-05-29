//--------------------------------------------------------------------
//
//  Laboratory 4                                          Sample.java
//
//  Sample program for testing some of the operations in the List ADT
//
//--------------------------------------------------------------------

import java.io.*;
  
class Sample
{
    public static void main ( String [] args ) throws IOException 
    {
        ListArray samples = new ListArray(100); // Set of samples
        int newSample,                          // Input sample
            total = 0;                          // Sum of the input samples
        
        //-----------------------------------------------------------------
        // Need to read 'tokens' (namely int values) input from the keyboard.
        //   In Java this takes instantiation of several classes.  
        //
        // Initialize reader - To read a character at a time
        BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(System.in));
        // Initialize the tokenizer -
        //   To read tokens (words and numbers separated by whitespace)
        StreamTokenizer tokens = new StreamTokenizer(reader);
        // Note: use the nextToken( ) method to step through a stream of tokens. 
        //   Use tokenizer's nval to obtain the number read.
        //   Since nval is of type double, cast it to an int.

        // Read in a set of samples from the keyboard.
        System.out.print("Enter list of samples (end with eof) : ");
        // Keep reading as long as text (the word eof) has not been entered
        while ( tokens.nextToken( ) != tokens.TT_WORD )
        {
            newSample = (int)tokens.nval;
            samples.insert(new Integer(newSample));
//            samples.showStructure();
        }

        // Sum the samples and output the result.
        if ( samples.gotoBeginning() )          // Go to beginning of list
            // Add element to running sum 
            // must cast Object to Integer, then convert Integer to int
            do
                total += ((Integer)samples.getCursor( )).intValue( );  
            while ( samples.gotoNext() );       // Go to next element (if any)

        System.out.println("Sum is " + total);
    } // main
    
} // class Sample
