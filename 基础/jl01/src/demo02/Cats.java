package demo02;

public class Cats extends Pets {

    public Cats() {
    }

    public Cats(int age, String name, String owner) {
        super(age, name, owner);
    }

    public void CatchMice() {
        System.out.println("猫抓老鼠");
    }
}
