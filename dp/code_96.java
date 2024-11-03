package dp;
//https://www.bilibili.com/video/BV1Fk4y1m7KJ/?spm_id_from=333.337.search-card.all.click&vd_source=3b5289b64f49a8c9842175c409fbaa53
//代码随想录的讲解不好，以上视频是一个很讨巧的思想（基本算是等意义替换）
//96. 不同的二叉搜索树
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
public class code_96 {
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<=i-1; j++){
                f[i] += f[j] * f[i-j-1];
            }
        }

        return f[n];

    }
}
