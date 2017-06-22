package com.CircleOfFridend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CircleOfFridend.dao.FriendMapper;
import com.CircleOfFridend.entity.Friend;
import com.CircleOfFridend.entity.SearchCondition;
import com.CircleOfFridend.service.FriendService;
@Service
public class FriendServiceImpl implements FriendService{
	@Autowired
	private FriendMapper	friendMapper;

	@Override
	public Friend selectByPrimaryKey(Integer fid) {
		
		return friendMapper.selectByPrimaryKey(fid);
	}

	@Override
	public List<Map<String, Object>> test1(Integer tid) {
		// TODO Auto-generated method stub
		return friendMapper.test1(tid);
	}

	@Override
	public List<Friend> searchByCondition(SearchCondition condition) {
		// TODO Auto-generated method stub
		return friendMapper.searchByCondition(condition);
	}

}
