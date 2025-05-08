package demo02;

import java.util.Scanner;

public class Practice03API_STRING {
    public static void main(String[] args) {
        //logIn();//用户登录案例
        //transCash();//金额转换
        //shieldPhoneNum();//手机号屏蔽
        //shieldShits();//屏蔽不雅词汇

    }

    //用户登录案例
    public static void logIn() {
        //正确用户名密码
        String userName = "WoHaoShuai";
        String userPasswd = "123456";

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            //用户输入
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String userpasswd = sc.next();

            //判断
            if (username.equals(userName) && userpasswd.equals(userPasswd)) {
                System.out.println("登陆成功！");
                break;
            } else {
                if (i != 2) {
                    System.out.println("登录失败，用户名或密码有误，请重新输入");
                } else {
                    System.out.println("登录失败，用户名或密码有误，请等待一段时间后重新输入");
                }
            }
        }
    }

    //金额转换（七位）
    public static void transCash() {
        //键盘录入金额
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额：");
        int cash = sc.nextInt();
        while (true) {
            if (cash >= 0 && cash <= 9999999) {
                System.out.println("输入成功！");
                break;
            } else {
                System.out.println("别逗我，重新输入：");
                cash = sc.nextInt();
            }
        }

        //大写
        String cashStr = "";

        //得到每一位数字
        while (cash != 0) {
            int temp = cash % 10;
            //大写
            String capitalNum = getCapitalNum(temp);
            cashStr = capitalNum + cashStr;
            cash /= 10;
        }

        //补零
        int difference = 7 - cashStr.length();
        for (int i = 0; i < difference; i++) {
            cashStr = "零" + cashStr;
        }
        //System.out.println(cashStr);

        //插入单位
        String[] units = {"佰", "拾", "万", "仟", "佰", "拾", "元"};

        //结果
        String res = "";

        //轮流遍历
        for (int i = 0; i < 7; i++) {
            res = res + cashStr.charAt(i) + units[i];
        }

        //打印
        System.out.println(res);
   }

    //变成大写数字
    public static String getCapitalNum(int num) {
        // 定义map
        String[] map = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

        //返回结果
        return map[num];
    }

    //手机号屏蔽
    public static void shieldPhoneNum() {
        //获取
        Scanner sc = new Scanner(System.in);
        System.out.println("输入手机号码：");
        String phoneNum = sc.next();
        while (true) {
            if (phoneNum.length() == 11) {
                break;
            } else {
                System.out.println("别逗我，重新输：");
            }
        }

        //前三位
        String phoneFistThree = phoneNum.substring(0,3);
        //后四位
        String phoneLastFour = phoneNum.substring(7);
        //拼接
        String res = phoneFistThree + "****" + phoneLastFour;
        System.out.println(res);
    }

    //屏蔽不雅词汇
    public static void shieldShits() {
        //不雅词汇库
        String[] shits = {"TMD", "CNM", "sb", "SB", "mlgb", "NND", "idiot", "Fuck"};

        //输入
        Scanner sc = new Scanner(System.in);
        System.out.println("Comment");
        String s1 = sc.nextLine();

        //修改
        for (String shit : shits) {
            s1 = s1.replace(shit, "***");
        }

        //输出
        System.out.println(s1);

    }
}
