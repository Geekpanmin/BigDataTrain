package zd.car.service;

import zd.car.base.BaseService;
import zd.car.bean.Collections;
import zd.car.vo.CollectionVo;

public interface CollectionsService extends BaseService<Collections> {

	Integer findCount(CollectionVo cv);

	Collections selectByVo(CollectionVo cv);

}
