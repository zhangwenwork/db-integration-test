package com.blog;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper
public interface BlogMapper {
    Optional<BlogPO> findById(@Param("id") String id);

    void update(@Param("blog") BlogPO blog);

    void insert(@Param("blog") BlogPO blog);

    boolean existsById(@Param("id") String id);

    void deleteById(@Param("id") String id);

}
