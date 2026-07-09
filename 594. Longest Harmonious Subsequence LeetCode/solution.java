//To understand some concepts below this optimized solution is added
import java.util.*;

class Main {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        
        int maxSize = 0;

        Vector<Vector<Integer>> ans = new Vector<>();
        Vector<Integer> temp = new Vector<>();

        subseq(nums, temp, ans, 0);
        
        for(int i=0; i<ans.size(); i++){
     
            if (ans.get(i).isEmpty()) {
             continue;
            }

            int min = Collections.min(ans.get(i));
            int max = Collections.max(ans.get(i));
            
            if(max - min == 1 && ans.get(i).size() > maxSize ){
                maxSize = ans.get(i).size();
            }
        }

        System.out.println(maxSize);
    }

    public static void subseq(int[] nums,
                              Vector<Integer> temp,
                              Vector<Vector<Integer>> ans,
                              int i) {

        // Base case
        if (i == nums.length) {
            ans.add(new Vector<>(temp));   // Store a copy
            return;
        }

        // Don't take current element
        subseq(nums, temp, ans, i + 1);

        // Take current element
        temp.add(nums[i]);
        subseq(nums, temp, ans, i + 1);

        // Backtracking
        temp.remove(temp.size() - 1);
    }
}


//under time limit 

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num , 0)+1);
        }

        int ans = 0;

        for(int key : map.keySet()){
            if(map.containsKey(key+1)){

                ans = Math.max(ans , map.get(key) + map.get(key+1));

            }
        }
        return ans;
    }  
}
