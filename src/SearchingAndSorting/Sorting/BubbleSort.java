package SearchingAndSorting.Sorting;

public class BubbleSort {
    private static int unoptimizedCount = 0, optimizedCount = 0, unoptimizedRecursiveCount = 0, optimizedRecursiveCount = 0;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        bubbleSortRecursive(arr, 0, 0);
        for(var ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        arr = new int[]{1,2,3,4,5};
        bubbleSortRecursiveOptimized(arr, 0, 0, false);
        for(var ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        System.out.println("unoptimized bubble sort swap count -> " + unoptimizedCount);
        System.out.println("optimized bubble sort swap count -> " + optimizedCount);
        System.out.println("unoptimized bubble sort recursive swap count -> " + unoptimizedRecursiveCount);
        System.out.println("optimized bubble sort recursive swap count -> " + optimizedRecursiveCount);
    }

    private static void bubbleSort(int[] arr){
        //TC = Worst case & Best case = O(n^2)
        //if n-1 elements are placed correctly then whole array is sorted
        for(int j = 0; j<arr.length-1; j++){
            //for placing a single element in its correct place
            for(int i = 0; i<arr.length-1-j; i++){
                unoptimizedCount++;
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    private static void optimizedBubbleSort(int[] arr){
        //TC = Worst case O(n^2), Best case O(n)
        for(int j = 0; j<arr.length-1; j++){
            boolean isSwapped = false;
            for(int i = 0; i< arr.length-1-j; i++){
                optimizedCount++;
                if(arr[i] > arr[i+1]){
                    isSwapped = true;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if(!isSwapped) return;
        }
    }

    private static void bubbleSortRecursive(int[] arr, int i, int j){
        if(i == arr.length-1) return;
        if(j == arr.length-1-i){
            bubbleSortRecursive(arr, i+1, 0);
        }
        else{
            unoptimizedRecursiveCount++;
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            bubbleSortRecursive(arr, i, j+1);
        }
    }

    private static void bubbleSortRecursiveOptimized(int[] arr, int i, int j, boolean isSwapped){
        if(i == arr.length-1) return;
        if(j == arr.length-1-i){
            if(!isSwapped) return;
            bubbleSortRecursiveOptimized(arr, i+1, 0, false);
        }
        else{
            optimizedRecursiveCount++;
            if(arr[j]>arr[j+1]){
                isSwapped = true;
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            bubbleSortRecursiveOptimized(arr, i, j+1, isSwapped);
        }
    }
}
