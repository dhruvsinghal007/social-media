package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.data.User;
import com.social.service.ISocialService;

@RestController
public class SocialController {

	@Autowired
	ISocialService socialService;
	
	@GetMapping("users")
	public @ResponseBody List<User> getUsersForPageNumber(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageLength") int pageLength) {
		return socialService.getUsersByPageNumber(pageNumber, pageLength);
	}

	@GetMapping("users/{id}/friends")
	public @ResponseBody List<User> getFriendsOfUser(@PathVariable("id") String id) {
		return socialService.getFriendsOfUser(id);
	}

	@GetMapping("users/{id}/friendsoffriends")
	public @ResponseBody List<User> getFriendsOfFriendsOfUser(@PathVariable("id") String id) {
		return socialService.getFriendsOfFriendsOfUser(id);
	}
}
