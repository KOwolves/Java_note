package demo03;

public class Dogs_abstract extends Animals_abstract implements Swim{

    public Dogs_abstract() {
    }

    public Dogs_abstract(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "在吃骨头~");
    }

    @Override
    public void swim() {
        System.out.println(this.getName() + "在狗刨~");
    }
}
