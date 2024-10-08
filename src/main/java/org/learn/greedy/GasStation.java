package org.learn.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = Math.min(min, sum);
        }
        if (sum < 0) {
            return -1;
        }
        if(min >=0) {
            return 0;
        }
        for (int i = gas.length - 1; i >= 0; i--) {
            min += Math.min(min, gas[i] - cost[i]);
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }
}
