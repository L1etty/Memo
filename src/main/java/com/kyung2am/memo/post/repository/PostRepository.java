package com.kyung2am.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kyung2am.memo.post.domain.Post;

@Repository
public interface PostRepository {

	public int insertPost(
			@Param("userId") int userId
			,@Param("title") String title
			,@Param("content") String content
			);
	
	public List<Post> selectPostList(@Param("userId") int userId);
	
	public Post selectPost(@Param("id") int id);
}