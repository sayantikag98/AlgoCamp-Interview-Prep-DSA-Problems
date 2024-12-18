package StacksAndQueues.Stacks;

public class StackUsingLinkedListDemo {
    public static void main(String[] args) {
        StackUsingLinkedList<Integer> st = new StackUsingLinkedList<>();
        st.print();
        System.out.println(st.size());
        System.out.println(st.isEmpty());
        st.push(10);
        st.push(20);
        st.print();
        System.out.println(st.pop());
        st.print();
        System.out.println(st.peek());
        st.push(30);
        st.push(40);
        st.push(50);
        st.print();
        st.push(60);
        st.print();
        st.push(70);
        st.print();
        st.push(80);
        st.print();
        System.out.println(st.isFull());
        System.out.println(st.size());
    }
}
