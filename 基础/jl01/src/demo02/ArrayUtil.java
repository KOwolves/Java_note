package demo02;

import java.util.ArrayList;

/**
 * 工具类初识
 */

public class ArrayUtil {
    //私有构造，防止建立多个对象没有意义
    private ArrayUtil(){};

    //方法定义为静态，方便调用

    //遍历数组
    public static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    //平均值
    public static double getAverage(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (double) sum / arr.length;
    }

    //获取集合中学生的最大年龄
    public static int getMaxAgeOfStudentsList(ArrayList<Student> list) {
        //取最大值
        int maxAge = list.get(0).getAge();
        for (int i = 1; i < list.size(); i++) {
            //获取当前索引年龄，变量获取，防止两次调用函数，有利于提高效率
            int ageCurrent = list.get(i).getAge();
            if (ageCurrent > maxAge) {
                maxAge = ageCurrent;
            }
        }

        //返回结果
        return maxAge;
    }
}
