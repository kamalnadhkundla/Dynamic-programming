/*

 
Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces

recursion
----------
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = 4;
        int[] lengths = new int[]{1, 2,3,4
        };
        int[] profits = new int[]{1,5,8,9};

        System.out.println(backtrack(lengths, profits, len, 0,0));


    }

    public static int backtrack(int[] lengths, int[] profits, int n, int i,int profit) {
       
        if (i>=lengths.length || n<=0) {
            return profit;
        } else if(lengths[i]>n){
            return backtrack(lengths,profits,n,i+1,profit);

        }
        else
            return Math.max(backtrack(lengths,profits,n-lengths[i],i,profit+profits[i]),backtrack(lengths,profits,n,i+1,profit));

     
    }
}

memorization
------------
import java.util.HashMap;
import java.util.Scanner;

public class Main {
static HashMap<String,Integer> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   map=new HashMap<>();
        int len = 4;
        int[] lengths = new int[]{1, 2,3,4
        };
        int[] profits = new int[]{ 1, 5, 8, 9 };

        System.out.println(backtrack(lengths, profits, len, 0,0));


    }

    public static int backtrack(int[] lengths, int[] profits, int n, int i,int profit) {
        if(map.containsKey(n+""+i))
            map.get(n+""+i);
        if (i>=lengths.length || n<=0) {
            return profit;
        } else if(lengths[i]>n){
            map.put(n+""+i, backtrack(lengths,profits,n,i+1,profit));

        }
        else
            map.put(n+""+i ,Math.max(backtrack(lengths,profits,n-lengths[i],i,profit+profits[i])
                    ,backtrack(lengths,profits,n,i+1,profit)));

        return map.get(n+""+i);


    }
}
*/


