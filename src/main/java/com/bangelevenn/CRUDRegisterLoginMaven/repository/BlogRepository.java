package com.bangelevenn.CRUDRegisterLoginMaven.repository;

import com.bangelevenn.CRUDRegisterLoginMaven.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {}
