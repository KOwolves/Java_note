package demo03;

public class Frogs_abstract extends Animals_abstract implements Swim{

    public Frogs_abstract() {
    }

    public Frogs_abstract(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "在吃虫子~");
    }

    @Override
    public void swim() {
        System.out.println(this.getName() + "在蛙泳~");
    }
}
