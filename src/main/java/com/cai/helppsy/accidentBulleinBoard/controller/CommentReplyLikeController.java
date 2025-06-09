package com.cai.helppsy.accidentBulleinBoard.controller;


import com.cai.helppsy.accidentBulleinBoard.DTO.CommentLikeDTO;
import com.cai.helppsy.accidentBulleinBoard.DTO.ReplyLikeDTO;
import com.cai.helppsy.accidentBulleinBoard.serviece.CommentReplyLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CommentReplyLikeController {

    private final CommentReplyLikeService commentReplyLikeService;

    // 좋아요 저장 --  entity,dto 저장 이후 기능에 맞춰 한번의 로직으로 해결
    @PostMapping("/replylike")
    @ResponseBody // JSON으로 비동기 처리시 꼭 넣어주기!!! 이거뺴먹어서 2시간 날림
    public Map<String, Object> Commentlike(@RequestParam("type") String type,
                                           @RequestParam("replyalias") String alias,
                                           @RequestParam("replyId") Integer replyId,
                                           @RequestParam("liked") Integer liked){
        System.out.println("-------------------대댓글 좋아요 여기");
        System.out.println(type);
        System.out.println(alias);
        System.out.println(replyId);
        System.out.println(liked);

        ReplyLikeDTO replyLikeDTO = commentReplyLikeService.addRelyLike(type, alias, replyId,liked);
        int CommentlikedStatus = replyLikeDTO.getLiked(); // 좋아요 상태 여부 0(없음),1(좋아요)
        int CommentlikeCount = commentReplyLikeService.LikeCount(replyId);

        // HashMap으로 결과값 2개를 보내기 (Object는 자바에서 지원하는 모든 자료형을 사용할 수 있음)
        Map<String, Object> result = new HashMap<>();
        result.put("ReplylikedStatus", CommentlikedStatus);
        result.put("ReplylikeCount", CommentlikeCount);
        return  result;
    }

    // 새로고침 좋아요
    @PostMapping("/replylike/revert")
    @ResponseBody
    public Map<String, Object> Commentlikerevert(@RequestParam("replyalias") String alias,
                                           @RequestParam("replyId") Integer replyId){

        int CommentlikedStatus = commentReplyLikeService.getReplyLike(alias,replyId); // 좋아요 상태 여부 0(없음),1(좋아요)
        int CommentlikeCount = commentReplyLikeService.LikeCount(replyId); // 좋아요 총 개수

        // HashMap으로 결과값 2개를 보내기 (Object는 자바에서 지원하는 모든 자료형을 사용할 수 있음)
        Map<String, Object> result = new HashMap<>();
        result.put("ReplylikedStatus", CommentlikedStatus);
        result.put("ReplylikeCount", CommentlikeCount);
        return  result;
    }


}
