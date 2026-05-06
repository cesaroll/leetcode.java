class prefix_sum {
    public static void main(String[] args) {
        System.out.println("Prefix:");

        // print prefix sum of an array
        var prefix_sum = new prefix_sum();
        var nums = new int[]{3, 6, 2, 8, 1, 4, 1, 5 };

        var prefix = prefix_sum.pre_process_sum(nums);

        for (int i=0; i < prefix.length; i++) {            
            System.out.print(prefix[i] + " ");
        }
        System.out.println();

        System.out.println("Subarray:");
        System.out.println(prefix_sum.sum_of_subarray(prefix, 3, 6));

        System.out.println("Queries:");
        var queries = new int[][] { {0, 3}, {2, 5}, {2, 4} };
        var result = prefix_sum.answer_queries(new int[]{1, 6, 3, 2, 7, 2 }, queries, 13);
        for (int i=0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public int[] pre_process_sum(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;

        var prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i=1; i < nums.length; i++) {
            prefix[i] =  prefix[i - 1] + nums[i];
        }

        return prefix;
    }

    public int sum_of_subarray(int[] prefix, int idx1, int idx2) {
        return ((idx2 >= prefix.length) ? prefix[prefix.length - 1] : prefix[idx2]) - 
               ((idx1 <= 0)? 0 : prefix[idx1-1]);
    }

    public boolean[] answer_queries(int[] nums, int[][] queries, int limit) {
        var result = new boolean[queries.length];
        var prefix = pre_process_sum(nums);

        for (int i=0; i < queries.length; i++) {
            int sum = sum_of_subarray(prefix, queries[i][0], queries[i][1]);
            result[i] = sum < limit;
        }

        return result;
    }
}
