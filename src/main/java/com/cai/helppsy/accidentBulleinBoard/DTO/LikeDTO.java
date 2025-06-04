package com.cai.helppsy.accidentBulleinBoard.DTO;


import lombok.Getter;

@Getter
public class LikeDTO {

    private Integer id; // 저장 번호
    private String type; // 해당 게시물 타입
    private String alias; // 로그인한 사용자 별명
    private boolean liked; // 좋아요 현재 상태

    public LikeDTO(Integer id, String type, String alias, int liked){
        if(liked==1){
            this.id=id;
            this.type=type;
            this.alias=alias;
            this.liked=true;
        } else if (liked==0) {
            this.id=id;
            this.type=type;
            this.alias=alias;
            this.liked=false;
        }
    }
}
