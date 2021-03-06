package zd.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zd.dao.ItemsMapper;
import zd.model.Items;
import zd.service.ItemsService;
import zd.util.MybatisUtil;
import zd.vo.ItemsVo;

public class ItemsServiceImpl implements ItemsService {

	@Override
	public List<Items> findItemsByVo(ItemsVo vo) {
		SqlSession session = MybatisUtil.getFactory().openSession();
		ItemsMapper daili = session.getMapper(ItemsMapper.class);
		return daili.findItemsByVo(vo);
	}

	@Override
	public List<Items> findItemsByCart(String ids) {
		SqlSession session = MybatisUtil.getFactory().openSession();
		ItemsMapper daili = session.getMapper(ItemsMapper.class);
		return daili.findItemsByCart(ids);
	}

	@Override
	public Items findItemsBySelect(int id) {
		SqlSession session = MybatisUtil.getFactory().openSession();
		ItemsMapper daili = session.getMapper(ItemsMapper.class);
		session.commit();
		return daili.selectByPrimaryKey(id);
	}

	@Override
	public void updateItemsBySelective(Items items) {
		SqlSession session = MybatisUtil.getFactory().openSession();
		ItemsMapper daili = session.getMapper(ItemsMapper.class);
		daili.updateByPrimaryKeySelective(items);
		session.commit();
	}

	@Override
	public void insertBySelective(Items items) {
		SqlSession session = MybatisUtil.getFactory().openSession();
		ItemsMapper daili = session.getMapper(ItemsMapper.class);
		daili.insertSelective(items);
		session.commit();
	}

}
