package com.example.week3_homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HmRepository extends JpaRepository<Hm,Long> {
    List<Hm> findAllByOrderByModifiedAtDesc();  //findAllByOrderByModifiedAtDesc 수정된 날짜를 기준으로 정렬해줘리
}
