package com.cai.helppsy.accidentBulleinBoard.controller;


import com.cai.helppsy.accidentBulleinBoard.entity.CommentEntity;
import com.cai.helppsy.accidentBulleinBoard.entity.RegistrationEntity;
import com.cai.helppsy.accidentBulleinBoard.serviece.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommentContorller {

    private final CommentService commentservice;

    // 댓글 저장 (로그인 public String login에서 세션유지하는 값을 클라이언트에서 별칭 뽑아옴)
    @PostMapping("/comment")
        // commententity에는 댓글내용/작성자 별칭(세션값뽑아옴)/글작성번호(글테이블id) 넘겨받음
    public String comment(@ModelAttribute CommentEntity commententity
    , @RequestParam("registrationId") Integer registrationId, Model model){
        commentservice.SaveComment(commententity,registrationId); //댓글테이블에 저장

        // 순서1) 외래키 id로 테이블조회후
        Optional<CommentEntity> comment = commentservice.getComment(registrationId);
        // 순서2) CommentEntity타입으로 가져온 목록을 commentlist에 대입
        CommentEntity commentList = comment.get();
        model.addAttribute("commenet",commentList);

        System.out.println("--------------------------++이거로 확인");
        System.out.println(comment.get());
        System.out.println("--------------------------++이거로 확인");


        return "redirect:/accidentview/"+ registrationId;
    }

}
