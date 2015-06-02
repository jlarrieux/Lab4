//--------------------------------------------------------------------
//
//  Laboratory 4, In-lab Exercise 1                     TestDNA.java
//
//  Test program for the countbases method
//
//--------------------------------------------------------------------

// Reads a DNA sequence from the keyboard, calls method countBases
// countBases (which uses a list to represent a DNA sequence), and
// outputs the number of times that each base (A, G, C and T) occurs
// in the sequence.

import java.io.IOException;

class TestDNA
{
    private static int aCount=0,  // Number of A's in the sequence
                       cCount=0,  // Number of C's in the sequence
                       tCount=0,  // Number of T's in the sequence
                       gCount=0;  // Number of G's in the sequence


    
    public static void main ( String[] args ) throws IOException 
    {
        ListArray dnaSequence
            = new ListArray(25);        // DNA sequence (25 bases max.)
        char base;                      // DNA base

        // Read the DNA sequence from the keyboard.
        System.out.println("\nEnter a DNA sequence: ");

        // read one character at a time 
        // until the carriage return or newline is read
        base = (char)System.in.read( );
        while ( base != '\r' && base != '\n' )
        {
            dnaSequence.insert(new Character(base));
            base = (char)System.in.read( );
        }

        // Display the sequence.
        System.out.print("Sequence: ");
        if ( dnaSequence.gotoBeginning() )
            do
                System.out.print(dnaSequence.getCursor( ));
                while ( dnaSequence.gotoNext() );
        System.out.println( );

        // Count the number of times that each base occurs.
        countBases(dnaSequence);

        // Output the totals.
        System.out.println("Number of A's : " + aCount);
        System.out.println("Number of C's : " + cCount);
        System.out.println("Number of T's : " + tCount);
        System.out.println("Number of G's : " + gCount);
    }

    //--------------------------------------------------------------------
    //
    //  Insert your countBases function here.
    //
    //--------------------------------------------------------------------

    static void countBases ( List dnaSequence)
        // Counts the number of times that each base (A, C, T, G) occurs in
        // dnaSequence.

    {
        if(!dnaSequence.isEmpty()){
            dnaSequence.gotoBeginning();
            Character c ;



            do{
                c= String.valueOf(dnaSequence.getCursor()).charAt(0);
                System.out.printf("Next: %s\n", c);
                updatecount(c);
            }while(dnaSequence.gotoNext());


        }
        else System.out.print("No Genetic Code stored!");



        
    } // countBases


    private static void updatecount(Character c) {
        if(c=='a' || c== 'A') aCount++;
        else if(c=='c' || c== 'C') cCount++;
        else if(c=='t' || c== 'T') tCount++;
        else if(c=='g' || c== 'G') gCount++;
    }



    
} // class TestDNA