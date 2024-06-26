package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

/*
 * 목록, 단건조회, 등록, 수정, 삭제 기능 구현
 * 기능의 실행 => mapper에서
 */

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int boardTotal(SearchVO search);
	BoardVO getBoard(int bno); //단건조회
	boolean addBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);
	
	
	//checkMember(id, pw)
	MemberVO checkMember(String id, String pw);
	
	//파일첨부 회원등록
	boolean addMemberImage(MemberVO mvo);
	
	
	List<MemberVO> memberList();
	boolean addMemberAjax(MemberVO mvo);
	boolean checkMemberId(String id); //문자열로 사용자 아이디를 넘겨주면
	boolean delMemberAjax(String id);
	boolean modifyAjax(String id);
}
