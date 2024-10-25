package SlidingWindowLeetcode;

//https://leetcode.com/problems/find-the-k-beauty-of-a-number/
public class FindTheKBeautyOfANumber {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(68735, 3));
        System.out.println(divisorSubstringsUsingStringConversion(68735, 3));
    }
    private static int divisorSubstrings(int num, int k) {
        int n = 0, temp = num;
        //to get the total number of digits
        while(temp != 0){
            n++;
            temp/=10;
        }
        int count = 0;
        //storing num in temp is important MADE MISTAKE HERE
        temp = num;

        while(temp != 0 && n>=k){
            //quotient will be the kth window number
            //will get it by dividing temp with 10^(n-k)
            int quotient = (int) (temp/(long) Math.pow(10, n-k));

            //to get the count of kth beauty number
            if(quotient != 0 && num%quotient == 0) count++;

            //kth window number will always slide by one to the right
            //so its computed using temp%10^(n-1)
            //then also decrease the total count of digits n by one
            temp = (int) (temp%(long) Math.pow(10, --n));
        }
        return count;
    }

    private static int divisorSubstringsUsingStringConversion(int num, int k) {
        String str = String.valueOf(num);
        int count = 0;
        for(int i = k; i<=str.length(); i++){
            String subStr = str.substring(i-k, i);
            int subNum = Integer.parseInt(subStr);
            if(subNum != 0 && num%subNum == 0) count++;
        }
        return count;
    }
}
