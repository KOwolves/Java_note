package demo03;

public class Administrators extends Person{
    public Administrators() {
    }

    public Administrators(String name, int age, String id) {
        super(name, age, id);
    }

    @Override
    public void show() {
        System.out.println("管理员信息为：\t" + this.getId() + "," + this.getName() + "," + this.getAge());
    }
}
