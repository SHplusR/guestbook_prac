package com.example.guestbook2.service;

import com.example.guestbook2.dto.GuestbookDTO;
import com.example.guestbook2.dto.PageRequestDTO;
import com.example.guestbook2.dto.PageResultDTO;
import com.example.guestbook2.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);
    GuestbookDTO read(Long gno);

    void remove(Long gno);
    void modify(GuestbookDTO dto);

    //dto를 entity로 바꾸는 작업
    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    //entity를 dto로 바꾸는 작업
    default GuestbookDTO entityToDto (Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

}
