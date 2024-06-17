package co.yedam.service;
/*
 * 업무프로세스를 따라 실행하기 위한 서비스
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도
																		// 자동커밋하겠다는 뜻
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchVO search) {
		// mapper로 등록된 기능 활용
		return mapper.boardListPaging(search);
	}

	@Override
	public int boardTotal(SearchVO search) {
		return mapper.getTotalCnt(search);
	}

	@Override
	public BoardVO getBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo) == 1;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public boolean insertMember(String id, String pw, String name) {
		return mapper.insertMember(id, pw, name) == 1;
	}

}
