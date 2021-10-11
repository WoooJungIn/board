package com.example.board.services;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardServiceTest {

    /*@Service
public interface BoardService {
    public void register(BoardVO board);
    public BoardVO get(Long bno);
    public boolean modify(BoardVO board);
    public boolean remove(Long bno);
    public List<BoardVO> getList();
}*/

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("수정된 글 제목4");
        board.setContent("수정된 내용4");
        board.setWriter("user03");

        boardService.register(board);
        log.info("-------------------------------------");
        log.info(board.getBno() + "");
        log.info("-------------------------------------");
    }
    @Test
    public void testGet(){
        log.info(boardService.get(21L).toString());
    }

    @Test
    public void testModify(){
        BoardVO board = new BoardVO();
        board.setBno(21L);
        board.setTitle("수정된 글 제목20");
        board.setContent("수정된 내용20");
        log.info("UPDATE : " + boardService.modify(board));
    }

    @Test
    public void testRemove(){
        log.info("DELETE : " + boardService.remove(100L));
    }

    @Test
    public void testGetList(){
        boardService.getList().forEach(board -> log.info(board.toString()));
    }
}
