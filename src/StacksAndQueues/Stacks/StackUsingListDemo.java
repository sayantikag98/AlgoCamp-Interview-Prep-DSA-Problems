package StacksAndQueues.Stacks;

public class StackUsingListDemo {
    public static void main(String[] args) {
        StackUsingList<Integer> stackUsingArrayList = new StackUsingList<Integer>();
        StackUsingList<Integer> stackUsingLinkedList = new StackUsingList<>(false);
        System.out.println(stackUsingLinkedList.isEmpty());
        System.out.println(stackUsingArrayList.isEmpty());
        stackUsingArrayList.push(10);
        stackUsingLinkedList.push(10);
        stackUsingArrayList.print();
        stackUsingLinkedList.print();
        stackUsingArrayList.push(20);
        stackUsingLinkedList.push(20);
        stackUsingArrayList.print();
        stackUsingLinkedList.print();
        stackUsingArrayList.push(30);
        stackUsingLinkedList.push(30);
        stackUsingArrayList.print();
        stackUsingLinkedList.print();
        System.out.println(stackUsingArrayList.pop());
        System.out.println(stackUsingLinkedList.pop());
        stackUsingArrayList.print();
        stackUsingLinkedList.print();
        System.out.println(stackUsingArrayList.peek());
        System.out.println(stackUsingLinkedList.peek());
        stackUsingArrayList.print();
        stackUsingLinkedList.print();
        System.out.println(stackUsingArrayList.size());
        System.out.println(stackUsingLinkedList.size());

    }



}
