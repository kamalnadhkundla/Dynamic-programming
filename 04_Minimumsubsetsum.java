/*
  problem statement : given an array we have to form to two subset s1 and s2 such that sum of both s1 and s2 is equal to sum of the array and difference between the sum of s1 and 
  sum of s2 is minimum .
  given an array 
        [1,2,7] output is 4.
        need to find the minimum difference between the subsets
   approach:   if i take an element in one set rest of the elements from the array will be in another set that means if i take first element 1 in one set rest 2,7 will be in another
   set this implies any element drawn from the array is subtracted from the sum of the array the result will be in the set2
   for example [1,2,7] sum is 10
   that means in the range of 0---10 the subset sum s1,s2 is lying.and we need to find which sum is possible also beacuse 4 is lying in between 0 and 10 but cannot form a sum from
   the array possible sum that are in between 0 and 10 is  0 1 2 3 7 8 9 10 . so if i take 1 in one set and another set 10-1=9 minimum difference is 8
                                                                                 if i take 2 in one set and another set 10-2 =8 minimum difference is 6
                                                                                 if i take 3 in one set and another set 10-3=7 minimum difference is 4
                                                                                 if i take 7 in one set and another set 10-7 =3 minimum difference is 4 again
                                                                                 from here the results can repeat from all the results minimum is 4 so return 4.
   */
//recursion
public class Main
{
	public static void main(String[] args) {
		int[] arr ={1,2,7};
		int totalsumarr=10;
		
		System.out.println(getMinimumdiffernce(arr,totalsumarr,0,arr.length-1));
	}
	public static int getMinimumdiffernce(int[] arr,int totalsum,int calculatedsum,int ind){
	    if(ind==0){
	        return Math.abs((totalsum-calculatedsum)-calculatedsum);
	    }
	    
	   int diff=Math.min(getMinimumdiffernce(arr,totalsum,calculatedsum+arr[ind],ind-1),getMinimumdiffernce(arr,totalsum,calculatedsum,ind-1));
	   return diff;
	}
}

// memorization
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] arr ={1,2,7};
		int totalsumarr=10;
		Map<String,Integer> map=new HashMap<>();
		System.out.println(getMinimumdiffernce(arr,totalsumarr,0,arr.length-1,map));
	}
	public static int getMinimumdiffernce(int[] arr,int totalsum,int calculatedsum,int ind,Map<String,Integer>map){
	    String x= ind+" "+calculatedsum;
	    if(map.containsKey(x))
	         return map.get(x);
	    if(ind==0){
	        return Math.abs((totalsum-calculatedsum)-calculatedsum);
	    }
	    
	   int diff=Math.min(getMinimumdiffernce(arr,totalsum,calculatedsum+arr[ind],ind-1,map),
	   getMinimumdiffernce(arr,totalsum,calculatedsum,ind-1,map));
	   map.put(x,diff);
	   
	   return diff;
	}
}

