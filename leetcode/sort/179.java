class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = numToString(nums);
        radixSort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (String s: arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    private String[] numToString(int[] nums) {
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Integer.toString(nums[i]);
        }
        return result;
    }

    private void radixSort(String[] arr) {
        int maxLen = 0;
        for (String s: arr) {
            maxLen = Math.max(maxLen, s.length());
        }

        for (int i = 0; i < maxLen; i++) {
            bucketSort(arr, i);
        }
    }

    private void bucketSort(String[] arr, int place) {
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        for (String s: arr) {
            int digit = place < s.length() ? s.charAt(place) - '0' : s.charAt(0) - '0';
            buckets.get(digit).add(s);
        }

        int index = 0;
        for (int i = 9; i >= 0; i--) {
            for (String s: buckets.get(i)) {
                arr[index] = s;
                index++;
            }
        }
    }
}