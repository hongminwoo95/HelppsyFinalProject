package com.cai.helppsy.accidentBulleinBoard.repository;


import com.cai.helppsy.accidentBulleinBoard.entity.LikeEntity;
import com.cai.helppsy.accidentBulleinBoard.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeEntity,Integer> {
    // 특정 사용자와 게시글에 대한 좋아요 존재 여부 확인
    // id로 조회하기
    Optional<LikeEntity> findByAliasAndRegistrationEntityId(
            String alias, Integer registration_entity_id);

    // id로 삭제하기
    void deleteByAliasAndRegistrationEntityId(
            String alias, Integer registration_entity_id);

    // id로 좋아요 갯수 가져오기
    List<LikeEntity> findByAlias(String alias);
}
