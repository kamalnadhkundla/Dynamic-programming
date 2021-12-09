/*
given a sequence ofmatrices find the most efficent way to multiply the matrices together the problem is not actually to perform the multiplications.
but merely to decide in which order to perform the multiplications so that the number of multiplications is reduced
we have many options  to multiply a chain of matrices because matrix multiplication is assocaitve in other words no matter how we paranthesise
the product ,the result will be the same but the order of multiplication can reduce the number of multiplication done
 */

import java.util.HashMap;

public class Main{
 //   static int min;
   static HashMap<String,Integer>map;
    public static void main(String[] args) {
        map=new HashMap<>();
         //   int[] arr=new int[]{40,20,30,10,30};
        int[] arr=new int[]{10, 20, 30};

        System.out.println(solve(arr,1,arr.length-1));
    }
    public  static int solve(int[]p, int i , int j){
        if(map.containsKey(i+","+j))
            return map.get(i+","+j);
        int min=Integer.MAX_VALUE;
        if(i>=j)
            return 0;

        else{

            int ans=0;
            for(int k=i;k<j;k++) {
                ans = solve(p, i, k) + solve(p, k + 1, j) + (p[i - 1] * p[k] * p[j]);

                if (ans < min)
                    min = ans;
            }
        }
        map.put(i+","+j,min);
        return map.get(i+","+j);
      // recursion
//        if (i == j)
//            return 0;
//
//        int min = Integer.MAX_VALUE;
//
//        // place parenthesis at different places between
//        // first and last matrix, recursively calculate
//        // count of multiplications for each parenthesis
//        // placement and return the minimum count
//        for (int k = i; k < j; k++)
//        {
//            int count = solve(p, i, k)
//                    + solve(p, k + 1, j)
//                    + p[i - 1] * p[k] * p[j];
//
//            if (count < min)
//                min = count;
//        }
//
//        // Return minimum count
//        return min;

    }
}
