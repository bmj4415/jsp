package co.yedam.vo;

import java.util.Date;

import lombok.Data;

/*
 * 목록, 등록, 수정, 삭제, 단건조회
 */

@Data

public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int clickCnt;
	private Date creationDate;
}
