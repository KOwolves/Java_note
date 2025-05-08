package demo03;

public class Rabbits_abstract extends Animals_abstract{

    public Rabbits_abstract() {
    }

    public Rabbits_abstract(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "在吃胡萝卜~");
    }
}
