package demo05;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

/**常用API：
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * Math：
 * 用于数学计算的工具类
 * 私有化构造方法，所有的方法都是静态的
 * 常用方法：
 *      1、abs(int a)：绝对值（如果取值过大，范围中没有与负数对应的正数，则结果有误，使用absExact更安全）
 *      2、ceil(double a)：向上取整
 *      3、floor(double b)：向下取整
 *      4、round(float a)：四舍五入
 *      5、max(int a, int b)：获取较大值（min获取较小值）
 *      6、pow(double a, double b)：返回a的b次幂
 *      7、random()：返回值为double的随机值，范围[0.0, 1.0)
 *      8、sqrt(int a)：开平方
 *      9、cbrt(int a)：开立方
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * System：
 * 系统相关的工具类
 * 常用方法：
 *      1、exit(int status)：终止当前运行的Java虚拟机
 *      2、currentTimeMillis()：返回当前系统的事件毫秒值
 *      3、arraycopy(数据源数组, 起始索引, 目的地数组, 起始索引, 拷贝数量)：数组拷贝
 *          如果都是基本数据类型，必须保持一致
 *          如果都是引用数据类型，可以把子类类型赋给父类类型
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * Runtime（非静态）：
 * 运行环境
 * 常用方法：
 *      1、getRuntime()：静态获取对象
 *      2、exit(int status)：停止虚拟机
 *      3、availableProcessors()：获得CPU线程数
 *      4、maxMemory()：JVM能从系统中获取总内存大小（单位byte）
 *      5、totalMemory()：JVM已经从系统中获取总内存大小（单位byte）
 *      6、freeMemory()：JVM剩余内存大小（单位byte）
 *      7、exec(String command)：运行cmd命令
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * Object and Objects：
 * Object：顶级父类，只有空参构造
 * Object成员方法：
 *      1、toString()：返回对象的字符串表示形式（返回类名 + @ + 地址）（println内部已经调用）（习惯在子类中重写以显示属性值）
 *      2、equals(Object obj)：比较地址是否相等（习惯在子类中重写以比较属性值）
 *      3、clone(int a)：对象克隆（浅克隆，深克隆需要重写方法）
 *          (1) 重写clone方法
 *          (2) 实现Cloneable接口（一个不存在抽象函数的接口Cloneable标记可被克隆）
 *          (3) 创建于原对象并调用clone（需要强转）
 * Objects：工具类
 * Objects方法：
 *      1、equals(Object obj1, Object obj2)：先作非空判断，再比较两个对象
 *      2、isNull(Object obj)：判断是否为空，空true非空false
 *      3、nonNull(Object obj)：与isNull结果相反
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * BigInteger：
 * BigInteger构造方法：
 *      1、BigInteger(int num, Random rnd)：获取随机大整数，范围为[0，2的num次方 - 1)
 *      2、BigInteger(String val)：获取指定的大整数
 *      3、BigInteger(String val, int radix)：获取指定进制的大整数
 *      4、valueOf(long val)：静态方法获取对象，内部对-16~16有优化——已提前创建对象（不能超出long的范围）
 * BigInteger注意：
 *      1、一旦创建，内部值不可改变
 *      2、只要进行计算，都会产生一个新的BigInteger对象
 * BigInteger常用方法：
 *      1、加             add(BigInteger val)
 *      2、减             subtract(BigInteger val)
 *      3、乘             multiply(BigInteger val)
 *      4、除（商）       divide(BigInteger val)
 *      5、除（商和余数） divideAndRemainder(BigInteger val)
 *      6、相同比较      equals(Object x)
 *      7、次幂          pow(int exponent)
 *      8、较大/小值     max/min(BigInteger val)
 *      9、转为int类型   intValue(BigInteger val)
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * BigDecimal：
 * 用于表示很大的整数以及进行小数的精确运算
 * BigInteger构造方法：
 *         1、BigDecimal(double val)：获取大数（不推荐）
 *         2、BigDecimal(String val)：获取大数（推荐）
 *         3、valueOf(double val)：静态方法（数字不超出范围）
 * BigDecimal常用方法：
 *         1、加，减，乘，除相同于BigInteger
 *         2、带精确：divide(BigDecimal val, 精确位数, 舍入模式)
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 正则表达式：
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 */

public class APIs {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        //testMath();//测试Math类
        //testSystem();//测试System
        //testRunTime();//测试Runtime
        //testObject();//测试Object
        //testBigInteger();//测试BigInteger
        testBigDecimal();//测试BigDecimal
    }

    //测试Math类
    public static void testMath() {
        //abs
        System.out.println(Math.abs(-88));
        System.out.println(Math.abs(88));
        System.out.println(Math.abs(-88.55));

        //ceil, floor and round
        System.out.println(Math.ceil(1.2));
        System.out.println(Math.ceil(-1.2));
        System.out.println(Math.floor(1.2));
        System.out.println(Math.floor(-1.2));
        System.out.println(Math.round(1.2));
        System.out.println(Math.round(-1.2));

        //max and min
        System.out.println(Math.max(2000, 15489));
        System.out.println(Math.min(2000, 15489));

        //pow
        System.out.println(Math.pow(2, 10));
        System.out.println(Math.sqrt(16));
        System.out.println(Math.cbrt(512));

        //random
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }
    }

    //测试System
    public static void testSystem() {
        //currentTimeMillis
        System.out.println(System.currentTimeMillis() + "ms");

        //arraycopy
        int[] a1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a2 = new int[10];
        System.arraycopy(a1, 0, a2, 0, 10);
        for (int i:a2) System.out.print(i + " ");

        //exit
        //0：正常停止
        System.exit(0);
        //test
        System.out.println("Oho");
        //1：异常停止
        System.exit(1);
    }

    //测试Runtime
    public static void testRunTime() throws IOException {
        //1、getRuntime()
        Runtime runtime = Runtime.getRuntime();

        //3、availableProcessors()
        System.out.println("CPU线程数 = " + runtime.availableProcessors());

        //4、maxMemory()
        System.out.println("能获取总内存 = " + (runtime.maxMemory() / 1024 / 1024 / 1024 ) + "G");

        //5、totalMemory()
        System.out.println("已获取总内存 = " + (runtime.totalMemory() / 1024 / 1024 ) + "MB");

        //6、freeMemory()
        System.out.println("剩余总内存 = " + (runtime.freeMemory() / 1024 / 1024 ) + "MB");

        //7、exec(String command)
        runtime.exec("notepad");//打开记事本

        //2、exit(int status)
        runtime.exit(0);
    }

    //测试Object
    public static void testObject() throws CloneNotSupportedException {
        Object obj = new Object();
        Students stu1 = new Students();
        Students stu2 = new Students();

        //1、toString()
        String str1 = obj.toString();
        System.out.println(str1);
        String str2 = stu1.toString();
        System.out.println(str2);

        //2、equals(Object obj)
        System.out.println(stu1.equals(stu2));

        //3、clone(int a)
        Students stu3 = new Students("A");
        Students stu4 = (Students)stu3.clone();
        System.out.println(stu3);
        stu3.data[0] = 2;
        System.out.println(stu3);
        System.out.println(stu4);
        //利用第三方工具实现深克隆
        //Gson gson = new Gson();
        //变为字符串
        //String str3 = gson.toJson(stu3);
        //变回对象
        //Students stu4 = gson.fromJson(str3, Students.class);
        //深拷贝完成
        //System.out.println(stu4);
    }

    //测试BigInteger
    public static void testBigInteger() {
        //构造方法
        BigInteger bigInteger1 = new BigInteger(10, new Random());
        System.out.println(bigInteger1);
        BigInteger bigInteger2 = new BigInteger("9999999999999");
        System.out.println(bigInteger2);
        BigInteger bigInteger3 = new BigInteger("1001010111001", 8);
        System.out.println(bigInteger3);
        BigInteger bigInteger4 = BigInteger.valueOf(12222222222222L);
        System.out.println(bigInteger4);

        //运算
        System.out.println("加法：" + bigInteger1.add(bigInteger2));
        System.out.println("减法：" + bigInteger2.subtract(bigInteger1));
        System.out.println("乘法：" + bigInteger1.multiply(bigInteger3));
        System.out.println("除法：" + bigInteger2.divide(bigInteger1));
        System.out.println("除法：" + Arrays.toString(bigInteger2.divideAndRemainder(bigInteger1)));
        System.out.println("相同？" + bigInteger3.equals(bigInteger4));
        System.out.println("次幂" + bigInteger1.pow(4));
        System.out.println("大：" + bigInteger4.max(bigInteger3));
        System.out.println("小：" + bigInteger1.min(bigInteger2));
    }

    //测试BigDecimal
    public static void testBigDecimal() {
        //构造方法
        BigDecimal bigDecimal1 = new BigDecimal(1222.2222);//不推荐
        System.out.println(bigDecimal1);
        BigDecimal bigDecimal2 = new BigDecimal("9999999.99999");
        System.out.println(bigDecimal2);

        //运算
        System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(bigDecimal1.subtract(bigDecimal2));
        System.out.println(bigDecimal1.multiply(bigDecimal2));
        System.out.println(bigDecimal2.divide(bigDecimal1, 4, RoundingMode.HALF_UP));
    }






}
