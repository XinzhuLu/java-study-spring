package space.xinzhu.base.clone;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class Teacher1 implements Cloneable{

    private String name;
    private int age;
    private Student stu;


    public static void main(String[] args) throws CloneNotSupportedException {
        Student stu = new Student("李四", 24);
        Teacher1 tea = new Teacher1("张三", 30, stu);
        //使用重写的的clone方法
        Teacher1 teaClone = (Teacher1) tea.clone();

        System.out.println("tea.equals(teaClone) = " + tea.equals(teaClone));

        /*clone之后改变原对象的数据*/
        //改变stu的数据
        stu.name="李四改";
        //改变tea的数据
        tea.name="张三改";

        //结果被克隆的数据的内部类的stu数据没受到了影响,说明重写的clone方法,实现的是深克隆,tea的对象类型属性stu是指不同对象
        System.out.println(teaClone);
        System.out.println(tea);
        System.out.println("tea.equals(teaClone) = " + tea.equals(teaClone));
    }

    public Teacher1(String name, int age, Student stu) {
        this.name = name;
        this.age = age;
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "Teacher1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stu=" + stu +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        //改写clone方法
        Teacher1 tea = (Teacher1) super.clone();
        //获取属性对象,再clone一次,让后设置到被克隆的对象中,返回
        tea.stu = ((Student) tea.stu.clone());
        return tea;
    }

}
