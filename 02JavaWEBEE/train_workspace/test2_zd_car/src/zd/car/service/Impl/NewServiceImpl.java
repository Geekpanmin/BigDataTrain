package zd.car.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zd.car.base.Page;
import zd.car.bean.News;
import zd.car.dao.NewsMapper;
import zd.car.service.NewsService;
@Service
public class NewServiceImpl implements NewsService {
	
	@Resource
	private NewsMapper newsMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(News t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(News t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public News selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(News t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(News t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<News> findByPageQuery(Page<News> page) {
		// TODO Auto-generated method stub
		return newsMapper.findByPageQuery(page);
	}

	@Override
	public int findTotalRowsByPageQuery(Page<News> page) {
		// TODO Auto-generated method stub
		return newsMapper.findTotalRowsByPageQuery(page);
	}

}
