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
        Object obj;
        if(!isFull()) {


               if(size>0){

                   for(int i=size; i>=cursor; i--){

                       element[i+1]=element[i];
                       System.out.printf("Current i: %d\t element at i: %s\t element at i+1: %s\n", i, String.valueOf(element[i]), String.valueOf(element[i+1]));
                   }

               }
            cursor++;

                element[cursor]=newElement;

            size++;


        }
        else System.out.println("The list has reached its maximum size and element cannot be added!");


    }

    @Override
    public void remove() {
        if(sizeCheck()){
            for(int i=cursor; i<size; i++){
                element[i]=element[i+1];
            }
            if(cursor==size-1) cursor=0;
            size--;

        }
        else System.out.println("The list contains no element and therefore nothing will be removed!");

    }

    @Override
    public void replace(Object newElement) {
        if(sizeCheck()){
            element[cursor]= newElement;
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

    public void moveToNth ( int n )         // Move element to position n
    {
        System.out.printf("Move to n: %d\n", n);
        int correction=0, oldCursorPosition =cursor;
        if(size>n){
            Object obj = getCursor();

            remove();
            System.out.printf("Current cursor after remove: %d\n", cursor);
            if(n-1<0) cursor=0;
            else      cursor = n-1;
            System.out.printf("Current cursor before insert: %d\n", cursor);
            insert(obj);


        }

    }
//
    public boolean find ( Object searchElement )    // Find searchElement
    {

        if(!isEmpty()){
            int i ;
            for(i =cursor; i<size; i++){
                System.out.printf("Current i: %d, with value\t\t with value: %s\n", i, String.valueOf(getCursor()));
                if(String.valueOf(searchElement).equals(String.valueOf(getCursor()))){
                    System.out.printf("Element found at %d\n", i);

                    return true;
                }
                gotoNext();

            }

            if(i==size-1) return false;
        }
        else {
            System.out.printf("Empty list, cannot search ");
            return false;
        }
        return false;
    }


} // class ListArray