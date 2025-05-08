package demo03;

public abstract class Animals_abstract {
    private String name;
    private int age;

    public Animals_abstract() {
    }

    public Animals_abstract(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //喝水
    public void drink() {
        System.out.println(this.name + "在喝水~");
    }

    //吃（抽象方法）
    public abstract void eat();

}
