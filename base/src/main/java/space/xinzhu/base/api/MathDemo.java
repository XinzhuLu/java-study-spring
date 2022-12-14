package space.xinzhu.base.api;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class MathDemo {
    public static void main(String[] args) {

        System.out.println("Math::abs(-2) = " + Math.abs(-2));
        System.out.println("Math::ceil(-1.4) = " + Math.ceil(-1.4));//向上走
        System.out.println("Math::ceil(1.4) = " + Math.ceil(1.4));
        System.out.println("Math::floor(-1.4) = " + Math.floor(-1.4));//向下走
        System.out.println("Math::floor(1.4) = " + Math.floor(1.4));
        System.out.println("Math::round(-1.4) = " + Math.round(-1.4));
        System.out.println("Math::round(1.4) = " + Math.round(1.4));//四舍五入
        System.out.println("Math::max(1,-2.0) = " + Math.max(1,-2.0));
        System.out.println("Math::min(1L,2L) = " + Math.min(1L,2L));
        System.out.println("Math::pow(8,3) = " + Math.pow(8,3));
        System.out.println("Math::random() = " + Math.random());

        //Math::abs(-2) = 2
        //Math::ceil(-1.4) = -1.0
        //Math::ceil(1.4) = 2.0
        //Math::floor(-1.4) = -2.0
        //Math::floor(1.4) = 1.0
        //Math::round(-1.4) = -1
        //Math::round(1.4) = 1
        //Math::max(1,-2.0) = 1.0
        //Math::min(1L,2L) = 1
        //Math::pow(8,3) = 512.0
        //Math::random() = 0.9084724444035267

        //保留小数点后几位
        double num = 3.555555f;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(num).getClass());
        System.out.println(df.format(num));
        // Double.parseDouble将String类型的数据转换为Double类型
        num = Double.parseDouble(df.format(num));

    }
}
