package org.learn.graph;

import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ListSortTest {
    private static final Map<String, List<String>> processRuleConfigure = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(1);
        list.add(2);
        ListSortTest listSortTest = new ListSortTest();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 5000; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    List<String> res = listSortTest.genProcessRule();
                    res.sort(String::compareTo);
                    for (String str : res) {
                        System.out.println(str);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("complete");
    }

    public void initProcessRuleConfigure() throws InterruptedException {

        System.out.println("init");
        for (int j = 1; j <= 10; j++) {
            List<String> processRules = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                TimeUnit.MILLISECONDS.sleep(10);
                processRules.add("rule" + i + ":" + j);
            }
            processRuleConfigure.put("key" + j, processRules);
        }

    }

    public List<String> genProcessRule() throws InterruptedException {
        if (processRuleConfigure.isEmpty()) {
            synchronized (this) {
                if (processRuleConfigure.isEmpty()) {
                    initProcessRuleConfigure();
                }
            }
        }
        return processRuleConfigure.get("key1");
    }

}

