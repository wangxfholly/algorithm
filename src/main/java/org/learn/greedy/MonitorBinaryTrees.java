package org.learn.greedy;

import org.learn.tree.TreeNode;

public class MonitorBinaryTrees {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        //对根节点状态做校验，防止根节点是无覆盖状态
        if (minCame(root) == 0) {
            res++;
        }
        return res;
    }
    /**
     * 节点的状态值
     * 0 表示无覆盖
     * 1 表示有摄像头
     * 2 表示有覆盖
     * 后续遍历，根据左右节点的情况，来判断自己的状态
     */

    public int minCame(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        //左右节点都覆盖了的话，那么本节点的状态应该是无覆盖，没有摄像头
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            //左右节点有一个无覆盖，那么本节点就是有摄像头
            res++;
            return 1;
        } else {
            //左右节点有一个有摄像头，那么本节点就是有覆盖
            return 2;
        }
    }

}
