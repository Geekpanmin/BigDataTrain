package zd.service;

import java.util.List;

import zd.vo.OrdersItemsVo;
import zd.model.Orders;
import zd.vo.OrdersVo;

public interface OrdersService {
	public List<Orders> findOrdersAndItemsAndPost(OrdersVo vo);
	public void insertOrdersBySelective(Orders orders);
	public void insertOrdersItemsRelation(OrdersItemsVo vo);
}
