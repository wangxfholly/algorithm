package org.learn.arrays;

/**
 * 开发商购买土地
 *
 * @author holly
 *
 *     <a href="https://kamacoder.com/problempage.php?pid=1044">开发商购买土地</a>
 */
public class DeveloperBuysLand {

    public static void main(String[] args) {
        int[][] land = new int[][] {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        int sum = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                sum += land[i][j];
            }
        }
        int result = findLand(land, sum);
        System.out.println(result);
    }

    public static int findLand(int[][] land, int sum) {

        //统计横向
        int[] horizontal = new int[land.length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                horizontal[i] += land[i][j];
            }
        }

        //统计纵向
        int[] vertical = new int[land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                vertical[j] += land[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        int horizontalCut = 0;
        for (int i = 0; i < horizontal.length; i++) {
            horizontalCut += horizontal[i];
            result = Math.min(result, Math.abs(sum - 2 * horizontalCut));
        }
        int verticalCut = 0;
        for (int j = 0; j < vertical.length; j++) {
            verticalCut += vertical[j];
            result = Math.min(result, Math.abs(sum - 2 * verticalCut));
        }
        System.out.println(result);
        return result;

    }
}
