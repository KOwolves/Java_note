package demo02;

public class Dogs extends Pets {
    public Dogs() {
        super();//默认存在，无需手写
    }

    public Dogs(int age, String name, String owner) {
        super(age, name, owner);
    }

    public void home() {
        System.out.println("狗在看家");
    }

    @Override
    public void drink() {
        System.out.println("狗在喝水");
    }

    @Override
    public void eat() {
        System.out.println("吃狗粮");
    }


}
