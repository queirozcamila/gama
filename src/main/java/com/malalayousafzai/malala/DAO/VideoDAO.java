package com.malalayousafzai.malala.DAO;


import com.malalayousafzai.malala.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoDAO extends JpaRepository<Video, Integer> {

}
