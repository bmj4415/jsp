package co.yedam.service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	//목록, 단건조회, 입력, 삭제
	List<ReplyVO> replyList(int boardNo);
	ReplyVO getReply(int replyNo);
	boolean registerReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
}
