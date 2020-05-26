package com.fenyun.ws.manager.thead.Executor;

/**
 * @ClassName FixedThreadPoolTest
 * @Description: TODO
 * @Author 25216
 * @Date 2020/5/26
 * @Version V1.0
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


public class FixedThreadPoolTest {

    //
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    /**	 * 超时时间/分钟	 */

    public static final int TIMEOUT = 5;
    public void testFixedThreadPool() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("applNo", "666");
        list.add(map1);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("applNo", "667");
        list.add(map2);
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("applNo", "668");
        list.add(map3);
        List<Callable<Boolean>> callableList = new ArrayList<Callable<Boolean>>();
        if (list.size() > 0) {
            System.out.println("执行次数：" + list.size());
            for (final Map map : list) {
                Callable<Boolean> call = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        try {
                            return doYouMethod();
                        } catch (Exception e) {
                            System.out.println("执行异常：" + e);
                            return null;
                        }
                    }
                };
                callableList.add(call);
            }
        }
        try {
            List<Future<Boolean>> futureList = fixedThreadPool.invokeAll(callableList);
            for (Future<Boolean> future : futureList) {
                Boolean flag = future.get(TIMEOUT, TimeUnit.MINUTES);
                if (flag) {
                    System.out.println(" 成功");
                } else {
                    System.out.println(" 失败");
                }
            }
        } catch (Exception e) {
            System.out.println(" ----- 异常 -----" + e.getMessage());
        }
    }

    public Boolean doYouMethod() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("执行你的方法");
        return true;
    }

    public static void main(String[] args) {
        FixedThreadPoolTest ft = new FixedThreadPoolTest();
        ft.testFixedThreadPool();
    }
}
