package LinkedList.DoublyLinkedList;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class FlattenAMultilevelDoublyLinkedList {
//    private static Node flatten(Node head) {
//        //base case
//        if(head == null) return null;
//
//        //recursion will give me two things
//
//        //it will give the flattened list from head.next node
//        Node headNextFlattenedList = flatten(head.next);
//
//        //self work
//        //i need to flatten the node of the current head
//
//        //here recursion helps with the second thing
//        //it will give me the flattened list of the child node of the current head
//
//        Node childFlattenedList = flatten(head.child);
//
//        //now i need to connect the child flattened list with the current head but need to also check if the child flattened list is null or not
//        //if it is null then you will have to connect head with the flattened list of the next node of head
//
//        if(childFlattenedList != null){
//            head.next = childFlattenedList;
//            childFlattenedList.prev = head;
//
//            // also have to connect the end of the child flattened list with the flattened list of the next node
//
//            //find the end of child flattened list
//            while(childFlattenedList.next != null){
//                childFlattenedList = childFlattenedList.next;
//            }
//
//            childFlattenedList.next = headNextFlattenedList;
//            //but next flattened list may be null so check before attaching prev
//
//            if(headNextFlattenedList != null) headNextFlattenedList.prev = childFlattenedList;
//        }
//        else{
//            //child flattened list is null so connect head with next flattened list
//            head.next = headNextFlattenedList;
//
//            //but next flattened list may be null so check before attaching prev
//
//            if(headNextFlattenedList != null) headNextFlattenedList.prev = head;
//        }
//
//        // make child as null
//
//        head.child = null;
//
//        return head;
//    }
}
