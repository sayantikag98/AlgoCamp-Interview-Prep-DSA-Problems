package SearchingAndSorting.Sorting;

public class SortLexicographically {
    public static void main(String[] args) {
        String[] nums = {"papaya", "lime", "watermelon", "apple", "mango", "kiwi"};
        sort(nums);
        for(var ele: nums){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    /*
    Specified by:
    compareTo in interface Comparable
    Params:
    anotherString – the String to be compared.
    Returns:
    the value 0 if the argument string is equal to this string; a value less than 0 if this string is lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically greater than the string argument.
     */

    private static void sort(String[] fruits){
        for(int i = 0; i<fruits.length-1; i++){
            int minIdx = i;
            for(int j = i+1; j<fruits.length; j++){
                if(fruits[minIdx].compareTo(fruits[j])>0){
                    minIdx = j;
                }
            }
            if(minIdx != i){
                String temp = fruits[minIdx];
                fruits[minIdx] = fruits[i];
                fruits[i] = temp;
            }
        }
    }
}
