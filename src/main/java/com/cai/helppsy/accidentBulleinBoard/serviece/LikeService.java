package com.cai.helppsy.accidentBulleinBoard.serviece;


import com.cai.helppsy.accidentBulleinBoard.DTO.LikeDTO;
import com.cai.helppsy.accidentBulleinBoard.entity.LikeEntity;
import com.cai.helppsy.accidentBulleinBoard.entity.RegistrationEntity;
import com.cai.helppsy.accidentBulleinBoard.repository.LikeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {


    private final LikeRepository likeRepository;

    // 게시글 로드시 좋아요 상태 저장
    public int getLike(String alias, Integer registration_entity_id) {
        return likeRepository.findByAliasAndRegistrationEntityId(alias, registration_entity_id)
                .map(LikeEntity::getLiked) // 조회결과가 있을시 LikeEntity의 getLiked()값을 가져옴
                .orElse(0); // 만약 좋아요 기록이 없다면(=Optional이 비어 있음), 기본값으로 0을 반환합니다.
    }

    // 좋아요 버튼 누름
    @Transactional
    public LikeDTO addLike(String type,String alias, Integer registration_entity_id, int liked) {
        // RegistrationEntity 객체를 만들어 게시글 번호를 입력후 LikeEntity객체에 넣기
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(registration_entity_id);
        // 최초 디비 접근해서 닉네임, registration_entity_id 개사글번호 가 있으면
        Optional<LikeEntity> likeCheck = likeRepository.findByAliasAndRegistrationEntityId(alias, registration_entity_id);
        if(likeCheck.isEmpty()){ // .isEmpty() 값이 없으면 true
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setAlias(alias);
        likeEntity.setType(type);
        likeEntity.setRegistrationEntity(registrationEntity);
        likeEntity.setLiked(liked);
        LikeEntity like = likeRepository.save(likeEntity);
        LikeDTO dto = new LikeDTO(like.getId(), like.getType(), like.getAlias(), like.getLiked());
        return dto;
        }else{
            likeRepository.deleteByAliasAndRegistrationEntityId(alias, registration_entity_id);
            return new LikeDTO(0, type, alias, 0); // 0은 좋아요 취소 상태를 의미
        }
    }
    // 별칭으로 좋아요 테이블 튜플수 가져오기
    public int getLike(String alias){
        int like = 0;
        List<LikeEntity> getLike = likeRepository.findByAlias(alias);
        for (LikeEntity abc : getLike){
            like++;
        }
        return like;
    }

}
