package org.clb.designpattern.facade_pattern;

/**
 * @Description
 * @Classname Company
 * @Date 2021/6/10 17:22
 * @Author clb
 */
public class Company {


    public boolean receive(Interviewee interviewee) {
        return hrCheck(interviewee.getCv()) ? (hrInterview(interviewee) ? jsInterview(interviewee) : false) : false;
    }

    private boolean hrCheck(CurriculumVitae cv) {
        System.out.println(cv.getLevel() > 6 ? cv.getName() + "������ͨ��" : cv.getName() + "������ͨ��");
        return cv.getLevel() > 6;
    }

    private boolean hrInterview(Interviewee interviewee) {
        System.out.println(interviewee.getEQlevel() > 6 ? interviewee.getCv().getName() + "��ͨ��hr����" : interviewee.getCv().getName() + "hr���Բ�ͨ��");
        return interviewee.getEQlevel() > 6;
    }

    private boolean jsInterview(Interviewee interviewee) {
        System.out.println(interviewee.getIQlevel() > 6 ? interviewee.getCv().getName() + "��ͨ����������" : interviewee.getCv().getName() + "�������Բ�ͨ��");
        return interviewee.getIQlevel() > 6;
    }
}
