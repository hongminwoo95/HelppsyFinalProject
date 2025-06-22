package com.cai.helppsy.accidentBulleinBoard.repository;

import com.cai.helppsy.accidentBulleinBoard.entity.RegistrationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Integer> {
    List<RegistrationEntity> findAll(); // 전체출력

    Optional<RegistrationEntity> findById(Integer id); // id로 조회하기

    Optional<RegistrationEntity> findByIdAndAlias(Integer id, String alias); // 게시물 수정

    Page<RegistrationEntity> findByAccident(String accident, Pageable pageable); // 카테고리별 페이징 보여주기
}