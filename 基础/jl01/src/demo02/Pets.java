package demo02;

public class Pets {
    private int age;
    private String name;
    private String owner;

    public Pets() {
    }

    public Pets(int age, String name, String owner) {
        this.age = age;
        this.name = name;
        this.owner = owner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //吃饭
    public void eat() {
        System.out.println("吃饭");
    }

    //喝水
    public void drink() {
        System.out.println("喝水");
    }
}
