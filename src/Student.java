// Java 类的类名，需与文件名一致 (例如本文件名为 Student.java)

// 第二章 类

//
// 类有如下特性
// 1. 成员，分为变量、静态变量与常量
// 2. 构造器，分为无参构造器与重载构造器
// 3. 方法，分为成员方法与静态方法
// 4. 初始化块，分为对象初始化块与静态初始化块
//
public class Student {
    private String name;
    // 一个私有成员
    // 若构造器没有给他定义，那它默认为 null

    private final int stuID = getStudentNum();
    // 一个私有成员，在创建时给它设了默认值
    // 构造器定义优先于此定义
    // final 关键字会使得该变量在定义之后便无法修改
    // 与 C/C++ const 常量不同，该常量是在声明后的第一次定义后无法修改
    // 可以使用一个非本类成员方法来定义一个成员

    private final String schoolName = "ZSTU";
    // 一个私有成员常量

    private static int studentNum;
    // 一个静态成员，在该类被加载时定义，并不会出现在对象中
    // 与 C/C++ 静态变量概念相似

    // 常量初始化块
    // 在该类被加载时执行
    static{
        studentNum = 0;
    }
    // 另外若类中有 main 方法
    // 运行该类时该初始化块会在 main 方法前先执行

    // 对象初始化块
    // 在一个新的对象被创造时执行
    // 会比构造器先执行
    {
        studentNum ++;
    }

    // 重载构造器，创造对象时针对该对象执行
    public Student(String name){
        this.name = name;
    }

    // 无参构造器，创造对象时针对该对象执行
    public Student(){
        this("");
        // 在一个构造器使用 this(构造器参数) 可以调用另外一个构造器
        // 该方法不能调用自己
    }

    // 静态方法，用类名调用
    // int num = Student.getStudentNum();
    public static int getStudentNum() {
        return studentNum;
    }

    // 成员方法，用对象调用
    // Student stu1 = new Student();
    // String name = stu1.name;
    public String getName() {
        return name;
    }

    public int getStuID() {
        return stuID;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
