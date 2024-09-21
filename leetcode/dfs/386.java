class Solution {
    public List<Integer> lexicalOrder(int n) {
        int count = 0;
        int num = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            num = i;
            if (num > n) {
                break;
            }
            ans.add(num);

            for (int j = 0; j <= 9; j++) {
                num = i * 10 + j;
                if (num > n) {
                    break;
                }
                ans.add(num);

                for (int k = 0; k <= 9; k++) {
                    num = (i * 10 + j) * 10 + k;
                    if (num > n) {
                        break;
                    }
                    ans.add(num);

                    for (int l = 0; l <= 9; l++) {
                        num = ((i * 10 + j) * 10 + k) * 10 + l;
                        if (num > n) {
                            break;
                        }
                        ans.add(num);

                        for (int m = 0; m <= 9; m++) {
                            num = (((i * 10 + j) * 10 + k) * 10 + l) * 10 + m;
                            if (num > n) {
                                break;
                            }
                            ans.add(num);
                        }
                    }
                }
            }
        }
        return ans;
    }
}