package demo04;

public class Outer {
    private String name;
    private int a = 10;

    public Outer() {}

    public Outer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //创建内部类对象方法2
    public Inner01 getInner() {
        return new Inner01();
    }


    //成员内部类
    protected class Inner01 {
        private int a = 20;

        public void show() {
            int a = 30;

            System.out.println(a);//30
            System.out.println(this.a);//20
            System.out.println(Outer.this.a);//10
        }
    }


    //静态内部类
    public static class Inner02 {
        public void show1() {
            System.out.println("非静态方法");
        }

        public static void show2() {
            System.out.println("静态方法");
        }
    }

    //局部内部类
    public void Inner03() {
        final class Inner {
            public void show() {
                System.out.println("局部内部类内部的方法");
            }
        }

        Inner in = new Inner();
        in.show();
    }

    //匿名内部类
    //接口
    public void Inner04() {
        new Show() {
            @Override
            public void showName() {
                System.out.println("匿名内部类中重写了展示名字的方法");
            }
        }.showName();
    }

    //类
    public void Inner05(Lab lab) {
        lab.lab();
    }

}
