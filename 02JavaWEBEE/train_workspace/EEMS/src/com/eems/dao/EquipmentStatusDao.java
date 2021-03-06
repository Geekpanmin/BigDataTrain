package com.eems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eems.entity.EquipmentStatus;
import com.eems.util.DBUtil;

public class EquipmentStatusDao extends DBUtil{
	//获取设备状态集合列表
	public List<EquipmentStatus> getList()
	{
		String sql="select * from equipmentstatus";
		List<EquipmentStatus> list=new ArrayList<EquipmentStatus>();
		ResultSet rs=this.executeQuery(sql);
		try {
			while(rs.next())
			{
				list.add(new EquipmentStatus(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list.size()>0?list:null;
	}
}
