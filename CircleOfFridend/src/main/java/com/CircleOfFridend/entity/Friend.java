package com.CircleOfFridend.entity;

import lombok.Data;
//也是ExcelBean【作为导出Excel表格】
@Data
public class Friend {
	
    private Integer fid;

    private String fname;
    private Integer tid;

    private String ftel;

    private String sex;
    
    private Integer age;
    
    private Integer monthSal;
    
    private Integer annualBonus;
    
    public Friend(){}

	public Friend(Integer fid, String fname, Integer tid, String ftel, String sex, Integer age, Integer monthSal,
			Integer annualBonus) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.tid = tid;
		this.ftel = ftel;
		this.sex = sex;
		this.age = age;
		this.monthSal = monthSal;
		this.annualBonus = annualBonus;
	}

}