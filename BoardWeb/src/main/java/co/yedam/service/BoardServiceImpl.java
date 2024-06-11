package co.yedam.service;
/*
 * 업무프로세스를 따라 실행하기 위한 서비스
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도 자동커밋하겠다는 뜻
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList(){
		//mapper로 등록된 기능 활용
		return mapper.boardList();
	}
	
	@Override
	public BoardVO getBoard(int bno) {
		return null;
	}
	
	@Override
	public boolean addBoard(BoardVO bvo) {
		return false;
	}
	
	@Override
	public boolean editBoard(BoardVO bvo) {
		return false;
	}
	
	@Override
	public boolean removeBoard(int bno) {
		return false;
	}
	
	
	
}
