package com.limyel.blog.dao;

import com.limyel.blog.model.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findByIdIn(List<Long> ids);

    TagEntity findBySlug(String slug);

}
