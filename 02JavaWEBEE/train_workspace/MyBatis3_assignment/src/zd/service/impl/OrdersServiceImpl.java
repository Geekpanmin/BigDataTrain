package zd.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zd.dao.OrdersDao;
import zd.model.Orders;
import zd.service.OrdersService;
import zd.util.MybatisUtil;
import zd.vo.OrdersVo;

public class OrdersServiceImpl implements OrdersService {

	@Override
	public List<Orders> findOrdersByVo(OrdersVo vo) {
		SqlSession session=MybatisUtil.getFactory().openSession();
		OrdersDao daili=session.getMapper(OrdersDao.class);
		return daili.findOrdersByVo(vo);
	}

	@Override
	public List<Orders> findAllOrdersAndUser() {
		SqlSession session=MybatisUtil.getFactory().openSession();
		OrdersDao daili=session.getMapper(OrdersDao.class);
		return daili.findAllOrdersAndUser();
	}

	@Override
	public List<Orders> findAllOrdersAndItemsAndPosts() {
		SqlSession session=MybatisUtil.getFactory().openSession();
		OrdersDao daili=session.getMapper(OrdersDao.class);
		return daili.findAllOrdersAndItemsAndPosts();
	}

}
