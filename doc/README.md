# Plugin
##### 1.类的生命周期

加载-> （ 验证-> 准备 -> 解析） -> 初始化 -> 使用 -> 卸载

​                            连接

* 加载阶段, 虚拟机主要完成三件事：
  * 1.通过一个类的全限定名来获取定义此类的二进制字节流。
  * 2.将这个字节流所代表的静态存储结构转化为方法区域的运行时数据结构。
  * 3.在Java堆中生成一个代表这个类的Class对象，作为方法区域数据的访问入口



##### 2.反射耗时点：

* 产生大量的临时对象
* 检查可见性
* 会生成没有优化的字节码
* 进行类型转换



源码下载：androidos.net.cn/sourcecode



pathClassLoader和DexClassLoader在8.0之后，完全一样

bootClassLoader是pathClassLoader的parent，bootClassLoader是没有parent的



类加载原理：

<img src="G:\android_project\Plugin\doc\类加载.png" alt="类加载" style="zoom:50%;" />



双亲委派机制：是为了防止原生类被替换

双亲委托机制：首先检测这个类是否已经被加载了，如果已经加载了，直接获取并返回。如果没有被加载，parent 不为 null，则调用parent的loadClass进行加载，依次递归，如果找到了或者加载了就返回，如果即没找到也加载不了，才自己去加载。这个过程就是我们常说的 双亲委托机制