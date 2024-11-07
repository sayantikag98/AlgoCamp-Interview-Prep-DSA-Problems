package Recursion;

public class SumOfDigitsOfString {
    public static void main(String[] args) {
        System.out.println(sumOfDigits("12345009", 0));
    }
    private static int sumOfDigits(String str, int i){
        if(i == str.length()) return 0;
        return str.charAt(i) - 48 + sumOfDigits(str, i+1);
    }
}
