package com.CircleOfFridend.entity;

import lombok.Data;

/**
 * 查询条件
 * @author dell、
 *
 */
@Data
public class SearchCondition {
	
	private Integer tid;
	
	private Integer startAge; 
	
	private Integer endAge;
	
	private Integer starAnnualBonus;
	
	private Integer endAnnualBonus;

	public SearchCondition(Integer tid, Integer startAge, Integer endAge, Integer starAnnualBonus,
			Integer endAnnualBonus) {
		super();
		this.tid = tid;
		this.startAge = startAge;
		this.endAge = endAge;
		this.starAnnualBonus = starAnnualBonus;
		this.endAnnualBonus = endAnnualBonus;
	}
	
	public SearchCondition(){};

}
