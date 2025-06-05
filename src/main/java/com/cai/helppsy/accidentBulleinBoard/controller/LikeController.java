package com.cai.helppsy.accidentBulleinBoard.controller;


import com.cai.helppsy.accidentBulleinBoard.DTO.LikeDTO;
import com.cai.helppsy.accidentBulleinBoard.serviece.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    // 게시글 페이지 로드시 좋아요 자동갱신
    @PostMapping("/like/revert")
    @ResponseBody
    public int likerevert(@RequestParam("alias") String alias,
                          @RequestParam("registration_entity_id") Integer registration_entity_id,
                          @ModelAttribute Model model){
        int getLike = likeService.getLike(alias); // 좋아요 개수 가져오기
        model.addAttribute("getLike",getLike);
        return likeService.getLike(alias,registration_entity_id);
    }

    // 좋아요 저장
    @PostMapping("/like")
    @ResponseBody
    public LikeDTO like(@RequestParam("type") String type,
                        @RequestParam("alias") String alias,
                        @RequestParam("registration_entity_id") Integer registration_entity_id,
                        @RequestParam("liked") int liked){
        return likeService.addLike(type,alias,registration_entity_id,liked);
    }




}
