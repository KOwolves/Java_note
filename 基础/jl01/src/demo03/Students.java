package demo03;

import java.util.Objects;

public class Students extends Person implements Cloneable{
    public String name = "King";

    public Students() {
    }

    public Students(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return Objects.equals(getName(), students.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public Students(String name, int age, String id) {
        super(name, age, id);
    }

    @Override
    public void show() {
        System.out.println("学生信息为：\t\t" + this.getId() + "," + this.getName() + "," + this.getAge());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void cheat() {
        System.out.println(this.getName() + "同学作弊，被予以警告处分！");
    }
}
