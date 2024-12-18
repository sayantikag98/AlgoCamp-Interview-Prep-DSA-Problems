package LinkedList.DoublyLinkedList;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.convert;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        Node head = convert(new int[] {1,5,2,6,3});
        int[] ans = findMinAndMaxDist(head);
        System.out.println(ans[0] + " " + ans[1]);
    }


    private static int[] findMinAndMaxDist(Node head){
        int[] ans = {-1, -1};

        if(head == null || head.next == null || head.next.next == null) return ans;

        //minimum of three nodes

        Node curr = head.next;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxStart = 0, minPrevStart = 0, dist = 1;

        while(curr.next != null){
            Node prev = curr.prev, next = curr.next;
            dist++;

            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)){

                if(maxStart == 0){
                    //first critical point
                    maxStart = dist;
                }
                else{
                    min = Math.min(min, dist - minPrevStart);
                }
                minPrevStart = dist;
            }

            curr = curr.next;

        }

        // zero critical point when maxStart = 0
        // one critical point when maxStart = minPrevStart and both != 0

        if(maxStart == 0 || maxStart == minPrevStart) return ans;

        max = minPrevStart - maxStart;

        ans[0] = min;
        ans[1] = max;

        return ans;
    }
}
