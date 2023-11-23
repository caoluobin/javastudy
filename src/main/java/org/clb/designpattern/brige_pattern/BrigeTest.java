package org.clb.designpattern.brige_pattern;

/**
 * @Description
 * @Classname BrigeTest
 * @Date 2021/5/18 14:19
 * @Author clb
 */
public class BrigeTest {

  public static void main(String[] args) {
    Corp corp=new HouseCorp(new HouseProduct());
    corp.make();

    Corp corp1=new AppleCorp(new AppleProduct());
    corp1.make();
    //山寨公司啥都能生产
    Corp corp2=new CopyCorp(new AppleProduct());
    corp2.make();
    Corp corp3=new CopyCorp(new HouseProduct());
    corp3.make();
  }

}
