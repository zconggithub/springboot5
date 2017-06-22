package com.CircleOfFridend.dao;

import com.CircleOfFridend.entity.FriendType;



public interface FriendTypeMapper {


    int deleteByPrimaryKey(Integer tid);

    int insert(FriendType record);

    int insertSelective(FriendType record);

  

    FriendType selectByPrimaryKey(Integer tid);


    int updateByPrimaryKeySelective(FriendType record);

    int updateByPrimaryKey(FriendType record);
}