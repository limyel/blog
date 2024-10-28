package com.limyel.blog.dao;

import com.limyel.blog.model.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {



}
