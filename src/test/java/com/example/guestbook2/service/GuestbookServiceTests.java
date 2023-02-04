package com.example.guestbook2.service;

import com.example.guestbook2.dto.GuestbookDTO;
import com.example.guestbook2.dto.PageRequestDTO;
import com.example.guestbook2.dto.PageResultDTO;
import com.example.guestbook2.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister(){

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("sample title...")
                .content("sample content...")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
        System.out.println("prev : " + resultDTO.isPrev());
        System.out.println("next : " + resultDTO.isNext());
        System.out.println("total : " + resultDTO.getTotalPage());
        System.out.println("-----------------------------------------");
        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }

        System.out.println("-------------------------------------------");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Test
    public void testSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("한글")
                .build();
        PageResultDTO<GuestbookDTO,Guestbook> resultDTO = service.getList(pageRequestDTO);
        System.out.println("prev....."+resultDTO.isPrev());
        System.out.println("next....."+resultDTO.isNext());
        System.out.println("total...."+resultDTO.getTotalPage());

        System.out.println("------------------------------------------");
        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println(guestbookDTO);
        }
        System.out.println("=============================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
