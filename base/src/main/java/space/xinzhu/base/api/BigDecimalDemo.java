package space.xinzhu.base.api;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class BigDecimalDemo {

    public static void main(String[] args) {
        float num1 = 0.333333f;
        float num2 = 0.333333f;
        System.out.println(num1+num2);
        System.out.println(num1*3);

        BigDecimal bnum1 = new BigDecimal(0.333333 );
        System.out.println(bnum1.add(new BigDecimal(0.333333)));
        System.out.println(bnum1.subtract(new BigDecimal(0.1)));
        System.out.println(bnum1.multiply(new BigDecimal(3.0)));
        System.out.println(bnum1.divide(new BigDecimal(0.333333), 2 , BigDecimal.ROUND_UP));
        //BigDecimal divide = bd1.divide(参与运算的对象,小数点后精确到多少位,舍入模式);
        //参数1 ，表示参与运算的BigDecimal 对象。
        //参数2 ，表示小数点后面精确到多少位
        //参数3 ，舍入模式
        //BigDecimal.ROUND_UP  进一法
        //BigDecimal.ROUND_FLOOR 去尾法
        //BigDecimal.ROUND_HALF_UP 四舍五入

        //)得出的结果可能有点不可预测，这是因为double的本身并不精准导致的,解决方案是使用字符串入参构造
        BigDecimal bnum2 = new BigDecimal("0.33333" );
        MathContext mc = new MathContext(3 , RoundingMode.HALF_UP);
        System.out.println(bnum2.multiply(new BigDecimal("2.0")  , mc ));
    }
}
