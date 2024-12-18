package StacksAndQueues.Stacks;
import java.util.*;

public class StackUsingList<T> {
    private final List<T> arr;

    StackUsingList(boolean isArrayList){
        if(isArrayList){
            this.arr = new ArrayList<>();
        }
        else{
            this.arr = new LinkedList<>();
        }
    }

    StackUsingList(){
        this(true);
    }


    void push(T ele){
        this.arr.add(ele);
    }

    T pop(){
        if(this.arr.isEmpty()){
            throw new EmptyStackException();
        }
        return this.arr.removeLast();
    }

    T peek(){
        if(this.arr.isEmpty()){
            throw new EmptyStackException();
        }
        return this.arr.getLast();
    }

    int size(){
        return this.arr.size();
    }

    boolean isEmpty(){
        return this.arr.isEmpty();
    }

    void print(){
        if(this.arr.isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            for(var ele: this.arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
