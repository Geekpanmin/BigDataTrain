package zd.car.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zd.car.base.Page;
import zd.car.bean.City;
import zd.car.dao.CityMapper;
import zd.car.service.CityService;
@Service
public class CityServiceImpl implements CityService {
	@Resource
	private CityMapper cityMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public City selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(City t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<City> findByPageQuery(Page<City> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRowsByPageQuery(Page<City> page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<City> findAllProvinces() {
		// TODO Auto-generated method stub
		return cityMapper.findAllProvinces();
	}

	@Override
	public List<City> findCityByParentId(int id) {
		// TODO Auto-generated method stub
		return cityMapper.findCityByParentId(id);
	}

}
