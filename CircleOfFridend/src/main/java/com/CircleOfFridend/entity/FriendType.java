package com.CircleOfFridend.entity;

import lombok.Data;

@Data

public class FriendType {
    private Integer tid;

     
    private String fType;
    
    public FriendType(){}

	public FriendType(Integer tid, String fType) {
		super();
		this.tid = tid;
		this.fType = fType;
	};
    
    

   
}