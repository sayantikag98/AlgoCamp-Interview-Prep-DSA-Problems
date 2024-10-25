package ArraysAndHashMap;
import java.util.*;

//https://www.codechef.com/problems/CSS2
/*
MISTAKES:
List.of() -> Immutable, set() will not work
Arrays.asList() -> Mutable, set() will work

List, ArrayList -> [] is not overridden so use get() for access and set() for modification
 */
public class CascadingStyleSheets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        HashMap<String, List<Integer>> styles = new HashMap<>();
        while(n-->0){
            int id = sc.nextInt(), attr = sc.nextInt(),
            val = sc.nextInt(), priority = sc.nextInt();
            String key = id+" "+attr;
            if(styles.containsKey(key)){
                List<Integer> value = styles.get(key);
                if(value.get(1) <= priority){
                    value.set(0, val);
                    value.set(1, priority);
                }
            }
            else{
                styles.put(key, Arrays.asList(val, priority));
            }
        }

        while(m-->0){
            int id = sc.nextInt(), attr = sc.nextInt();
            String key = id+" "+attr;
            if(styles.containsKey(key)){
                System.out.println(styles.get(key).get(0));
            }
        }
    }
}

/*
6 2
22 1 200 2
22 1 300 2
22 1 100 1
22 2 30 2
22 2 40 1
22 1 500 1
22 1
22 2
 */
