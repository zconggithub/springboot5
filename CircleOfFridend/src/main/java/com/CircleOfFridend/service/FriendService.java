package com.CircleOfFridend.service;


import java.util.List;
import java.util.Map;

import com.CircleOfFridend.entity.Friend;
import com.CircleOfFridend.entity.SearchCondition;

public interface FriendService {
	
	Friend selectByPrimaryKey(Integer fid);

	public List<Map<String,Object>> test1(Integer tid);
	
	 public List<Friend> searchByCondition(SearchCondition condition);
}
