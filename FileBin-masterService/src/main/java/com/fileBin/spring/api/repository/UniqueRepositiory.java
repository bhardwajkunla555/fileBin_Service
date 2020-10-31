package com.fileBin.spring.api.repository;


import com.fileBin.spring.api.model.UniqueKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueRepositiory extends JpaRepository<UniqueKey, String> {
    @Query("SELECT u FROM file_table u WHERE u.unique_key = ?1")
    UniqueKey findById(String key);
}
