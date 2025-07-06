package daily.day27;

import java.util.Arrays;

class LC_0455_Assign_Cookies {
    //贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先。时间复杂度 O(n log n)，排序是瓶颈。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // 满足一个小孩
            }
            j++; // 不论是否满足，都要换一块饼干
        }
        return i;
    }
}
