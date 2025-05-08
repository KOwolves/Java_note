package demo05;

import demo03.Person;

import java.util.Objects;

public class Students extends Person implements Cloneable{
    public String name = "King";
    public int[] data = {0,1,2,3,4};

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
        return this.name + data[0] + data[1] + data[2] + data[3] + data[4];
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        int[] data = this.data;
        int[] newData = new int[data.length];
        System.arraycopy(data, 0, newData, 0, data.length);
        Students cloned = (Students)super.clone();
        //替换地址值
        cloned.data = newData;

        return cloned;
    }
}
