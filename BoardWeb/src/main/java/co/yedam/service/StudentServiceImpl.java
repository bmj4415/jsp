package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.MemberVO;
import co.yedam.vo.Student;
import co.yedam.web.MemberList;

public class StudentServiceImpl implements StudentService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도 자동커밋하겠다는 뜻
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	@Override
	public List<Student> studentList() {
		return mapper.selectBlog();
	}
	
	@Override
	public boolean addStudent(Student std) {
		return mapper.insertStudent(std) == 1; //1건이 입력되면 true, 아니면 false
	}

	@Override
	public boolean modifyStudent(Student std) {
		return mapper.updateStudent(std) == 1; //1건이 수정되면 true, 아니면 false
	}

	
}
