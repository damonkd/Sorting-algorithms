/**
 * Implements various sorting algorithms.
 * 
 * @author (your name), Acuna, Sedgewick
 * @verison (version)
 */

public class DanielsBaseSorting {
     
    /**
     * Entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        String[] a = {"B", "X", "A", "M", "J", "E", "V", "R", "P", "L", "C"};
        quicksortmid(a);
        assert isSorted(a); //requires assertions enabled.
        show(a);
        
        Integer[] e = {6, 10, 5, 24, 2, 33, 151, 69, 4, 12, 42};
        assert isSorted(e);
        quicksortmid(e);
        show(e);
        
        Integer[] f = {12};
        assert isSorted(f);
        quicksortmid(f);
        show(f);
        
        //Q2
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        mergesort(b);
        assert isSorted(b);
        show(b);
    
        Integer[] c = {6, 10, 5, 24, 2, 33, 151, 69, 4, 12, 42};
        assert isSorted(c);
        mergesort(c);
        show(c);
        
        Integer[] g = {6};
        assert isSorted(g);
        mergesort(g);
        show(g);
        
    
    }
    
    public static <T extends Comparable<T>> 
	void quicksortmid(T[] data)
{
    	//show(data);
    	quickSort(data, 0, data.length - 1);
	
}

/**
 * Recursively sorts a range of objects in the specified array using the
 * quick sort algorithm. 
 * 
 * @param data the array to be sorted
 * @param min  the minimum index in the range to be sorted
 * @param max  the maximum index in the range to be sorted
 */
private static <T extends Comparable<T>> 
	void quickSort(T[] data, int min, int max)
{
	if (min < max)
		
	{
		//System.out.println();
		//System.out.println("quicksort method " + min + " " + max);
		//System.out.println();
		// create partitions
		int indexofpartition = partition(data, min, max);
		
		//System.out.println();
		//System.out.println("quicksort method index of partition " + indexofpartition);
		//System.out.println();
		
		// sort the left partition (lower values)
		quickSort(data, min, indexofpartition - 1);
		
		
		
		// sort the right partition (higher values)
		quickSort(data, indexofpartition + 1, max);
		
	}
}

/**
 * Used by the quick sort algorithm to find the partition.
 * 
 * @param data the array to be sorted
 * @param min  the minimum index in the range to be sorted
 * @param max  the maximum index in the range to be sorted
 */
private static <T extends Comparable<T>> 
	int partition(T[] data, int min, int max)
{
	T partitionelement;
	
	
	
	
	int left, right;
	int middle = (min + max) / 2;
	
	
	
	//System.out.println();
	//System.out.println("Partition Method min max & middle " + min +" " + max + " " + middle);
	//System.out.println();
	
	
	
	// use the middle data value as the partition element
	//partitionelement = data[middle];
	// move it out of the way for now
	
	
	
	 if( data[ middle ].compareTo( data[ min ] ) > 0 )
         swap( data, min, middle );
	 //System.out.println(data[ middle ] + " " +data[ min ]);
    
	 if( data[max].compareTo( data[ min ] ) > 0 )
         swap(data, min, max );
	
	 //System.out.println(data[ min ] + " " +data[ max ]);
     
	 if( data[max ].compareTo( data[ middle ] ) > 0 )
         swap( data, middle, max);
	 //System.out.println(data[ middle ] + " " +data[ max ]);
	
	 partitionelement = data[middle];
	 
	// System.out.println();
	//System.out.println("Pivot " + partitionelement);
	//System.out.println();
	
	
	
	//System.out.println();
	//System.out.println("move middle left " + data[min] + " " + data[middle]);
	//System.out.println();
	
	swap(data, middle, min);
	//show(data);
	left = min;
	right = max;
	
	
	
	
	//System.out.println();
	//System.out.println("right equals " + right +" " + data[right]);
	//System.out.println();
	
	
	
	//System.out.println("partition method left, right, middle, " + left + ", " + right + ", " +middle);
	while (left < right)
	{
		// search for an element that is > the partition element
		while (left < right && data[left].compareTo(partitionelement) <= 0)
			left++;
		
		// search for an element that is < the partition element
		while (data[right].compareTo(partitionelement) > 0)
			right--;
		
		// swap the elements
		if (left < right)
		{
			//System.out.println();
			//System.out.println("swapping left and right " + data[left] + " " + data[right]);
			//System.out.println();
			swap(data, left, right);
		//show(data);
		}
		}
	
	// move the partition element into place
	//System.out.println();
	//System.out.println("move partition into place " + data[min] + " " + data[right]);
	//System.out.println();
	swap(data, min, right);
	//show(data);
	//System.out.println();
	//System.out.println("Right value before return " + right);
	//System.out.println();
	
	return right;
}
    
    
private static <T extends Comparable<T>> 
void swap(T[] data, int index1, int index2)
{
T temp = data[index1];
data[index1] = data[index2];
data[index2] = temp;
}




public static void mergesort(Comparable[] a) {
        //TODO: implement this.
    //sets MergeArry = to mergesortRec and then copies data to it
    Comparable[] mergeArray = mergeSortRec(a);
    
    for(int i =0; i< mergeArray.length; i++) {
    a[i] = mergeArray[i];
    }
    }
    
   // divides arrays in half if already length 1 returns array calls itself recursivly
public static Comparable[] mergeSortRec(Comparable[] a)
{
	// base case
	if(a.length == 1)
return a;
	
	//new left hand array
	Comparable[] leftArray = new Comparable[a.length/2];
	//new right aray
	Comparable[] rightArray = new Comparable[a.length - (a.length / 2)];
	 //copies elements to left array
	for(int i=0; i < leftArray.length ; i++)
		leftArray[i] = a[i];
	 // copies elements to right array
	for(int j=0; j < rightArray.length; j++)
		rightArray[j] = a[leftArray.length + j] ;
	
	//recursive calls
	mergesort(leftArray);
	mergesort(rightArray);
	
	//calls merge on arrays
	return merge(leftArray, rightArray, a);
	
	
}
    
// merges arrays    
public static Comparable[] merge(Comparable[] leftSide, Comparable[] rightSide, Comparable[] a)   
    
{
	int leftCount =0;
	int rightCount =0;
	int aCount =0;
	 //loop merges elements into a 
	while(leftCount < leftSide.length && rightCount < rightSide.length)
	{
		if(leftSide[leftCount].compareTo(rightSide[rightCount]) <=0)
		{
			a[aCount] = leftSide[leftCount];
			leftCount++;
		}
		else
		{
			a[aCount] = rightSide[rightCount];
			rightCount++;
		}
	aCount++;
	}
	System.arraycopy(leftSide, leftCount, a, aCount, leftSide.length - leftCount);
	System.arraycopy(rightSide, rightCount, a, aCount, rightSide.length-rightCount);
	
	return a;




}
    
    
    
    
    
    
    
    /**
     * Displays contents of array, space separated.
     * @author Sedgewick
     * @param a Array to display.
     */
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    /**
     * Checks if array is in sorted order.
     * @author Sedgewick
     * @param a Array to be checked.
     * @return Returns true if array is sorted.
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    //See previous method.
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}