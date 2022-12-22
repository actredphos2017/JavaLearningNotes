public class Main { // Java 类的类名，需与文件名一致 (例如本文件名为 Main.java)
    public static void main(String[] args) { // 主方法必须为 public static void 类型，必须要有 String[] args 参数
        System.out.println("We will not use 'Hello World'!"); //调用 System 类的 out 对象的 println 方法 向控制台打印内容
        basicClassTest();
        StringTest();
        StringBuilderTest();
    }

    public static void basicClassTest(){ // Java 的基本类
        // Java 的类型判断标准
        // 一般来说 类似于 int char boolean double 这样的以小写字母开头的类为基础类型
        // 他们本身就是实例，不存在指针指向
        //
        // 例：

        int num1 = 1;
        int num2 = num1;
        num2 = 2;   // 此时 num2 变成了 2，但 num1 还是 1
        System.out.println("num1 的值为 " + num1);
        System.out.println("num2 的值为 " + num2);

        // 而一般类似于 String Vector Array 等以大写字母开头的类为自定义类
        // 他们的对象实质上为指向实例的指针
        // 因此最好在声明时就要给他们赋值，若不赋值他们为 null
        // 自定义类的定义方法为
        // AClass object = new AClass(...各种参数);
        //
        // 例：
        // （MyInt 是一个虚构的自定义动态类）
        //
        // MyInt num1;              // 此时 num1 为 null;
        // num1 = new MyInt(1);     // 此时 num1 初始化，被赋予了一个 MyInt 类的实例
        // MyInt num2 = num1;       // 新建了一个 num2 指向了 num1
        // num2.setNum(2);          // 此时 num2 变成了 2， num1 也变成了 2
        //
        // 由于 num1 与 num2 都指向相同的实例，因此 num1 的值也会跟着变
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
    }

    public static void StringTest(){  // Java字符串类 java.lang.String

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

        System.out.println("字符串码点：" + str1.codePoints().toArray().toString());
        // codePoints() 返回该字符串的码点迭代器 IntStream
        // 其内置的 toArray() 方法可将其转换为 int[] 数组


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
        // String 为一个类，它的对象与基本类型有很大不同，它是一个指针，指向的是一个实例
        // 因此会存在一个对象的值 null 的情况，因此需要对于不确定的 String 对象进行判断
        // 对于 str1 = str2 只是将 str2 的地址赋给 str1 ，并不会分配新的空间占用
        // 由于 String 是一个静态类，这本身并不会存在很大的问题
        //
    }

    public static void StringBuilderTest(){ //字符串构建器 java.lang.StringBuilder
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

        
        // 注意：由于 StringBuilder 为动态自定义类，这就意味着存在多个对象指向同一个实例的情况
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
        // 由于这两个对象指向的是一个实例，因此这两个对象是等价的
    }
}