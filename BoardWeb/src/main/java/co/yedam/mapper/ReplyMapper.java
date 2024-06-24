package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.CenterVO;
import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	//목록, 단건조회, 등록, 삭제
	List<ReplyVO> selectList(int boardNo);
	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	ReplyVO selectReply(int replyNo); //단건조회
	int insertReply(ReplyVO rvo); //등록
	int deleteReply(int replyNo); //삭제
	
	//댓글건수
	int selectReplyCnt (int bno);
	
	//센터정보 생성
	int insertCenter(CenterVO[] array);
	
	//시,도별 센터갯수 차트
	List<Map<String, Object>> centerBysido(); //map 타입의 값이 여러건 들어오기 때문에 List타입이어야함
}//전체 파일의 키값을 가지고 오기때문에 매개값은 따로 주지 않아도 됨
