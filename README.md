module()包，等模块多了，把一些无法分类的模块放到这里，
例如rabbitmq这些搭建类的模块

JAVA8函数式编程包含三部分
1、lambda表达式
2、函数式接口（Functional interface）
3、stream接口操作
其他：Optional静态类


关于测试类:
引入pom文件中scope的值是test是指只能在test包下使用这个依赖的类，
而IDEA中src下可以创建一个test包，
但是IDEA并不认识这个是test包必须标记，标记了是有颜色的（绿色）


说明：
test（demo）项目，主要是各模块的demo和随手测试及沉淀的东西

太重了！！！整理简化！！！

项目拆分：
会拆出demo项目，专门做项目及所有中间件的整合（例如es、mq、redis等），
已有的功能模块及依赖的中间件不动。

最新定位：
test项目：随手测试 和 源码重写，设计模式、锁、java8、spring等的一些demo