package RecursionAndBacktracking;
import java.util.Scanner;

public class FamilyStructure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test>0){
            int n = sc.nextInt();
            long k = sc.nextLong(); //k should be long because of constraints given in the question
            if(familyStructure(n, k)){
                System.out.println("Male");
            }
            else{
                System.out.println("Female");
            }
            test--;
        }
    }


    private static boolean familyStructure(int n, long k){
        // MISTAKE MADE HERE -> DID NOT INCLUDE K == 1 IN BASE CASE
        // BECAUSE AT EVERY RECURSIVE CALL N REDUCES BY 1 AND K REDUCES TO HALF SO BASE CASE SHOULD HAVE K == 1 ONLY AND NOT N == 1
        //TC = O(log k), SC = O(log k)
        //male = true
        //female = false
        if(k == 1) return true; //first child of any generation is always male
        boolean ans = familyStructure(n-1, (k+1)/2);
        if(ans){
            //first child of M is M so if k is odd return true
            return (k&1) == 1;
        }
        //second child of F is M so if k is even return true
        return (k&1) == 0;
    }
}
