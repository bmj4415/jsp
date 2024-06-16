package co.yedam.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int clickCnt;
	private Date creationDate;
}
/*
 * 목록, 등록, 수정, 삭제, 단건조회
 */