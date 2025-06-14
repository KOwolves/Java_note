package demo02;

/**面向对象进阶：
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * static（静态）：
 *      1、静态变量：
 *      类的所有对象对应属性共享同一个值，本质上不属于对象，属于类
 *      既可以通过类名调用（推荐），也可以通过对象名调用
 *      随着类的加载而加载，优先于对象出现在内存中，存在于静态区（堆区内）
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 *      2、静态方法：
 *      多用于测试类和工具类之中，很少在Javabean类中
 *      既可以通过类名调用（推荐），也可以通过对象名调用
 *      随着类的加载而加载，优先于对象出现在内存中，存在于静态区（堆区内）
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 工具类：帮助做事情，但是不描述任何事物的类
 *      规则：
 *      1、见名知义
 *      2、私有化构造方法
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 注意：
 *      1、静态方法只能访问静态变量和静态方法
 *      2、非静态方法可访问静态或非静态的成员变量和方法
 *      3、静态方法中没有this关键字
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 继承：
 *      1、关键字extends：public class 子类（派生类） extends 父类 {}
 *      2、好处：提高代码复用性
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 继承特点：只支持单继承，不支持多继承，但是支持多层继承
 *          每一个类都直接或间接的继承于Object
 *          private限定后，其子类无法访问
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 继承内容：1、构造方法子类无法继承
 *          2、成员变量可全部继承，但是不能使用private成员变量
 *          3、成员方法只能继承父类的虚方法
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 继承中：成员变量、成员变量的访问特点 —— 直接调用满足就近原则（谁离得近就用谁）
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * this：理解为一个变量，表示当前方法调用者的地址
 * super：子类中调用父类内容，代表父类存储空间
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 方法重写：当父类的方法不能满足子类现在的需求时，需要进行方法重写
 *     格式：继承体系中，子类出现了和父类一模一样的方法声明
 *          在重写的方法上，需要写上@Override，校验子类重写时语法是否正确
 *     本质：覆盖继承的虚方法表中的同名方法
 *     要求：1、名称、形参列表必须与分类中的一致
 *          2、子类重写父类方法时，访问权限子类必须大于等于父类（空 < protected < public）
 *          3、重写的方法尽量和父类保持一致
 *          4、只有虚方法表中的方法可以被重写
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 继承中：构造方法的访问特点：
 *      1、父类中的构造方法不会被子类继承
 *      2、子类中所有的构造方法默认先访问父类中的无参构造，再执行自己的
 *      2 => 原因：子类初始化时，可能会使用父类中的数据，如果父类没有完成初始化，子类将无法调用父类的数据，
 *                因此，子类初始化之前，一定要调用父类构造方法先完成父类数据空间的初始化
 *      3、子类构造方法中第一行语句默认是super();不写也存在，且必须在第一行
 *      4、调用父类的有参构造需要手动写super进行调用
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 虚方法：非private，非static，非final
 *        生成虚方法表（子类有重写方法时，直接进行覆盖），传递给子类，可以有效提高性能
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 */


public class FaceToObjectAdvance01 {
    public static void main(String[] args) {
        //测试工具类
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        String s1 = ArrayUtil.printArr(arr);
        System.out.println("arr: " + s1);
        System.out.println("The average equals " + ArrayUtil.getAverage(arr));

        //测试学生类相关
        /*
        //学生集合
        ArrayList<Student> listOfStudents = new ArrayList<>();
        //学生对象
        Student stu1 = new Student("张三",18,"男");
        Student stu2 = new Student("李四",19,"女");
        Student stu3 = new Student("王五",22,"男");
        //放入集合
        listOfStudents.add(stu1);
        listOfStudents.add(stu2);
        listOfStudents.add(stu3);
        //返回最大值
        int maxAge = ArrayUtil.getMaxAgeOfStudentsList(listOfStudents);
        System.out.println("The max age of the students is " + maxAge);

         */

        //继承测试
        /*
        Cats cat1 = new Cats();
        cat1.CatchMice();
        cat1.eat();
        Dogs dog1 = new Dogs();
        dog1.home();
        dog1.drink();
        //重写测试
        Husky h1 = new Husky();
        h1.eat();
        h1.drink();
        h1.breakHome();
        Sharpei s1 = new Sharpei();
        s1.eat();
        s1.drink();
        s1.home();
        ChineseDog c1 = new ChineseDog();
        c1.eat();
        c1.drink();
        c1.home();
        */
    }


















}
