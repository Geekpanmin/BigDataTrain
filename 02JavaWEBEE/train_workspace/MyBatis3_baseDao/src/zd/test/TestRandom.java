package zd.test;

import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {
		Random random=new Random();
		int result=random.nextInt(52)+1;
		System.out.println(result);
	}

}
