package com.dyh.test.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;

/**
 * 数学工具类
 * <p>
 * description: dyh
 * author: Administrator
 * date: 2020/11/27 0027 14:03
 */
public class MathUtil {

    /**
     * 计算百分比
     *
     * @param num   被除数
     * @param total 除数
     * @param scale 精确位数
     * @return
     */
    public static String accuracy(double num, double total, int scale) {

        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num / total * 100;

        return df.format(accuracy_num) + "%";
    }


    /**
     * 百分比，兼容转段生比率返回: 0%-""
     *
     * @param num
     * @param total
     * @param scale
     * @return
     */
    public static String accuracy4report(double num, double total, int scale) {

        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        if(0 == total){
            return "";
        }
        double accuracy_num = num / total * 100;
        if(0 == accuracy_num){
            return "";
        }
        return df.format(accuracy_num) + "%";
    }





    /**
     * 计算百分比, 保留n位小数
     *
     * @param num 被除数
     * @param total 除数
     * @param scale 精确位数
     * @return  例：90.36
     */
//    public static BigDecimal accuracyToBigDecimal(BigDecimal num, BigDecimal total, int scale) {
//        return num.multiply(new BigDecimal(GlobalConstant.Number.HUNDRED_INT))
//                .divide(total, scale, BigDecimal.ROUND_HALF_UP);
//    }

    /**
     * 非百分比，保留n位小数
     * @param num
     * @param total
     * @param scale
     * @return  例：0.68
     */
    public static BigDecimal accuracyToBigDecimalNew(BigDecimal num, BigDecimal total, int scale) {
        return num.divide(total, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 将数据转换为保留指定小数位数（0，1，2）格式的数，四舍五入
     */
    public static double formatDigit(double num, int decimalPlace) {
        DecimalFormat fm = null;
        switch (decimalPlace) {
            case 0:
                fm = new DecimalFormat("##");
                break;
            case 1:
                fm = new DecimalFormat("##.#");
                break;
            case 2:
                fm = new DecimalFormat("##.##");
                break;
            case 3:
                fm = new DecimalFormat("##.###");
                break;
            case 4:
                fm = new DecimalFormat("##.####");
                break;
            default:
                break;
        }

        if (fm == null) {
            return num;
        }

        StringBuffer sbf = new StringBuffer();
        fm.format(num, sbf, new FieldPosition(NumberFormat.FRACTION_FIELD));
        return Double.parseDouble(sbf.toString());
    }

    /**
     * 非百分比，保留n位小数
     *
     * @param num   被除数
     * @param total 除数
     * @param scale 精确位数
     * @return
     */
    public static String accuracyToDouble(double num, double total, int scale) {
        if (total == 0){
            return "0";
        }
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num / total;

        return df.format(accuracy_num);
    }

    //标准差σ=sqrt(s^2)
    public static double standardDiviation(double[] x) {
        int m=x.length;
        if(m == 0 || m == 1) {
            return 0;
        }
        double sum=0;
        for(int i=0;i<m;i++){//求和
            sum+=x[i];
        }
        double dAve=sum/m;//求平均值
        double dVar=0;
        for(int i=0;i<m;i++){//求方差
            dVar+=(x[i]-dAve)*(x[i]-dAve);
        }
        //reture Math.sqrt(dVar/(m-1));
        return formatDigit(Math.sqrt(dVar/m), 2);
    }
}
