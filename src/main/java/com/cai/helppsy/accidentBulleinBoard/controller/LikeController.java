package com.cai.helppsy.accidentBulleinBoard.controller;


import com.cai.helppsy.accidentBulleinBoard.DTO.LikeDTO;
import com.cai.helppsy.accidentBulleinBoard.entity.LikeEntity;
import com.cai.helppsy.accidentBulleinBoard.serviece.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    // 좋아요 저장
    @PostMapping("/like")
    @ResponseBody
    public LikeDTO like(@RequestParam("type") String type,
                        @RequestParam("alias") String alias,
                        @RequestParam("registration_entity_id") Integer registration_entity_id,
                        @RequestParam("liked") String liked){

        return likeService.addLike(type,alias,registration_entity_id,liked);
    }

}
