package ArraysAndHashMap;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-players-with-zero-or-one-losses/
public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        System.out.println(findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }
    private static List<List<Integer>> findWinners(int[][] matches) {
        //TC = O(n)+O(m), SC = O(m)
        //where n is the length of matches array
        // and m is the length of matches[i] having maximum length
        int[] lossFreqCount = new int[100000];
        for(int[] match: matches){
            int lossIdx = match[1]-1, winIdx = match[0]-1;
            /*
            player with no loss will have a frequency 1
            player with one loss will have frequency 2
            player with two losses will have frequency 3
            and so on....
             */
            if(lossFreqCount[lossIdx] == 0){
                lossFreqCount[lossIdx] = 2;
            }
            else{
                lossFreqCount[lossIdx] += 1;
            }
            if(lossFreqCount[winIdx] == 0){
                lossFreqCount[winIdx] = 1;
            }
        }
        List<Integer> lossZero = new ArrayList<>(), lossOne = new ArrayList<>();
        for(int i = 0; i<lossFreqCount.length; i++){
            if(lossFreqCount[i] == 1) lossZero.add(i+1);
            if(lossFreqCount[i] == 2) lossOne.add(i+1);
        }
        return List.of(lossZero, lossOne);
        // or return Arrays.asList(lossZero, lossOne);
    }
}
