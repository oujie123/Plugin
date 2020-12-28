##### getMethod()与getDeclaredMethod()的区别

getMethod（）：获取自身能用所有的公共方法。1.类本身的public 2.继承父类的public 3.实现接口的public

getDeclaredMethod（）：获取类自身声明的所有方法





getMethod（）获取继承父类的public方法举例：

```java
public class Father {
 
	public Father() {
		System.out.println("调用了父类构造方法");
	}
	
	public void fatherSay() {
		System.out.println("我是爸爸");
	}
}
 
 
public class Son extends Father {
 
	public Son() {
	
		// TODO Auto-generated constructor stub
		System.out.println("调用了子类构造方法");
	}
	
	public void sonSay() {
		System.out.println("我是儿子");
	}
	public static void main(String[] args) {
		Son son=new Son();
		son.fatherSay();
	}
}
```




测试类：

```java
public class test1 {
 
	public static void main(String[] args) {
		Class clazz=Son.class;
		try {
              //报错 NoSuchMethodException
			Method method =clazz.getDeclaredMethod("fatherSay");
			method.invoke(clazz.newInstance());
			
                //运行结果:
                //调用了父类构造方法
                //调用了子类构造方法
                //我是爸爸
			Method method2 =clazz.getMethod("fatherSay");
			method2.invoke(clazz.newInstance());
 
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
```