package org.clb.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import org.clb.util.excel.data.HWDeal;

import java.util.List;

public class DemoDataListener implements ReadListener<HWDeal> {

    /**
     * ÿ��5���洢���ݿ⣬ʵ��ʹ���п���100����Ȼ������list �������ڴ����
     */
    private static final int BATCH_COUNT = 100;
    /**
     * ���������
     */
    private List<HWDeal> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * ���������һ��DAO����Ȼ��ҵ���߼����Ҳ������һ��service����Ȼ������ô洢�������û�á�
     */
    private HWDeal demoDAO;

    public DemoDataListener() {
        // ������demo���������newһ����ʵ��ʹ���������spring,��ʹ��������вι��캯��
        demoDAO = new HWDeal();
    }

    /**
     * ���ʹ����spring,��ʹ��������췽����ÿ�δ���Listener��ʱ����Ҫ��spring������ഫ����
     *
     * @param demoDAO
     */
    public DemoDataListener(HWDeal demoDAO) {
        this.demoDAO = demoDAO;
    }

    /**
     * ���ÿһ�����ݽ�������������
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(HWDeal data, AnalysisContext context) {
        cachedDataList.add(data);
        // �ﵽBATCH_COUNT�ˣ���Ҫȥ�洢һ�����ݿ⣬��ֹ���ݼ������������ڴ棬����OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // �洢������� list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * �������ݽ�������� ����������
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        String a = "E:\\����";
    }

    /**
     * ���ϴ洢���ݿ�
     */
    private void saveData() {

    }

}
