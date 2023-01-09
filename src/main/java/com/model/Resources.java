package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resources {
	
	private int id;
	private String corporateemail;
    private String name;
    private String status;
    private String skills;
    private String clientname;
}
