package demo02;

public class Sharpei extends Dogs {
    @Override
    public void eat() {
        super.eat();//直接调用父类
        System.out.println("沙皮狗在啃骨头");
    }
}
