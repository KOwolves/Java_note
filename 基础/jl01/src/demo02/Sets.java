package demo02;

import java.util.ArrayList;

/**
 * 集合
 * 长度可变的、只能保存引用数据类型（基本数据类型需要包装类）的容器
 * 分成很多类，此处学习ArrayList类型的集合
 * 泛型：限定集合中存储数据的类型(JDK8以后只需要在前面写数据类型，后面写<>不需要写数据类型）
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 成员方法：
 *      1、add(E e)：添加，返回值表示是否添加成功
 *      2、remove(E e)：删除，返回值表示是否添加成功
 *      3、remove(int index)：删除指定索引元素，返回被删除元素
 *      4、set(int index, E e)：修改指定索引下的元素，返回原元素
 *      5、get(int index)：获取指定元素
 *      6、size()：集合长度，即元素个数
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * 对应包装类：将首字母大写（例外：char对应Character，int对应Integer）
 * ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 */

public class Sets {
    public static void main(String[] args) {
        //测试
        ArrayList<String> list01 = new ArrayList<>();

        //增删改查
        list01.add("I love myself!");
        list01.add("I love you!");
        list01.add("I love the whole world!");
        list01.add("I love everything!");
        System.out.println(list01);

        list01.remove(1);
        System.out.println(list01);

        list01.set(2,"I love nothing!");
        System.out.println(list01);

        System.out.println(list01.get(2));

        for (int i = 0; i < list01.size(); i++) {
            System.out.println(list01.get(i));
        }

    }
}
