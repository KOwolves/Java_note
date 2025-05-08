package demo01;

// 导包
import java.util.Random;
import java.util.Scanner;

public class NewGrammar01 {
    public static void main(String[] args) {
        // 输入
        System.out.println("输入i：");
        Scanner sc=new Scanner(System.in);
        // 接收输入内容，接收整数
        int i=sc.nextInt();
        // 显示结果
        System.out.println("i="+i);

        // 计算时，byte、short、char都被转换为int进行计算
        // 强转：(数据类型)数据
        // +运算符：有字符串为拼接（结果为字符串），无字符串为相加，字符+数时字符为ASCII码值

        // 生成随机数(1~100)
        Random r=new Random();
        int i1=r.nextInt(100)+1;
        System.out.println("随机数为"+i1);

        // 数组静态初始化，中括号也可以写在数组名后面
        int[] arr1 = new int[]{0,1,2,3,4,5};
        // 简写
        int[] arr2={0,1,2,3,4,5};
        // 动态初始化
        int[] arr3=new int[6];
        // 地址值
        //System.out.println(arr1);   //[I@29453f44：[代表是数组，I代表数据类型，@为固定格式分隔，后面的十六进制数为真实的地址
        // 长度属性：数组名.length
        System.out.println("数组长度为"+arr1.length);

        //二维数组
        int[][] arr4 = new int[2][6];
        int[][] arr5 = {{1,2,3,4,5,6},{1,2,3,4,5,6}};
    }
}
