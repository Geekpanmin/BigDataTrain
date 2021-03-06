package zd.dao;

import java.util.List;

import zd.model.Items;
import zd.vo.ItemsVo;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer itemsId);

    int insert(Items record);

    int insertSelective(Items record);
    

    Items selectByPrimaryKey(Integer itemsId);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(int id);
    
    public List<Items> findItemsByVo(ItemsVo vo);
    
    public List<Items> findItemsByCart(String ids);
    
    public void insertBySelective(Items items);
}