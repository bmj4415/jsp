package co.yedam.book.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BookVO {

	private String bookCode;
	private String bookTitle;
	private String author;
	private String company;
	private int price;
	private Date createDate;
}
