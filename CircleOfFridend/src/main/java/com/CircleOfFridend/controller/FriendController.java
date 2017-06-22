package com.CircleOfFridend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CircleOfFridend.entity.Friend;
import com.CircleOfFridend.entity.SearchCondition;
import com.CircleOfFridend.service.FriendService;
import com.alibaba.fastjson.JSON;


@RestController
public class FriendController {
	
	

	@Autowired
	private FriendService friendService;
	
	
	@RequestMapping("/hello")
	public String hello(){
		return "demo测试";
		
	}
	
	
	@RequestMapping("/getOneFriend")	
	public String getOneFriend(){
		System.out.println("开始计算了====");
		Friend friend=friendService.selectByPrimaryKey(1);
		System.out.println("姓名是：=="+friend.getFname());
		return friend.toString();
	}
	
	/**
	 * 测试（通过类型来查询所有的朋友By注解的方式）
	 * @param tid
	 * @return
	 */
	@RequestMapping("/test1")	
	public List<Map<String,Object>> test1(Integer tid){
	
		return friendService.test1(tid);
	}
	
	/**
	 *  /**
     * 根据相关条件查询
     * @param condition
     * @return
     */

	@RequestMapping("/test2")
	public List<Friend> test2(){
		
		SearchCondition condition=new SearchCondition();
			condition.setStartAge(18);
			condition.setEndAge(30);
			condition.setStarAnnualBonus(2000);;
		//	System.out.println("最大范围："+condition.getEndAge());
		System.out.println(friendService.searchByCondition(condition).size());
		return friendService.searchByCondition(condition);
		
	}
	
	@RequestMapping("/test3")
	public HashMap<Integer,List<Friend>> test3(){
		HashMap<Integer, List<Friend>> map=new HashMap<Integer, List<Friend>>();
		SearchCondition condition=new SearchCondition();
			condition.setStartAge(18);
			condition.setEndAge(30);
			condition.setStarAnnualBonus(2000);;
		//	System.out.println("最大范围："+condition.getEndAge());
		System.out.println(friendService.searchByCondition(condition).size());
		map.put(1, friendService.searchByCondition(condition)) ;
		 return map;
	}
	
	@RequestMapping("/test4")
	public List<?> test4(){
		
		SearchCondition condition=new SearchCondition();
			condition.setStartAge(18);
			condition.setEndAge(30);
			condition.setStarAnnualBonus(2000);;
		//	System.out.println("最大范围："+condition.getEndAge());
		System.out.println(friendService.searchByCondition(condition).size());
		List<Friend> list=friendService.searchByCondition(condition);
				
		
		
		return friendService.searchByCondition(condition);
		
	}
}
