package co.yedam.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.book.mapper.BookMapper;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DataSource;

public class BookServiceImpl implements BookService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	@Override
	public String cheeringMessage() {
		return mapper.selectMessage();
	}

	@Override
	public String hintMessage() {
		return mapper.selectHint();
	}

	@Override
	public List<BookVO> bookList() {
		return mapper.selectList();
	}
	

	@Override
	public boolean addBook(BookVO bvo) {
		return mapper.insertBook(bvo) == 1;
	}

	@Override
	public boolean removeBook(String bcode) {
		return mapper.deleteBook(bcode) == 1;
	}
}
