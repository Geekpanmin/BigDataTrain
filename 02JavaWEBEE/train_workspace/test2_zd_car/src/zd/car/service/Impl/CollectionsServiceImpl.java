package zd.car.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zd.car.base.Page;
import zd.car.bean.Collections;
import zd.car.dao.CollectionsMapper;
import zd.car.service.CollectionsService;
import zd.car.vo.CollectionVo;
@Service
public class CollectionsServiceImpl implements CollectionsService {
	
	@Resource
	private CollectionsMapper collectionsMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collections selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Collections t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Collections> findByPageQuery(Page<Collections> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<Collections> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer findCount(CollectionVo cv) {
		// TODO Auto-generated method stub
		return collectionsMapper.findCount(cv);
	}

	@Override
	public Collections selectByVo(CollectionVo cv) {
		// TODO Auto-generated method stub
		return collectionsMapper.selectByVo(cv);
	}

}
