package Recursion;

public class FriendsPairing {
    public static void main(String[] args) {
        System.out.println(friendsPairing(4));
        String str = "1234";
        friendsPairing(str, new StringBuilder());
    }
    private static int friendsPairing(int n){
        if(n==0 || n==1 || n==2) return n;
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    private static void friendsPairing(String str, StringBuilder sb){
        if(str.isEmpty()){
            System.out.println(sb.toString());
            return;
        }

        for(int j = 0; j<str.length(); j++){
            sb.append(str.charAt(0));
            if(j != 0) sb.append(str.charAt(j));
            sb.append(" ");
            String first = "";
            if(j>0) first = str.substring(1, j);
            friendsPairing(first+str.substring(j+1), sb);
            sb.deleteCharAt(sb.length()-1); //delete space
            sb.deleteCharAt(sb.length()-1); //delete for single digit
            if(!sb.isEmpty() && sb.charAt(sb.length()-1) != ' '){ //delete for pair
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}
