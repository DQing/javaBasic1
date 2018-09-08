# Summary

## day1

### 准备的问题
- 测试在测什么
- 测试为什么挂了
- 怎么改的
- 为什么这么改
- 查看单词意思

### underScore
```
final int a = 0x1234_5678
```
- 提高可读性，只能在数字间添加
- 可添加多个
- 不能在数字首尾添加
- 不能再小数点前后添加


### Assertions
- delta 参数表示expected 和actual之间可以绝对值差小于等于delta
 
```
public static void assertEquals(double expected, double actual, double delta, String message)

Math.abs(value1 - value2) <= delta;
```
- assertIterableEquals 用于比较两个可迭代的数据，即继承Iterable接口
```
assertIterableEquals(Arrays.asList(4, 5, 6, 7, 8, 9), Iterable);
```

### iterator 和iterable 的区别
iterator 方法是 iterable接口中的一个字段，实现iterable接口就必须实现iterator 方法，并可以在里面实现其hasNext()方法，和next()方法

```
public class IterableTest implements Iterable {

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
```
## day2
- 位移运算
```
<< 左移运算符，num << 1,相当于num乘以2
>> 右移运算符，num >> 1,相当于num除以2
>>> 无符号右移，忽略符号位，空位都以0补齐
```
- 0x ffff 默认int型
- 0x80000000和-0x80000000都是负数

### 补码，原码，反码
- 正数的原码，补码，反码都一样
- 负数的反码为原码除符号位取反，补码为反码加一

### java原始类型
- 整型
    - byte 1 个字节
    - short 2 个字节
    - int 4 个字节（输入数字默认是int型）
    - long 8 个字节
- 浮点
    - float 4个字节
    - double 8个字节（默认的是double类型，如3.14是double类型的，加后缀F（3.14F）则为float类型的） 
-  char类型
    - char：2个字节
- Boolean 类型
    - boolean: （true or false）（并未指明是多少字节  1字节  1位 4字节）

### java类型转换

| 从列到行  |byte   | short | int  | long  | float  |  double |
|---|---|---|---|---|---|---|
| byte      | -  |  隐 | 隐  |隐   | 隐  | 隐  |
| short     |  显 | -  | 隐  | 隐  | 隐  | 隐  |
| int       |  显 | 显  | -  | 隐  | 隐  | 隐  |
| long      |  显 | 显  | 显  | -  | 隐  |  隐 |
| float     |  显 | 显  | 显  | 显  | -  | 隐  |
| double    |  显 | 显  | 显  | 显  | 显  | -  |
损失精度需要强制转换，short转byte编译期优化的时候，在一定的区间可以隐式转换

- Double,Float 的infinite Nan

```
@Test
void should_test_infinite() {
    assertEquals(2.0 / 0, 3.0 / 0);
    assertEquals(0.0 / 0.0, 0.0 / 0);
    assertTrue(2.0 / 0 == 2.0 / 0);
    assertFalse(0.0 / 0 == 0.0 / 0);
    assertSame(0 / 1, 0 / 1);
    }
``` 
- int -> short ,将后8位截取下来，后八位中的首位作为符号位

### 数字间的操作规则

- short (+-*/) short = int

- byte (+-*/) byte = int

- int (+-*/) int = int

- 如果，两个操作数中，其中一个为double，结果为double
- 否则，两个操作数中，其中一个为float，结果为float
- 否则，两个操作数中，其中一个为long，结果为long
- 否则，两个操作数结果为int

### try catch throw 按照调用栈来throw

```
package com.cultivation.javaBasic.demo;

public class ExceptionTest {

    void a() {
        throw new IllegalArgumentException();
    }

    void b() {
        a();
    }

    void c() {
        b();
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.c();
    }
}

```
进栈(c-b-a),出错时的错误栈(a-b-c)

###四舍五入

```
 @Test
    void should_round_number() {
        final double floatingPointNumber1 = 2.75;
        final double floatingPointNumber2 = 2.15;

        final long rounded1 = Math.round(floatingPointNumber1);
        final double rounded2 = Math.floor(floatingPointNumber1);
        final double rounded3 = Math.ceil(floatingPointNumber1);

        final long rounded4 = Math.round(floatingPointNumber2);
        final double rounded5 = Math.floor(floatingPointNumber2);
        final double rounded6 = Math.ceil(floatingPointNumber2);

        assertEquals(3L, rounded1);
        assertEquals(2.0, rounded2);
        assertEquals(3.0, rounded3);

        assertEquals(2L, rounded4);
        assertEquals(2.0, rounded5);
        assertEquals(3.0, rounded6);

    }

```
## day3
### java编码
- java使用Unicode编码，默认使用UTF-16编码
- Unicode中包含三种编码方式（UTF8,UTF16,UTF32）
    - UTF8:可以包含1或2或3个字节
    - UTF16：可以包含2个或4个字节
    - UTF32：4个字节
- 与或非优先级```~ > & >|```
- char[] chars = new char[10]; 元素初始值 \u0000
- Object[] ints = new Object[10]; 元素初始值 null
- String[] strings = new String[1] 元素初始值 null
- float[] floats = new float[10] 元素初始值 0.0,
- int a; 在方法中未初始化不可使用（在类中声明filed会初始化）

> 基本类型数组初始化为值  object初始化为null
> new相当于创建一个对象，会给元素初始化，
> 声明一个数组就是声明一个对象

### String
- final string 则引用不可变，不可重新赋值
- codePoint可代表多个char
- java parameter vs argument(形参，实参)
- “==” tests for reference equality (whether they are the same object).
.equals() tests for value equality (whether they are logically "equal").

### java 传参
- 基本类型会copy值（值传递）
- 对象拷贝引用 

### 类初始化顺序
- (静态变量、静态初始化块）>（变量、初始化块）>（构造函数）
- demo实现父子类初始化优先级

```
SuperClass with static field 父类的静态字段和静态init block
SuperClass static init block
DeriverClass static init block  子类的静态字段和静态 init block
DeriverClass with static field
SuperClass init block  父类的字段和init block
SuperClass with field
SuperClass no parameter constructor 父类的无参构造函数
DeriverClass init block   子类的字段和init block
DeriverClass with field
DeriverClass no parameter constructor  子类的无参构造函数
```
## day4
- 类修饰符优先级

|Modifier|Class|Package|Subclass|world|
|---|---|---|---|---|
|public     |  Y  |   Y	  |  Y |  Y|
|protected  |  Y  |   Y	  |  Y |  N|
|package-private|  Y  |   Y  |  N |  N|
|private	  |  Y  |   N  |  N |  N|

- instanceOf 只要前者不为null，并且可以强制转换为后者,没有运行时错误，结果都为true
- instanceOf不能应用于Equals方法重写 

```
https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#isInstance-java.lang.Object-
```
- null 可以是任何类型，在代码中只要没有使用null的方法，就不会报空指针错误

```
public class NullTest {
    public String getName(String string) {
        return string;
        // 如果在这里调用了string.toLowerCase()方法，则出现空指针错误
    }

    public static void main(String[] args) {
        NullTest nullTest = new NullTest();
        String name = nullTest.getName(null);
        System.out.println(name);  //null
    }

}
```
- final 可用于修饰：字段（不可修改，必须声明），方法（不可重写），类（不可继承）
- static 可用于修饰：字段（可修改，会自动初始化），方法
- 子类可以调用父类的静态方法
- 注解类， java 8 元注解
- import static package name
- java 中什么是相等

### 父子类
- 小鸟(子类)，动物(父类)。小鸟是动物，但动物不是小鸟
- 小鸟中有自己特定的字段及行为
- 小鸟 instanceof 动物
- 父类不可以隐式转换为子类
- 强制转换不改变实际类型

### java ... paramete(谁什么时候更改成数组)编译期还是运行期
- java方法的变长参数只是语法糖，其本质上还是将变长的实际参数 varargs 包装为一个数组。
- 编译器在编译期间将可变长参数包裹成数组进行使用
- new一个数组 传递数组引用

```
private static int sumUp(int... values) {
}
其实最后编译时会转化为 
实际上是传递了一个数组引用

private static int sumUp(int[] values) {
}
所以如果同时写这两个函数，就会编译不通过，他们本质上是一样的

``` 
### 方法重载（overload）
- 发生在编译期间
- 签名包括（方法名，参数列表）
- 重载：方法名相同，参数不同（参数类型，或者数量）
- 必须是同一个类

#### 1. 基本类型之间的重载
基本类型的形参匹配规则是： 如果没有匹配到精确类型的形参，则优先匹配 存储长度(范围)大于且是最接近实参的存储长度的形参，从而确定调用哪个重载方法
#### 2. 引用类型间的重载

引用类型间选择最明确的重载方法的规则是： 如果找不到重载方法的形参的引用类型与实参一致，则实参优先匹配 在继承树结构上，离实参类型最近的形参，则此形参所在的重载方法便是最明确的重载方法。
 
####3.char>int>long>Character>Serializable>Object>char…

### 方法重写（override）
- @override 注解不是必须的

### 反射
- 类中的方法只有一份，存于method table中，其中元数据（类的各种信息）也只有一份
- getDeclareedMethod方法包含类中所有权限方法，但不包含父类方法
- getMethods包含子类及父类的public方法

## day 5
### 接口 https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html
- In the Java programming language, an interface is a reference type
- Method bodies exist only for default methods and static methods，and only use in interface class
- The interface body can contain abstract methods, default methods, and static methods. 
- an interface can contain constant declarations. All constant values defined in an interface are implicitly public, static, and final.
- 接口不可以被实例化，只能继承其他接口
- 规定行为，约束子类必须有的方法

```
public interface GroupedInterface extends Interface1, Interface2, Interface3 {

    // constant declarations
    
    // base of natural logarithms
    double E = 2.718282;
 
    // method signatures
    void doSomething (int i, double x);
    int doSomethingElse(String s);
}// constant declarations    

```
- interface 特性

```
mutiple-implement
no self-implementation
except static | default | abstrct方法
Field to be static, final
no instance
class implements an interface, the class must override all methods
接口中的static方法不能inherit
method to be public
default method can be inherit
method to be abstract
interface default to be package-private
can be type
```
### perfect equals

```
1.自反性
2.对称性
3.传递性
4.一致性
4.parameter不能为null
5.equals不能用于判断父子类 
```

```
判断相等强度：identity > equality > hash code
1. identity 唯一在内存中标识一个对象，强度最大
2. equality 定义自己的相等，对于内存中不同的对象，field相等即可
3. hash code 对一群散列的值进行分类，equal相等，hashcode必须相等，但hashcode相等，equal不一定相等
```
### 闭包
- this 指当前类实例
- 闭包可以扩展变量使用范围，当一个变量或对象被闭包捕获，即成为闭包中的一个字段
- 被闭包捕获的变量不可更改
- 被闭包捕获的变量，在闭包中变量名发生改变

```java
 int captured = 5;
    StringFunc lambda = () -> captured + " has been captured.";
    Field[] fields = lambda.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      System.out.println(field.getName()); //arg$1
      System.out.println(field.get(lambda)); //5
   }
```
- 闭包可以捕获其他类的this
- 函数+运行环境（定义时环境）= 闭包



