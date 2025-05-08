package demo01;

import java.util.Random;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        PlaneTickets();// 买机票
        FindPrime(100);// 找质数
        GetRandom();// 开发验证码
        CopyArray();//复制数组
        GetScores();//评委打分
        IntEncrypt();//加密
        IntDecode();//解密
        GetPacket();//发红包！
        DoubleColorPrize();//双色球系统
    }

    //交换int数组元素
    public static void SwapIntArr(int[] a, int i1, int i2) {
        int temp = a[i2];
        a[i2] = a[i1];
        a[i1] = temp;
    }

    //数组中是否存在该元素
    public static boolean Contained(int[] a, int elem, int start, int end) {
        if (start < 0) return false;
        if (end >= a.length) return false;
        for (int i=start;i<=end;i++) {
            if (elem == a[i]) {
                return true;
            }
        }
        return false;
    }

    // 买机票
    public static void PlaneTickets(){
        /*要求：
         * 1、旺季（5~10月）头等舱9折，经济舱8.5折
         * 2、淡季（11~次年4月）头等舱7折，经济舱6.5折
         */

        // 键盘输入机票原价、月份、头等舱或经济舱
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价：");
        int ticket = sc.nextInt();
        System.out.println("请输入当前月份：");
        int month = sc.nextInt();
        System.out.println("请输入当前购买的舱位（0：头等舱、1：经济舱）：");
        int seat = sc.nextInt();

        // 舱位分类
        double ticket_head = 0;
        double ticket_econ = 0;

        // 判断淡季/旺季
        if(month >= 5 && month <= 10) {
            ticket_head = ticket*0.9;
            ticket_econ = ticket*0.85;
        } else if((month >= 1 && month <= 4)||(month >= 11 && month <= 12)) {
            ticket_head = ticket*0.7;
            ticket_econ = ticket*0.65;
        } else {
            System.out.println("月份输入不合法！");
        }

        // 判断舱位
        switch (seat) {
            case 0:
                System.out.println("您需要支付的机票费用为：" + String.format("%.2f",ticket_head) + "元");
                break;
            case 1:
                System.out.println("您需要支付的机票费用为：" + String.format("%.2f",ticket_econ) + "元");
                break;
            default:
                System.out.println("你难道坐在飞机外面吗？");
        }
    }

    // 找质数
    public static void FindPrime(int n) {
        int cnt = 0;// 质数个数
        System.out.print("小于" + n + "的质数包含：");
        for(int i = 2;i <= n;i++) {
            if(isPrime(i)) {
                cnt++;
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 判断质数
    public static boolean isPrime(int n) {
        for(int i=2;i*i<=n;i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 开发验证码
    public static void GetRandom() {
        // 待抽取字母数组
        char[] letters=new char[52];
        for(int i=0;i<letters.length;i++) {
            if(i <= 25) {
                letters[i] = (char) ('A' + i);
            } else {
                letters[i] = (char) ('a' + i - 26);
            }
        }

        // 生成随机码
        StringBuilder code = new StringBuilder();
        for(int i=0;i<5;i++) {
            Random r = new Random();
            if(i <= 3) {//前四位
                int index = r.nextInt(52);
                code.append(letters[index]);
            } else {//第五位
                int rand = r.nextInt(10);
                code.append((char) (rand + '0'));
            }
        }

        //输出随机码
        System.out.println(code);
    }

    // 复制数组
    public static void CopyArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};//原数组
        int[] arr2 = new int[arr1.length];//新数组

        // 复制
        for(int i=0;i<arr1.length;i++) {
            arr2[i] = arr1[i];
        }
        //System.arraycopy(arr1, 0, arr2, 0, arr1.length);

        // 输出原数组
        System.out.print("原数组：");
        for (int j : arr1) {
            System.out.print(j + " ");
        }
        System.out.println();

        // 输出新数组
        System.out.print("新数组：");
        for (int j : arr2) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // 评委打分
    public static void GetScores() {
        int[] scores = new int[6];// 6位评委
        int sum = 0;//和

        // 输入+求和
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第1位评委打分：");
        for(int i=0;i<scores.length;) {
            int score = sc.nextInt();
            if(score >= 0 && score <= 100) {// 合法成绩
                scores[i++] = score;
                sum += score;//求和
                if(i!=6) {// 最后一位成功输入，不需要再输入
                    System.out.println("请输入第" + (i+1) +"位评委打分：");
                }
            } else {// 不合法成绩输入
                System.out.println("输入成绩不合法，请重新输入：");
            }
        }

        // 最大值
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        // 最小值
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        // 最终得分
        double average = (double) (sum - max - min) / (scores.length - 2);

        System.out.println("选手最终得分为：" + String.format("%.2f", average) + "分");
    }

    // 数字加密
    public static void IntEncrypt() {
        // 6位数字，每位数加5，再对10求余，并将数字反转，得到密文

        //输入
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr_num = new int[6];
        for(int i=0;i<6;i++) {
            arr_num[i] = num % 10 + 5;//加密1
            if(arr_num[i] >= 10) {
                arr_num[i] %= 10;// 加密2
            }
            num /=10;
        }

        // 生成密文
        int code = 0;
        for(int i=0;i<6;i++) {
            code = code * 10 + arr_num[i];
        }
        System.out.println(code);

    }

    // 数字解密
    public static void IntDecode() {
        //输入
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr_num = new int[6];
        for(int i=0;i<6;i++) {
            arr_num[i] = num % 10;
            if(arr_num[i] <= 4) {// 解密
                arr_num[i] += 5;
            } else {
                arr_num[i] -= 5;
            }
            num /= 10;
        }

        // 生成明文
        int text = 0;
        for(int i=0;i<6;i++) {
            text = text * 10 + arr_num[i];
        }
        System.out.println(text);
    }

    //抽红包
    public static void GetPacket() {
        // 红包数组
        int[] packets = {688,2888,1888,88,188,288,388,888};

        // 随机打乱
        Random r = new Random();
        for(int i = 0; i < packets.length;i++) {
            int index = r.nextInt(packets.length);
            SwapIntArr(packets,i,index);
        }

        for (int packet : packets) {
            System.out.println(packet + "元红包已被抽出！");
        }
    }

    // 双色球系统
    public static void DoubleColorPrize() {
        // 投注号码由6个红球和一个蓝球号码组成，红球1~33，蓝球1~16，中奖不需要顺序相同

        int[] arr = new int[7];//中奖号码
        Scanner sc = new Scanner(System.in);

        //随机生成中奖号码
        Random r = new Random();
        for (int i = 0; i < 6;) {//红球
            int red =  r.nextInt(33) + 1;
            if(!Contained(arr, red, 0, arr.length-1)) {
                arr[i] = red;
                i++;
            }
        }
        arr[6] = r.nextInt(16) + 1;//蓝球



        //用户输入彩票号码
        int[] uarr = new int[7];//用户号码
        for(int i=0;i<6;) {//红球
            System.out.println("请输入第" + (i + 1) + "红球号码进行查询：");
            int rednum = sc.nextInt();
            if(!Contained(uarr, rednum,0,arr.length-1)) {
                uarr[i] = rednum;
                i++;
            } else {
                System.out.println("输入重复，请重新输入");
            }
        }

        System.out.println("请输入蓝球号码进行查询：");
        uarr[6] = sc.nextInt();//蓝球

        //验证
        int redcount = 0;
        boolean bluecount = false;
        //红球
        for (int i=0;i<uarr.length-1;i++) {
            if (Contained(arr, uarr[i], 0, arr.length-2)) {
                redcount++;
            }
        }
        if (arr[6] == uarr[6])bluecount = true;//蓝球

        //发奖
        if (bluecount) {
            switch (redcount) {
                case 0:
                case 1:
                case 2:
                    System.out.println("您中奖了！获得5元奖励！");
                    break;
                case 3:
                    System.out.println("您中奖了！获得10元奖励！");
                    break;
                case 4:
                    System.out.println("您中奖了！获得200元奖励！");
                    break;
                case 5:
                    System.out.println("您中奖了！获得3000元奖励！");
                    break;
                case 6:
                    System.out.println("您中大奖了！获得1000万元奖励！");
                    break;
            }
        } else {
            switch (redcount) {
                case 0:
                case 1:
                case 2:
                case 3:
                    System.out.println("很遗憾，您未中奖！");
                    break;
                case 4:
                    System.out.println("您中奖了！获得10元奖励！");
                    break;
                case 5:
                    System.out.println("您中奖了！获得200元奖励！");
                    break;
                case 6:
                    System.out.println("您中奖了！获得500万元奖励！");
                    break;
            }
        }

    }

}
