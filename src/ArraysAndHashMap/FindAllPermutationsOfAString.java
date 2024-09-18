package ArraysAndHashMap;

import java.util.*;

public class FindAllPermutationsOfAString {
    public static void main(String[] args) {
        List<String> lans = new ArrayList<>();
        findAllPermutations(new StringBuilder("abc"), 0, lans);
        for(String s: lans){
            System.out.println(s);
        }
    }

    private static void findAllPermutations(StringBuilder sb, int i, List<String> lans){
        //TC = O(n*n!), SC = O(n!)
        if(i == sb.length()) {
            lans.add(sb.toString());
            return;
        }

        for(int j = i; j<sb.length(); j++){
            swap(sb, i, j);
            findAllPermutations(sb, i+1, lans);
            swap(sb, i, j);
        }

    }


    private static void swap(StringBuilder sb, int i, int j){
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }
}

/*
abcd

permutation(abcd) =   a + permutation(bcd)  (swap a,a)
                      b + permutation(acd)  (swap a,b)
                      c + permutation(bad)  (swap a,c)
                      d + permutation(bca)  (swap a,d)


permutation(bcd) = b + permutation(cd)  (swap b,b)
                   c + permutation(bd)  (swap b,c)
                   d + permutation(cb)  (swap b,d)


permutation(cd) = c + permutation(d)  (swap c,c)
                  d + permutation(c)  (swap c,d)

permutation(d) = d  (swap d,d)

 */
