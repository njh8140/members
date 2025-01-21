package kr.hkit.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next; // 이전, 다음 페이지 그룹이 있는지 여부
	
	private int total; // DB에 있는 전체 레코드(데이터) 수
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10; // 끝 페이지 번호 계산(ex.15/10=1.5)
		this.startPage = this.endPage - 9; // 시작 페이지 표현 (ex.30-9=21 시작 페이지 = n1)
		
		int realEnd = (int)(Math.ceil((total * 1.0)/cri.getAmount())); // 번호 계산 후 반올림(1.5 -> 2페이지)
		//total= 총 db, cri.getamount= 한 페이지에 표시할 데이터 개수, ex.46/10=4.6 -> math.ceil(4.6)=5 -> 전체 페이지=5
		
		if(realEnd < this.endPage) { // realend < this.endpage -> 끝 페이지는 전체 데이터에 맞춰 조정
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1; // 1보다 크면 이전 페이지가 있다 ex.12>1 -> 12페이지 이전 페이지가 있다
		this.next = this.endPage < realEnd; // 현재 페이지가 끝 페이지보다 작으면 다음 페이지가 있다 ex. 현재:8 끝:9 -> 다음 페이지가 있다
	}
}
