package co.yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends DAO {
	//등록, 삭제, 수정, 목록 기능 구현
	boolean insertStudent(Student std) { //student 타입으로 값을 받아서 boolean으로 처리
		getConnection();
		String sql = "insert into tbl_student(std_no, std_name, phone, bld_type) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getPhone());
			psmt.setString(4, std.getBldType());
			if(psmt.executeUpdate() == 1) { //정상적으로 처리된 건수 == 1
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 사용한 자원들을 해제하는 의미(리소스)
	    }
		
		return false; // 입력 처리 중 에러발생시 false
	}//end of insertStudent
	
	boolean updateStudent(Student std) {
		getConnection();
		String sql = "update tbl_student set phone = ? where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getPhone());
			psmt.setString(2, std.getStdNo());
			if(psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 사용한 자원들을 해제하는 의미(리소스)
		}
	
	return false;
	}//end of updateStudent
	
	
	boolean deleteStudent(String stdNo) {
		getConnection();
		String sql = "delete from tbl_student where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo); //첫번째 파라미터(매개변수)의 매개값으로 넘어온 값을 넣어 쿼리를 완성하겠다
			if(psmt.executeUpdate() == 1) { //처리된 건수 == 1
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 사용한 자원들을 해제하는 의미(리소스)
		}
		return false;
	} // end of deleteStudent
	
	
	
	
	List<Student>studentList() {
		getConnection(); //Connection 객체(세션)
		String sql = "select * from tbl_student order by std_no";//DAO에 선언한 필드를 상속받아 사용
		List<Student> students = new ArrayList<>();//윗줄에서 처리된 결과를 students 변수에 저장
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 루핑을 돌며 조회된 결과목록을 List<Student>에 담아서 반환
			while(rs.next()) { //루핑
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));//setStdNo 매개값으로
				std.setStdName(rs.getString("std_name"));
				std.setPhone(rs.getString("phone"));
				std.setBldType(rs.getString("bld_type"));
				std.setCreateDate(rs.getString("create_date"));
				
				students.add(std); // 데이터베이스의 조회값 하나를 List에 담아줌.
			}
			
 		} catch (SQLException e) {
			e.printStackTrace();
 		} finally {
			disconn(); // 사용한 자원들을 해제하는 의미(리소스)
		}
		return students; //students에 리턴
	} 
	
}//
