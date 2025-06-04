package com.cai.helppsy.accidentBulleinBoard.serviece;


import com.cai.helppsy.accidentBulleinBoard.DTO.LikeDTO;
import com.cai.helppsy.accidentBulleinBoard.entity.LikeEntity;
import com.cai.helppsy.accidentBulleinBoard.entity.RegistrationEntity;
import com.cai.helppsy.accidentBulleinBoard.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {


    private final LikeRepository likeRepository;

    // 좋아요 버튼 누름
    public LikeDTO addLike(String type,String alias, Integer registration_entity_id, String liked) {
        // RegistrationEntity 객체를 만들어 게시글 번호를 입력후 LikeEntity객체에 넣기
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(registration_entity_id);
        LikeEntity likeEntity = new LikeEntity();
            likeEntity.setAlias(alias);
            likeEntity.setType(type);
            likeEntity.setRegistrationEntity(registrationEntity);
        if ("false".equals(liked)) {
            likeEntity.setLiked(1);
            LikeEntity like = likeRepository.save(likeEntity);
            LikeDTO likeDTO = new LikeDTO(like.getId(),like.getType(),like.getAlias(),like.getLiked());
            return likeDTO;
        } else if (){
            likeEntity.setLiked(0);
        }
            return null;
    }
}
