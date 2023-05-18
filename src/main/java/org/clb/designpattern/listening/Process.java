package org.clb.designpattern.listening;

import lombok.Data;

@Data
public class Process {
    private HookService hookService;

    public void process(Object obj) {
        new Thread(()->{
            try {
                System.out.println("ִ��ҵ���߼�");
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
                System.out.println("�ɹ�ִ��");
            }

            @Override
            public void fail(Object obj) {
                System.out.println("ʧ��ִ��");
            }
        });
        process.process(null);
    }
}
