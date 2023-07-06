package org.clb.juc.thread.forkjoin_pool;

import lombok.Data;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Classname ForkJoinPoolTest
 * @Date 2021/6/5 14:14
 * @Author clb
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<BigDecimal> list = new ArrayList<>();
        BigDecimal reduce = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);
    }
    public static void test() {
        ForkJoinPool fk=new ForkJoinPool();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(1);
        }
        MyTask myTask = new MyTask(list, 0, 1000,"task1");
        fk.submit(myTask);
        MyTask myTask2 = new MyTask(list, 0, 1000,"task2");
        Integer invoke2 = fk.invoke(myTask2);
        fk.shutdown();
        System.out.println(invoke2);
    }
    class ForkNode {
        List<ForkNode> childs = new ArrayList<>();
        Integer a;
    }
    @Data
    static class ForkNodeTask extends RecursiveTask<Integer>{
        ForkNode node;

        public ForkNodeTask(ForkNode node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            if (node.childs.isEmpty()) {
                return node.a;
            } else {

            }
            return null;
        }
    }
    @Data
    static class MyTask extends RecursiveTask<Integer> {

        private List<Integer> list;
        private Integer from;
        private Integer to;
        private String name;

        public MyTask(List<Integer> list, Integer from, Integer to,String name) {
            this.list = list;
            this.from = from;
            this.to = to;
            this.name = name;
        }

        @Override
        protected Integer compute() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (to-from<10) {
                Integer integer = list.subList(from, to).stream().reduce((a, b) -> a + b).get();
                System.out.println(name+"=form:"+from+"to:"+to +":sum"+integer);
                return integer;
            } else {
                int middle = (from + to) / 2;
                MyTask leftTask = new MyTask(list, from, middle,name);
                MyTask rightTask = new MyTask(list, middle, to,name);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join()+rightTask.join();
            }
        }
    }

}
