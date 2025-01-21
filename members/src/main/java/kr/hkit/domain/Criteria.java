package kr.hkit.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount; // 한 페이지에 출력할 레코드 갯수
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1, 10); // (첫 번째 페이지, 한 페이지에 출력할 데이터 갯수)
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
}