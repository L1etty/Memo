package com.kyung2am.memo.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung2am.memo.post.domain.Post;
import com.kyung2am.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public int addPost(int userID, String title, String content) {
		
		return postRepository.insertPost(userID, title, content);
	}
	
	public List<Post> getPostList(int UserId) {
		
		return postRepository.selectPostList(UserId);
	}
	
	public Post getPost(int id) {
		return postRepository.selectPost(id);
	}
	
}
