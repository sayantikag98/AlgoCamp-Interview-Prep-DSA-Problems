package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;

//https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        Node head = convert(new int[]{5,3,1,2,5,1,2});
        int[] ans = nodesBetweenCriticalPoints(head);
        System.out.println(ans[0]+" "+ans[1]);
    }
    private static int[] nodesBetweenCriticalPoints(Node head) {
        int[] ans = {-1, -1};
        if(head == null || head.next == null || head.next.next == null) return ans;

        //minimum of three nodes

        Node curr = head.next, prev = head;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxStart = 0, minPrevStart = 0, dist = 1;



        while(curr.next != null){
            dist++;
            Node next = curr.next;
            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)){
                if(maxStart == 0){
                    //first critical point
                    maxStart = dist;
                    minPrevStart = dist;
                }
                else{
                    min = Math.min(min, dist-minPrevStart);
                    minPrevStart = dist;
                }
            }
            prev = curr;
            curr = curr.next;
        }

        //there are no critical point when maxStart = 0
        //there is one critical point when maxStart == minPrevStart & both != 0

        if(maxStart == 0 || maxStart == minPrevStart) return ans;

        max = minPrevStart - maxStart;

        ans[0] = min;
        ans[1] = max;

        return ans;
    }
}
