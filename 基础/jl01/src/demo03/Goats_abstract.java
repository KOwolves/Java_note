package demo03;

public class Goats_abstract extends Animals_abstract{
    public Goats_abstract() {
    }

    public Goats_abstract(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "在吃草~");
    }
}
