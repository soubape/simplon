//package com.many.to.many.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.many.to.many.model.Tag;
//import com.many.to.many.repository.TagRepository;
//
//@RestController
//@RequestMapping("api/v1/tag")
//public class TagController {
//
//	
//	@Autowired
//	private TagRepository tagRepository;
//	
//	@PostMapping
//	public Tag create(@RequestBody Tag tag) {
//		return tagRepository.save(tag);
//	}
//	
//}
