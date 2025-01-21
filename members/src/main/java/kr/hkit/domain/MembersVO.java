package kr.hkit.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MembersVO {
	
	private long mno;
	private String email;
	private String pwd;
	private String mname;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cre_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mod_date;

}