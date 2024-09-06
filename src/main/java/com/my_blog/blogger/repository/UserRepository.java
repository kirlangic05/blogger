package com.my_blog.blogger.repository;

import com.my_blog.blogger.model.Useras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Useras,Long> {
}
