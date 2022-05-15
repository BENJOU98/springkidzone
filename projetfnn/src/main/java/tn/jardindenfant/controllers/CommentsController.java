package tn.jardindenfant.controllers;

import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.*;
import tn.jardindenfant.services.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class CommentsController  {


	@Autowired
	CommentsService comService;
	@Autowired
	CommentsRepository com_rep;
	@PostMapping("/AddComments/{pubId}")
	public String AddPub(@RequestBody Comments com,@PathVariable(value = "pubId") int pubId){
					comService.AddComments(com, pubId);
					return "comments added succesfully";

	}
	@PostMapping("AddLikesComments/{userId}/{comId}")
	public void AddLikeCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddLikesComments(like, user_id, comId);
	}
	@PostMapping("AddloveComments/{userId}/{comId}")
	public void AddloveCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddloveComments(like, user_id, comId);
	}
	@PostMapping("AddhahaComments/{userId}/{comId}")
	public void AddHahaCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddHahaComments(like, user_id, comId);
	}
	@PostMapping("AddsadComments/{userId}/{comId}")
	public void AddsadCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddSadComments(like, user_id, comId);
	}
	@PostMapping("AddangryComments/{userId}/{comId}")
	public void AddangryCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddAngryComments(like, user_id, comId);
	}
	

}
