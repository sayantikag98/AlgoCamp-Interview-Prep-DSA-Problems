package StacksAndQueues.Stacks;

public class StackUsingArrayDemo {
    public static void main(String[] args) {
        StackUsingArray st = new StackUsingArray();
        System.out.println(st.isFull());
        System.out.println(st.isEmpty());
        System.out.println(st.size());
        st.print();
        st.push(10);
        st.print();
        st.push(20);
        st.print();
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        st.push(80);
        st.push(90);
        st.push(100);
        st.push(110);
        st.push(120);
        st.push(130);
        st.push(140);
        st.push(150);
        st.push(160);
        st.print();
        System.out.println(st.pop());
        st.print();
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.print();




    }
}
