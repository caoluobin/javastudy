package org.clb.designpattern.listening;

import lombok.Data;

@Data
public class Process {
    private HookService hookService;

    public void process(Object obj) {
        new Thread(()->{
            try {
                System.out.println("执行业务逻辑");
                hookService.success(obj);
            } catch (Exception e) {
                hookService.fail(obj);
            }
        }).start();
    }

    public static void main(String[] args) {
        Process process = new Process();
        process.setHookService(new HookService() {
            @Override
            public void success(Object obj) {
                System.out.println("成功执行");
            }

            @Override
            public void fail(Object obj) {
                System.out.println("失败执行");
            }
        });
        process.process(null);
    }
}
