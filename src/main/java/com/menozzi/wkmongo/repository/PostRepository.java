package com.menozzi.wkmongo.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menozzi.wkmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{


	
}
