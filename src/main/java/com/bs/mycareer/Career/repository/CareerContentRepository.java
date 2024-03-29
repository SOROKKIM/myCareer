package com.bs.mycareer.Career.repository;

import com.bs.mycareer.Career.entity.Career;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Jpa를 상속하면 ContentSave는 Career save하는 함수를 자동으로 할당해준다...(개사기네)
@Repository

public interface CareerContentRepository extends JpaRepository<Career, Integer> {

    List<Career> findAllByAvailableTrue(Sort sort); //전체 글 조회
    Optional<Career> findCareerById(Long id); //id 별 글 조회

}

