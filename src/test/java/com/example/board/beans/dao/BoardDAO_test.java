package com.example.board.beans.dao;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAO_test {
    @Autowired
    BoardDAO boardDAO;

    @Test
    public void testRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글 4");
        board.setContent("새로 작성하는 내용 4");
        board.setWriter("woojisi");
        boardDAO.register(board);
        log.info("---------------------------------------------");
        log.info(board.getBno() + "");
        log.info("---------------------------------------------");
    }

    @Test
    public void testGet(){
        log.info(boardDAO.get(27L).toString());
    }
    @Test
    public void testModify(){
        if(boardDAO.get(27L) == null){
            log.info("*****NO SUCH BOARD*****");
        }else {
            BoardVO board = new BoardVO();
            board.setBno(27L);
            board.setTitle("수정된 글 제목");
            board.setContent("수정된 내용");
            board.setWriter("user01");

            log.info("UPDATE : " + boardDAO.modify(board));
        }
    }
    @Test
    public void testRemove(){
        if(boardDAO.get(27L) == null){
            log.info("*****NO SUCH BOARD*****");
        }else {
            log.info("REMOVE : " + boardDAO.remove(27L));
        }
    }
    @Test
    public void testGetList(){
        boardDAO.getList().forEach(board ->log.info(board.toString()));
    }
}
