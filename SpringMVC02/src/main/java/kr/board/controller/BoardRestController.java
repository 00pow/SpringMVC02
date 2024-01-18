package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")
@RestController	// @ResponseBody(JSON)응답 포함
public class BoardRestController {
	
		@Autowired
		BoardMapper boardMapper;
	
		// @ResponseBody->jackson-databind(객체를-> JSON 데이터포멧으로 변환)
		@RequestMapping("/boardList.do")
		public List<Board> boardList(){
			List<Board> list=boardMapper.getLists();
			return list;	// @ResponseBody :   JSON 데이터 형식으로 변환(API)해서 리턴(응답)하겠다.
		}
		
		@RequestMapping("/boardInsert.do")
		public void boardInsert(Board vo) {
			boardMapper.boardInsert(vo); // 등록성공
		}
		
		@RequestMapping("/boardDelete.do")
		public void boardDelete(@RequestParam("idx") int idx) {
			boardMapper.boardDelete(idx);
		}
		
		@RequestMapping("/boardUpdate.do")
		public void boardUpdate(Board vo) {
			boardMapper.boardUpdate(vo);
		}
		
		@RequestMapping("/boardContent.do")
		public Board boardContent(int idx) {
			Board vo=boardMapper.boardContent(idx);
			return vo; // vo->JSON 
		}
		
		@RequestMapping("/boardCount.do")
		public Board boardCount(int idx) {
			boardMapper.boardCount(idx);
			Board vo = boardMapper.boardContent(idx);
			return vo;
		}
}
