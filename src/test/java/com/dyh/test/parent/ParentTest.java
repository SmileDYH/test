package com.dyh.test.parent;

import com.dyh.test.TestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创建这个父类就是让测试子类去继承他，这样就不用每创建一个新的测试子类就要标注上@RunWith @SpringBootTest注解，
 * 正所谓高级的搬砖程序员不做重复的事情
 */
//@RunWith是JUnit的一个注解, 用来告诉JUnit不要使用内置的方式进行单元测试,
// 而应该使用指定的类做单元测试 对于Spring单元测试总是要使用 SpringRunner.class
@RunWith(SpringRunner.class)
//告诉测试类启动类(这里的DockerspringbootApplication是自己再main/java包下的启动类)
// 因为启动类加载类配置文件 还有包扫描 才能使用Spring中的bean对象
@SpringBootTest(classes = TestApplication.class)
public class ParentTest {
}
