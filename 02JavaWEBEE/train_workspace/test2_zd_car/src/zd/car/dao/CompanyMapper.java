package zd.car.dao;

import zd.car.base.BaseDao;
import zd.car.bean.Company;

public interface CompanyMapper extends BaseDao<Company>{

	Company findCompanyByName(String companyname);
     
}