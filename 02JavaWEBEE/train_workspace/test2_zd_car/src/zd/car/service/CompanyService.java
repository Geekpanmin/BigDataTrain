package zd.car.service;

import zd.car.base.BaseService;
import zd.car.bean.Company;

public interface CompanyService extends BaseService<Company> {

	Company findCompanyByName(String companyname);

}
