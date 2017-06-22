package com.CircleOfFridend.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.CircleOfFridend.entity.Friend;
import com.CircleOfFridend.entity.SearchCondition;

public interface FriendMapper {


    int deleteByPrimaryKey(Integer fid);

    int insert(Friend record);

    int insertSelective(Friend record);



    Friend selectByPrimaryKey(Integer fid);

  
    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
    
    /**
     * 根据类型编号查询该下的所有朋友
     * @return
     */
    @Select("select a.fname,a.ftel,a.sex,b.f_type "
    		+ "from friend as a "
    		+ "left join friend_type as b on a.tid=b.tid WHERE b.tid=#{tid} ")
    public List<Map<String,Object>> test1(Integer tid);
    
    /**
     * 根据相关条件查询
     * @param condition
     * @return
     */
    public List<Friend> searchByCondition(SearchCondition condition);
}