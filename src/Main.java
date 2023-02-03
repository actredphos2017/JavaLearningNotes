// 《Java 核心技术》笔记

import java.io.*;
import java.math.BigInteger;
import java.util.*;

// Java 类的类名，需与文件名一致 (例如本文件名为 Main.java)
public class Main {
    // 主方法必须为 public static void 类型，必须要有 String[] args 参数，名字必须要为 main
    // 初学者不需要去理解各个字段的意义
    public static void main(String[] args) {
        //调用 System 类的 out 对象的 println 方法 向控制台打印内容，初学者不需要去理解
        System.out.println("We will not use 'Hello World'!");

        basicClassTest();
        StringTest();
        StringBuilderTest();
        PrintStreamTest();
        ScannerTest();
        BlockTest();
        IfTest();
        bigIntegerTest();
        arrayTest();

    }

    // Java 基础
    //
    // 1.三个文件类型
    // .java .class .jar
    //
    // .java 为 java 源码程序，例如此文件就是一个 java 源码
    //
    // .class 为以字节码形式存在的一个类，如果里面存在 main 函数，便可以直接在 JVM 内执行
    //
    // .jar 为 java 编译后字节码的一个包文件，里面包含了一系列类以及所需的资源
    // 如果内部存在程序入口，可以直接在 JVM 内执行
    // 也可作为外部库使用，放入项目目录下的 lib 目录里，然后在 IDE 内设置导入该类的源
    // 之后就可以在项目中随意使用该类了
    //
    // 2.三个环境
    //
    // *** JDK 包含 JRE 包含 JVM ***
    //
    // JVM 全称 Java Virtual Machine ，即 Java 虚拟机，是一个引擎
    // 能将 Java 字节码文件转换为系统能识别并执行的二进制文件
    //
    // JRE 全程 Java Runtime Environment ， 即 Java 运行时环境，包含库、类加载器和 JVM
    //
    // JDK 全程 Java Development Kit, 即 Java 开发工具包，包含 JRE 、跨平台软件开发环境
    //
    // 如果你只是想运行 Java 程序，只需要 JRE ，如果你是 Java 软件开发者，需要的是 JDK
    // 一台电脑上能同时安装多个版本的 JDK 、 JRE ，大多是 Java IDE 可以选择不同版本 JDK 进行编译
    // 运行一个 Java 程序既可以使用 JRE 也可以使用 JDK 。
    // 一台电脑上同时安装相同版本的 JRE 和 JDK 时， JRE 有可能是冗余的。
    //
    // Java 的函数称为方法

    // Java 的类 (重要)
    public static void basicClassTest(){

        // Java 的类型判断标准
        // 一般来说 类似于 int char boolean double 这样的以小写字母开头的类为基础类型
        // 他们本身就是对象，不存在引用
        //
        // 例：

        int num1 = 1;
        int num2 = num1;
        num2 = 2;   // 此时 num2 变成了 2，但 num1 还是 1
        System.out.println("num1 的值为 " + num1);
        System.out.println("num2 的值为 " + num2);

        // 而一般类似于 String Vector Array 等以大写字母开头的类为自定类
        //
        //  *** 以自定类为类型声明的变量只是一个对象的引用 ***
        //  *** 以自定类为类型声明的变量只是一个对象的引用 ***
        //  *** 以自定类为类型声明的变量只是一个对象的引用 ***
        //
        // 如果不清楚这句话意味着什么，请见以下范例
        //
        // 自定义类引用的声明方法
        // AClass object;        // 注意：与 C/C++ 不同， object 变量并不是对象，而是 AClass 类的引用
        // 由于生成了引用但没有引用任何对象，因此 object 的值此时获得初始值 null
        //
        // 用 new 关键字可以生成类的对象
        // new AClass(构造器参数...);     // 这里实质上创造了一个匿名对象
        // 注意这个语句其实并不准确，因为它是在野生范围内生成的一个对象，这个对象并没有传入一个方法，也没有引用
        // 因此刚创建完这个对象，这个对象立刻就会被回收
        // Java 独特的内存管理机制中，凡是断开所有引用的对象都会被直接回收
        // 可以把 new 看成一个生成对象的方法
        //
        // 如果将类的引用与类的对象连接起来
        // object = new AClass(构造器参数...);
        // 这样 object 就完成了一个对象的引用
        // 之后便可以通过 object 来操作这个对象了
        //
        // 最好在声明时就要给他们初始化，若不赋值他们为 null
        // AClass object = new AClass(构造器参数...);
        //
        // 另外也会存在一个对象连接多个引用的情况
        //
        // 例：
        // （MyInt 是一个虚构的自定义动态类）
        //
        // MyInt num1;              // 此时 num1 为 null;
        // num1 = new MyInt(1);     // new 关键字初始化，被赋予了一个 MyInt 类的对象
        // MyInt num2 = num1;       // 新建了一个 num2 ，与 num1 引用一样的对象
        // num2.setNum(2);          // 此时 num2 变成了 2， num1 也变成了 2
        //
        // 由于 num1 与 num2 都引用相同的对象，因此 num1 的值也会跟着变
        //
        // 在实际设计自定义类型时，最好也设为大写开头以方便辨认

        // Java 的基本类

        boolean bool = true;
        // boolean 类，存放 true 和 false，与 C/C++ 的 bool 一致
        // 包装类：Boolean

        byte byteNum = 127;
        // byte 类，占用 1字节 8Bits
        // 包装类：Byte

        short shortNum = 15;
        // short 类，占用 2字节 16位
        // 包装类：Short

        int intNum = 1;
        // int 类，整形，无论是在16位、32位还是64位处理器上都是占用 4字节 32Bits
        // 包装类：Integer

        long longNum = 114514;
        // long 类，长整形，无论是在16位、32位还是64位处理器上都是占用 8字节 64Bits
        // 包装类：Long

        float floatNum = 11.45f;
        // float 类，浮点型，无论是在16位、32位还是64位处理器上都是占用 4字节 32Bits
        // 包装类：Float
        // 需要注意的是赋值时的数字必须在后面加上 'f' 或者 'F' 来声明其为 float 型，否则编译器会认为它是 double 型


        double doubleNum = 11.45;
        // double 类，浮点型，无论是在16位、32位还是64位处理器上都是占用 8字节 64Bits
        // 包装类：Double

        char c = 'd';
        // char 类，字符型，占用 2字节 16位
        // 包装类：Character

        enum Size{SMALL, MIDDLE, BIG};
        Size size = Size.SMALL;
        // enum 类，枚举类
        // 包装类：Enum

        // 学有余力：
        //  还记得 C/C++ 中的 auto 自动推断变量类型吗？
        //  java 的 var 也支持这样的功能，并且实际的能力会比 C/C++ 强大很多
        var str = "Hello Var!";
        var aChar = 'a';
        var aInt = 16;
        var aDouble = 11.4514;
        var vec = new Vector<Integer>();
        vec.add(1);
        vec.add(2);
        vec.add(3);
        for(var i : vec)
            System.out.println(i);
    }

    // * 注意： Java 并不支持运算符的重载
    // * 这意味着不能像编写 C++ 程序那样自定义 + - * / 等运算符功能
    // * Java 确实给 String 提供了 + 号的字符串拼接功能，但没有为其他运算符重载
    // * 但除 String 与一些基本类之外别的类基本不能使用运算符

    // Java字符串类 java.lang.String
    public static void StringTest(){

        // String 为一个静态类，用于存放一串静态字符串
        //
        // 本质上为一组存储的 char 类型数组，但封装了很多有用的方法
        // 对于 String 数组下标的概念与 C/C++ 是一致的，下标实际上指在字符与字符之间
        //
        // 例如对于字符串
        String str = "abcdef";
        // 下标 0 指在 a 的前面， d 与 e 之间的下标为 4
        //
        // 下标  0   1   2   3   4   5
        // 字符  ^ a ^ b ^ c ^ d ^ e ^ f
        //
        // 在获取字符时获取到的是下标之后的一个字符
        char c1 = str.charAt(2);
        System.out.println("字符c1：" + c1);
        // c1 得到的值是 'c'
        //
        // 在进行字符串截取方法(substring)时，截取到的是两个下标之间的字符串
        String substr = str.substring(3, 5);
        System.out.println("字符串substr：" + substr);
        // substr 得到的值是 "de"
        //
        //
        // 另外，String 默认以 UTF-16 编码
        // 由于现代字符发展以发展到 UTF-32 ，因此 Java 引入了码点的概念
        // 处在 UTF-16 内的部分字符，每个字符只占用一个字符单元
        // 而处在 UTF-16 外 UTF-32 内的字符，每个字符占用两个字符单元
        // 例如下面例子中 "你好" 前面的 𝕆 对应码点为 U-1D546 (0x1D546)
        // 它实际占用两个字符单元 0xD835 0xDD46 ，这两个字符单元对应的字符与 𝕆 无关
        //

        String str1 = "\uD835\uDD46你好";
        String str2 = "abcDEFabc";
        System.out.println("字符串1：" + str1);

        System.out.println("字符串长度：" + str1.length());
        // length() 返回该字符串的单元个数，超出 UTF-16 的部分需要两个代码单元进行存储
        // 因此该方法可能不能获取到确切的字符串长度

        System.out.println("字符串码点：" + Arrays.toString(str1.codePoints().toArray()));
        // codePoints() 返回该字符串的码点迭代器 IntStream
        // 其内置的 toArray() 方法可将其转换为 int[] 数组
        // Arrays.toString() 方法会在稍后介绍


        System.out.println();
        System.out.println("字符串2：" + str2);

        System.out.println("第2个字符：" + str2.charAt(1));
        // charAt(int) 返回的是对应下标后紧跟着的字符单元
        // 但依旧需要考虑 UTF-16 以上占用两个字符单元的问题

        System.out.println("大写字符串：" + str2.toUpperCase());
        // toUpperCase() 返回一个将小写字母全部转换为大写字母的字符串

        System.out.println("小写字符串：" + str2.toLowerCase());
        // toLowerCase() 返回一个将大写字母全部转换为小写字母的字符串

        System.out.println("由abc开始：" + str2.startsWith("abc"));
        // startsWith(String) 返回的是一个 boolean 类型
        // 判断是否由指定字符串开头

        System.out.println("由DEF结束：" + str2.endsWith("DEF"));
        // startsWith(String) 返回的是一个 boolean 类型
        // 判断是否由指定字符串结尾

        System.out.println("第一个的b索引：" + str2.indexOf("b"));
        // indexOf(String) 或 indexOf(char/int(码点))
        // 返回第一个找到指定内容的位置的下标

        System.out.println("最后一个的b索引：" + str2.lastIndexOf("b"));
        // indexOf(String) 或 indexOf(char/int(码点))
        // 返回最后一个找到指定内容的位置的下标

        System.out.println("将a替换为b：" + str2.replace('a', 'b'));
        // replace(char, char)
        // 返回一个将某个字符全部改为另一个字符的字符串

        System.out.println("重复字符串3次：" + str2.repeat(3));
        // repeat(int)
        // 返回一个重复该字符串多次的新字符串

        // Tips:
        //
        // 1.
        // 不用于 C/C++， Java的字符串在赋值之后便为静态类型
        // 因此不能用类似 char c = str[3] 的方法来获取对应位置的字符
        // 也不能用 str[3] = 'a' 的方法来进行修改
        //
        // 如果想要获取 str[3] 需要使用以下方法
        // char c = str.charAt(3)
        //
        // 如果想要实现 str[3] = 'a'
        // 需要使用字符串拼接的方法进行处理
        // 即 str = str.substring(0,3) + 'a' + str.substring(4,str.length())
        //
        // 2.
        // String 为一个类，它的对象与基本类型有很大不同，它是一个对象的引用
        // 因此会存在一个对象的值 null 的情况，因此需要对于不确定的 String 对象进行判断
        // 对于 str1 = str2 只是将 str2 的地址赋给 str1 ，并不会分配新的空间占用
        // 由于 String 是一个静态类，这本身并不会存在很大的问题
        //
        
        //  在 API 注释中有一些 CharSequence 类的参数，实际上这是一种接口类型
        //  现在只需要知道完全可以使用 String 类 作为 CharSequence 类传参
    }


    // 字符串构建器 java.lang.StringBuilder
    public static void StringBuilderTest(){
        //
        // StringBuilder 是一个动态类，用于方便地构建字符串
        //

        StringBuilder builder = new StringBuilder(); //创建一个 StringBuilder 对象
        builder.append('a');
        builder.append("bc");
        // append(String/char) 在尾部添加字符串或者字符单元

        builder.appendCodePoint(0x1D546);
        // appendCodePoint(int) 在尾部添加码点

        builder.setCharAt(1, 'B');
        // setCharAt(int, char) 修改对应下标的字符

        builder.insert(3, "DeF");
        // insert(int, String/char/int(码点)) 在对应位置插入字符串或字符

        System.out.println("字符串长度：" + builder.length());
        // length() 返回字符串长度

        System.out.println("字符串：" + builder.toString());
        // toString() 返回字符串

        
        // 注意：由于 StringBuilder 为动态自定义类，这就意味着存在多个对象引用同一个对象的情况
        // 例如以下代码：

        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = builder1;

        builder1.append("'我是在 builder1 对象上添加的' ");
        builder2.append("'我是在 builder2 对象上添加的' ");

        System.out.println("此时 builder1 上的内容为 " + builder1.toString());
        System.out.println("此时 builder2 上的内容为 " + builder2.toString());

        // 代码的输出结果如下：
        // 此时 builder1 上的内容为 '我是在 builder1 对象上添加的' '我是在 builder2 对象上添加的'
        // 此时 builder2 上的内容为 '我是在 builder1 对象上添加的' '我是在 builder2 对象上添加的'
        // 由于这两个变量是同一个对象的引用，因此这两个变量是等价的

        // 学有余力：
        //  StringBuilder 类是从 Java 5 版本后被引入的
        //  它的前身是 StringBuffer 类，允许采用多线程进行添加与删除，但效率偏低
    }


    // 标准输出流 java.io.PrintStream out
    public static void PrintStreamTest(){
        //
        // 关于 Java io 流的概念是一个目前可能还难以理解的概念
        // 但是我们在前面的学习中已经接触到了比较常用的 PrintStream 对象 System.out
        // 这就是一个典型的输出流，用于向终端输出字符串
        //

        PrintStream cout = System.out; //这里把它命名为 cout 没有别的意思……

        cout.println("Hello world!");
        // println() 用于向流中输入内容，支持所有基本类和部分自定类，并在结尾加上一个回车

        cout.print("Hello world");
        // print() 用于向流中输入内容，支持所有基本类和部分自定类，但在结尾不会加回车
        // 以上代码输出后下一次输出内容会紧跟在 world 后面

        cout.printf("The number is %d\n", 12);
        // printf(String, Object...) 与 C语言 中的 printf 方法功能是一致的

        cout.append("Hello world\n");
        // append() 与 print() 功能类似
    }


    // 输入流扫描器 java.util.Scanner 与标准输入流 java.io.InputStream in
    public static void ScannerTest(){
        //
        // 注意： Scanner 类并不会默认集成在 java 代码中，需要在类外声明引入
        //
        // import java.util.Scanner;    // 只引入 Scanner
        // import java.util.*;          // 引入 java.util 包内的所有类
        //
        // import 有点类似于 C/C++ 的 #include 但两者存在一些区别
        //
        // Scanner 的构造方法为 Scanner(InputStream) 需要一个输入流作为参数
        //
        // 与 C/C++ 一样，Java的输入与输出也是流形式的
        // 但两者对流的处理方法有些许不同
        // 下面代码将演示如何使用 Scanner 类从标准输入流（终端）读取信息
        //
        //
        //
        Scanner in = new Scanner(System.in);
        String resStr = in.nextLine();
        System.out.println(resStr);
        //
        // 该代码作用是将用户输入的内容重新输出出来
        //
        // 代码中传入 Scanner 构造方法的参数 System.in 与上一节中的 System.out 相反
        // 它是一个标准输入流，输入源来自终端
        // System.out 与 System.in 就像 C/C++ 的 cout 与 cin 一样，是一个 java 本身提供的流方法
        //
        // 上面代码片段中的 nextLine() 方法会读取整一行，包括空格
        // 而如果使用 next() 方法便会在读取到的第一个空格处停下
        //
        // ** 为了方便程序运行，以下的方法仅做解释，不会嵌入到代码里 **
        //
        // Boolean bo = in.nextBoolean();
        // System.out.println(bo);
        //
        // nextBoolean() 方法会读取到下一个 boolean 类型输入
        // 值得注意的是，它能读取到的传入不是 0 和 1 ，而是 false 和 true
        // 而有意思的是，这个 false 与 true 是大小写不严判的
        // 例如传入 FALSE 或者 TrUe 都是能够被正确识别出来的
        //
        //
        // int num1 = in.nextInt();
        // System.out.println(num1);
        //
        // nextInt() 方法会读取到下一个 int 类型输入
        // nextDouble() 方法会读取到下一个 double 类型输入
        // nextByte() nextShort() nextLong() nextFloat() 等也是类似
        //
        // boolean notFinished = in.hasNext();
        // hasNext() 方法会判断之后是否会有其他内容
        // hasNextInt() hasNextDouble() 等用于判断是否还存在下一个数字

        // 学有余力：
        //  Scanner 读取的输入流在终端上是可见的，因此它对密码类型的输入是无能为力的。
        // 如果想让输入不可见，可以试试 Console 类
        //
        // Console cons = System.console();
        // char[] password = cons.readPassword("请输入密码：");
        //
        // 但使用该类的前提是程序需运行在一个真正的终端，而不是类似于 JetBrains IDEA 或者 Visual Studio Code 那样的内嵌终端里
        // 如果使用内嵌终端， System.console() 很可能会返回一个 null 值
        //
        // Console 处理其他类型的输入是不方便的，因为它只具有 readLine() 这一种读取一行的方法
        //

    }


    // 块作用域 (概念)
    public static void BlockTest(){
        // 每一个大括号所包含的范围称为一个 块(block)
        // 与 C/C++ 相像的是，Java 中一个变量的生命周期是从它的块内定义开始，到块的结束
        // 例如以下代码
        int a = 1;
        {
            int b = 2;
            System.out.println("a = " + a); // 变量 a 的生命周期还没有结束，运行正常
            /* ... */
        }
        //System.out.println("b = " + b); // 编译报错，因为变量 b 的生命周期在上一个 } 处就已经结束

        // 另外，由于 Java 没有像 C++ 的名字空间概念，也不包容重名变量的声明
        // 因此内部块内变量的声明不能与外部变量重名
        int c = 3;
        {
            int d = 4;
            //int c = 5; // 在 C/C++ 里是合法的，但在 Java 里会报错
        }
    }


    // 条件语法 (概念)
    public static void IfTest(){
        // Java 的条件 与 C/C++ 的用法非常相似
        // 但有一点不同，条件传参必须传入一个 boolean 类，别的类型的表达式是不允许的
        // 在 C/C++ 中，可能会有以下写法
        //
        //      int p;
        //      /* ... */
        //      if(!p)
        //          printf("p为0\n");
        //
        // C/C++中如果把一个 int 类或者别的类作为条件传入时
        // 编译器会自动将其转换为 bool 类再进行判断
        // 但是 Java 出于某种原因 (不会真有人把 == 写成 = 吧) 并没有设置这样的转换
        //
        // Java 的条件语法
        // if (boolean) [单条语句或一个块]
        // while (boolean) [单条语句或一个块]
        // do [单条语句或一个块] while (boolean)
        // for (循环前执行; boolean; 每次循环后执行) [单条语句或一个块]
        //
        // switch (变量) {
        //   case 常量 -> [单条语句或一个块] break;
        //   case 常量 -> [单条语句或一个块] break;
        //   /* ... */
        //   default -> [单条语句或一个块]
        // }
        // 注： switch case语句后使用 "->" 或者 ":" 都是可以的
        // 如果引入的变量是一个 enum 类对象，则 case 后的常量前不需要加 类名.
        //
        // 另外，与 C++ 一样， Java 也支持新版 for each 循环遍历方法
        // for (类名 变量名 : 类数组) [单条语句或一个块]
        // 其中类名可用 var (推测类) 省略
        // 例如
        int[] arr = {1, 2, 3, 4, 5, 6};
        for(int i : arr) System.out.println(i);
    }

    

    // * java.math.BigInteger 类
    public static void bigIntegerTest(){
        // 对于超过 64 位的数，可使用 BigInteger 类
        int intNum = 48123;
        BigInteger realBigNum =
                new BigInteger("14523489569198369858673674689262934691302972916514231");
        // 前面说过，除 String 与一些基本类之外别的类基本不能使用运算符
        // 该类的加减只能由成员方法实现

        //通过 BigInteger 类内置的 valueOf(int/long) 方法可以将 int/long 转换为 BigInteger
        BigInteger valueNum = BigInteger.valueOf(intNum);
        
        //通过 add subtract multiply divide mod 方法实现 加 减 乘 除 求余 操作
        BigInteger addRes = realBigNum.add(valueNum);
        BigInteger subRes = realBigNum.subtract(valueNum);
        BigInteger mulRes = realBigNum.multiply(valueNum);
        BigInteger divRes = realBigNum.divide(valueNum);
        BigInteger modRes = realBigNum.mod(valueNum);
        
        // 通过 sqrt 方法实现求算术平方根
        BigInteger sqrRes = realBigNum.sqrt();

        // 通过 compareTo 方法实现比较
        // 两者相同返回 0，前者大于后者返回大于 0 的数，后者大于前者返回小于 0 的数
        int compareRes = realBigNum.compareTo(valueNum);
    }


    // 数组
    public static void arrayTest(){

    /* 数组的定义 */

        // Java 定义数组有以下两种形式
        int[] arr1 = new int[5];
        int arr2[] = new int[5];
        // 不建议使用第二种方式，一是为了与 C 语言风格进行区分，二是因为第一种可以将类型与变量名清晰地分开
        // 数组与基础类型不同，请把它看成一个类

        // Java 10 以上版本可以使用 var 来隐藏类型名
        var arr3 = new int[5];

        // 数组的大小可以为一个变量，也可以为 0
        int num = 0;
        var arr0 = new int[num];

        // 可以用以下方式来给数组赋初始值
        int[] arr4 = {1, 2, 3, 4, 5};
        // 这种方式不用标明数组大小

        // 也支持声明匿名数组
        var arr5 = new int[] {1, 2, 3, 4, 5,}; // 数组声明的最后一位后允许有逗号

    /* 数组的修改与访问 */

        // 与 C 一样，可以用以下方式访问或修改数组内元素
        arr5[1] = 1;
        System.out.println(arr5[2]);

        // 可以使用 for each 语法来遍历数组
        for(var it : arr5)
            System.out.println(it);
        // 但是要注意 for each 语法是只读的，不能用它来修改数组元素

        // 另外，可以用 Arrays 类的 toString() 方法输出元素列表，后面会讲到这个类
        System.out.println(Arrays.toString(arr5));
        // [1, 1, 3, 4, 5]

    /* 数组的复制 */

        // 与其他自定类一样，数组也是对象引用的
        var arr6 = arr5;
        // 这种做法会使得两者引用同一个对象，一个数组在发生变化的同时另一个也会变

        // 利用 Arrays.copyOf() 方法可以获得一份数组的拷贝
        var arr7 = Arrays.copyOf(arr5, arr5.length);
        // 第一个参数为要复制的数组
        // 第二个参数为要复制的长度，如果该长度大于要复制的数组，大于的部分会被赋值为默认值

        // 利用 clone() 方法可以获得一份数组的完整拷贝
        var arr8 = arr5.clone();

        // 与其他自定类一样，数组类的 == 符号并不会代表两侧数组的内容是否相等，而是会判断两个对象是否引用同一个对象
        System.out.println("arr8 = arr5.clone() 后，arr8 == arr5 的值为 " + (arr8 == arr5)); // false
        System.out.println("arr6 = arr5 后，arr6 == arr5 的值为 " + (arr6 == arr5)); // true

    /* Arrays 类 */

        // 需要注意的是，Array 与 Arrays 这两个类不是一个东西
        // Array 是数组的包装类，是一个储存结构
        // Arrays 是一个静态方法类，封装了一些针对 Array 类的算法

        // 上面教程已经介绍了一个 Arrays 类方法 toString() 与 copyOf()

        // 利用 Arrays.equals() 可以判断两侧数组的内容是否相等
        System.out.println("Arrays.equals(arr8, arr5)" + Arrays.equals(arr8, arr5));


        // 这里要介绍 Java 数组内置的排序方法，顺便介绍一个快速生成随机数的方法

        // Java 内置了一个快速生成随机数的方法
        var arr = new int[10];

        for(int i = 0; i < 10; i ++)
            arr[i] = (int)(Math.random() * 100);
        // Math.random() 返回的是一个 0 ~ 1 之间的随机 double 值
        System.out.print("排序前:");
        for(var it : arr)
            System.out.print(it + " ");
        System.out.println();

        Arrays.sort(arr);

        System.out.print("排序后:");
        for(var it : arr)
            System.out.print(it + " ");
        System.out.println();

        // 另外，Arrays 类还提供了二分检索的方法 Arrays.binarySearch() ，这个方法仅对排序的数组后有效

        var sortedArr = new int[] {1, 2, 3, 4, 6, 7, 8};
        System.out.println("二分查找到 3 对应的下标为：" + Arrays.binarySearch(sortedArr,3));

        // 如果没有找到，它会返回一个负数，这个数加上 1 再乘以 -1 是当前数组中插入该数后依然有序的位置

        System.out.println("二分查找到 5 对应的下标为：" + Arrays.binarySearch(sortedArr,5));

        // 如果输入的数组并不有序，那么会造成误判
        var unsortedArr = new int[] {1, 2, 6, 4, 5, 3, 7};
        System.out.println("二分查找到 3 对应的下标为：" + Arrays.binarySearch(unsortedArr,3));

    /* 多维数组 (以二维数组为例) */

        var superArr = new int[][] {
                {1, 2, 3},
                {4, 5 ,6},
                {7, 8, 9}};

        // 可以通过 Arrays.deepToString() 方法快速获取到元素列表
        System.out.println(Arrays.deepToString(superArr));
        // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

        // 也可以通过 Arrays.deepEquals() 判断两个多维数组是否相等
        System.out.println(Arrays.deepEquals(superArr, superArr.clone()));

        // 利用 for each 得到的是一个一维数组

        for(int[] it : superArr)
            for(int jt : it)
                System.out.println(jt);

        // 目前 for each 语句还不能处理多维数组的每个元素

    /* Java 数组的本质与不规则数组 */

        // 与 C/C++ 不同， Java 是完整的面向对象风格的开发语言
        // Java 的数组的每一个元素都是对象的引用 (Java 的对象概念就是 C++ 的引用)
        // 而对象与对象之间在内存上不一定会首尾相连
        // 因此 Java 并不存在真正意义上的数组，只是保存着每个包含对象的引用

        // 也因此二维数组的每一个成员数组的大小都是可变的
        var specialArr1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6, 7, 8},
                {9}
        };

        var specialArr2 = new int[3][];
        specialArr2[0] = arr5;
        specialArr2[1] = new int[2];
    }

    // 基础章节已完结
}