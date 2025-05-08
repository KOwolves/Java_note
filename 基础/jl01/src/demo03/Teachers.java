package demo03;

public class Teachers extends Person{
    public Teachers() {
    }

    public Teachers(String name, int age, String id) {
        super(name, age, id);
    }

    @Override
    public void show() {
        System.out.println("老师信息为：\t\t" + this.getId() + "," + this.getName() + "," + this.getAge());
    }
}
