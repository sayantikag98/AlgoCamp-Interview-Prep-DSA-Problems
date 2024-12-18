package SearchingAndSorting.Sorting;
import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,1,2,1,4,2,3,5};
        quickSort(arr, 0, arr.length-1);
        for(var ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int l, int r){
        if(l>=r) return;
        //this call makes sure that the pivot is placed in its correct place
        int partitionIdx = partition(arr, l, r);
        quickSort(arr, l, partitionIdx-1);
        quickSort(arr, partitionIdx+1, r);
    }


    //partition method makes sure that pivot is at correct place after it is being called
    //partition method will return an index which will have the pivot (arr[partitionIndex] = pivot) and all elements to the left of partition index will be less than
    //or equal pivot and all elements to the right of partition index will be greater than pivot
    private static int partition(int[] arr, int l, int r){
        //****** this algo is very similar to the 0 1 sort algo using two pointers ********

        //mid is the pivot index
        //int pivot = arr[l+(r-l)/2];

        //pivot index is a random index from l to r
        Random rand = new Random();
        //Returns a pseudorandomly chosen int value between the specified origin (inclusive) and the specified bound (exclusive)
        int pivot = arr[rand.nextInt(l,r+1)];
        int pivotIdx = -1; //for storing the index where pivot is present
        while(l<r){
            if(arr[l] <= pivot){
                if(arr[l] == pivot){
                    pivotIdx = l;
                }
                l++;
            }
            else{
                //swap arr[l] & arr[r]
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                r--;
            }
        }
        /*
        pivot is there in the array
        there could be one of the three situations
        if arr[l] > pivot
            then any index < l would have elements <= pivot and any index >= l would be having elements greater than pivot
            doing l-- would make sure that l index have element <= pivot (l-- would not go outside bounds because pivot is there in the array so there would be atleast 1 element to the left of l)
            and then do the swap of arr[l] and arr[pivotIdx]
        or arr[l] = pivot
            do nothing because l is my partition index
        or arr[l] < pivot
            then do the swap of arr[l] and arr[pivotIdx]

        swap of arr[l] and arr[pivotIdx] makes sure that pivot is placed at l

        finally l is my partition index
         */

        //makes sure that arr[l] always points to element <= pivot
        if(arr[l]>pivot) l--;

        //makes sure that arr[l] is pivot
        if(arr[l] != pivot){
            arr[pivotIdx] = arr[l];
            arr[l] = pivot;
        }

        return l;
    }
}


