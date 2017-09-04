package zd.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import zd.service.ItemsService;
import zd.service.impl.ItemsServiceImpl;
import zd.vo.ItemsVo;

public class Test5 {
	@Test
	public void test() {
		ItemsService itemsService=new ItemsServiceImpl();
		ItemsVo vo=new ItemsVo();
		List<Integer> ids=new ArrayList();
		ids.add(14);
		ids.add(15);
		vo.setIds(ids);
		itemsService.deleteItemsByIds(vo);
	}
}
