package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Student;

public interface StudentMapper {
	public List<Student> selectBlog(); // 반환되는 타입들을 여러가지 만들기 위해 리스트형식으로하고 반환타입을 co.yedam.vo.Student이 아닌 Student로
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(Student stdNo);
	
	//단건조회(목록 중 한개의 값만 가져오기)
	public Student getStudent(String stdNo); //특정 stdNo의 값만 조회
	
}//
