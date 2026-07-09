import java.util.*;

class Main {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        Vector<Vector<Integer>> ans = new Vector<>();
        Vector<Integer> temp = new Vector<>();

        subseq(nums, temp, ans, 0);

        System.out.println(ans);
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