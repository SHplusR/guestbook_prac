package com.example.guestbook2.entity;

import javax.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guestbook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String content;

    @Column(length = 50,nullable = false)
    private String writer;

    //title수정
    public void changeTitle(String title){
        this.title = title;
    }

    //content수정
    public void changeContent(String content){
        this.content = content;
    }

    //test
}
