package zd.service.impl;

import org.apache.ibatis.session.SqlSession;

import zd.dao.PostsDao;
import zd.model.Posts;
import zd.service.PostsService;
import zd.util.MybatisUtil;

public class PostsServiceImpl implements PostsService {

	@Override
	public Posts findPostsByOrdersId(int id) {
		SqlSession session=MybatisUtil.getFactory().openSession();
		PostsDao daili=session.getMapper(PostsDao.class);
		return daili.findPostsByOrdersId(id);
	}

}
