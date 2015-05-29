/**
 * Created by jlarrie1 on 5/28/2015.
 */
//--------------------------------------------------------------------
//
//  Laboratory 4                                       ListArray.jshl
//
//  Class definition for the array implementation of the List ADT
//
//  The student is to complete all missing or incomplete method
//     implementations for this class
//
//--------------------------------------------------------------------

class ListArray implements List
{
    // Data Members
    private int size=0,           // Actual number of elements in the list
            cursor=-1;         // Cursor array index
    private Object [] element;  // Array containing the list elements
    // As type Object, they are 'generic'

    // Constructors and helper method setup
    public ListArray( )             // Constructor: default size
    {
        setUp(List.DEF_MAX_LIST_SIZE);
    }

    public ListArray(int maxNumber) // Constructor: specific size
    {
        setUp(maxNumber);

    }

    // Class methods
    private void setUp (int maxNumber)  // Called by constructors only
    {
        element = new Object[maxNumber];

    }

    // ------ Insert method implementations for the interface List here ------ //


    @Override
    public void insert(Object newElement) {
        if(!isFull()) {

            if(isEmpty()){
                element[0]=newElement;
                size++;
                cursor++;
            }
            else {
                size++;
                if(cursor==size-1){

                    cursor++;
                    element[cursor]=newElement;
                }
                else{
                    for(int i=size; i>cursor; i++){
                        element[i]= element[i-1];
                    }
                    cursor++;
                }
            }

        }
        else System.out.println("The list has reached its maximum size and element cannot be added!");


    }

    @Override
    public void remove() {
        if(sizeCheck()){
            for(int i=cursor; i<size; i++){
                element[i]=element[i+1];
            }
            size--;
            cursor--;
        }
        else System.out.println("The list contains no element and therefore nothing will be removed!");

    }

    @Override
    public void replace(Object newElement) {
        if(sizeCheck()){
            element[size-1]= newElement;
        }
    }

    @Override
    public void clear() {
        size=0;
        cursor=-1;
    }

    private boolean sizeCheck(){
        return  !isEmpty() && !isFull();
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==element.length;
    }

    @Override
    public boolean gotoBeginning() {
        if(size==0) return false;
        else {
            cursor=0;
            return  true;
        }
    }

    @Override
    public boolean gotoEnd() {
        if(size==0)return false;
        else {
            cursor= size-1;
            return true;
        }
    }

    @Override
    public boolean gotoNext() {
        if(cursor==size-1)return false;
        else {
            cursor++;
            return true;
        }
    }

    @Override
    public boolean gotoPrior() {
        if(cursor==0) return false;
        else {
            cursor --;
            return true;
        }
    }

    @Override
    public Object getCursor() {
        if(cursor>-1)
        return element[cursor];
        else return null;
    }

    public int getCursorValue(){
        return cursor;
    }

    public void showStructure ( )
    // Outputs the elements in a list. If the list is empty, outputs
    // "Empty list". This operation is intended for testing/debugging
    // purposes only.

    {
        int j;   // Loop counter

        if ( size == 0 )
            System.out.println("Empty list");
        else
        {
            System.out.println("size = " + size + "   cursor = "
                    + cursor);
            for ( j = 0 ; j < element.length ; j++ )
                System.out.print(j + "\t");
            System.out.println( );
            for ( j = 0 ; j < size ; j++ )
                System.out.print(element[j] + "\t");
            System.out.println( );
        }
    }

    //--------------------------------------------------------------------
    //
    //                        In-lab operations
    //
    //--------------------------------------------------------------------

//    public void moveToNth ( int n )         // Move element to position n
//    {
//
//    }
//
//    public boolean find ( Object searchElement )    // Find searchElement
//    {
//
//    }


} // class ListArray