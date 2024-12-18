package StacksAndQueues.Stacks;
import java.util.*;

public class StockSpannerDemo{
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(100));
        System.out.println(ss.next(80));
        System.out.println(ss.next(60));
        System.out.println(ss.next(70));
        System.out.println(ss.next(60));
        System.out.println(ss.next(75));
        System.out.println(ss.next(85));
        System.out.println(ss.next(100));
    }
}

class StockSpanner {
    private final List<Integer> priceList;
    private final Stack<Integer> st;

    public StockSpanner() {
        this.priceList = new ArrayList<>();
        this.st = new Stack<>();
    }

    int next(int price) {
        //find previous greater element index
        //TC = O(n), SC = O(n)
        int pgeIdx = -1;
        while(!st.empty() && priceList.get(st.peek()) <= price){
            st.pop();
        }
        if(!st.empty()){
            pgeIdx = st.peek();
        }
        st.push(priceList.size());
        priceList.add(price);
        return priceList.size()-pgeIdx-1;
    }
}
