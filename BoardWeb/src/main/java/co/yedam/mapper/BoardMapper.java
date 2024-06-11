package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	int inserBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);
}
