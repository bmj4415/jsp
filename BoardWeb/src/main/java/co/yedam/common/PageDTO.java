package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO { // 현재 url 페이지를 기준으로 첫 페이지와 마지막 페이지를 계산하기 위해 
	//필드
	private int startPage, endPage; // 이전 10페이지, 이후 10페이지 계산
	private boolean prev, next;
	private int page;
	
	//생성자
	public PageDTO(int page, int totalCnt) { //페이지 정보와 페이지 카운트
		this.page = page; //11page ~ 14page ~ 20page : 현재 페이지가 14페이지라면
		this.endPage = (int) Math.ceil(page/10.0) * 10;//마지막 페이지 20 계산 (ceil:올림)
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) Math.ceil(totalCnt/5.0); // 실제 페이지 계산
		this.endPage = (this.endPage > realEnd) ? realEnd : this.endPage; 
		//삼항연산자 => 조건식 ? 참:거짓 => 실제 마지막 페이지가 계산한 마지막 페이지보다 작으면, 참 : 실제 마지막 페이지 / 거짓 : 계산한 마지막 페이지 
		
		this.prev = this.startPage > 1; //1페이지보다 큰 수라면 이전페이지 존재
		this.next = this.endPage == realEnd ? false : true; // 실제 마지막 페이지와 계산한 마지막 페이지가 같으면 
	}
}	
