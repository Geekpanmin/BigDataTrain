package zd.test;

import org.dom4j.DocumentException;

import zd.bean.p1;
import zd.bean.p2;
import zd.factory.BeanFactory;

public class Test1 {
	public static void main(String[] args) throws Exception {
		p1 bean = (p1) BeanFactory.getBean("p1");
		bean.run();
		p2 bean2 = (p2) BeanFactory.getBean("p2");
		bean2.run();
	}

}
