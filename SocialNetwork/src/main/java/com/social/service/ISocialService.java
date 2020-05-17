package com.social.service;

import java.util.List;

import com.social.data.User;

public interface ISocialService {
	List<User> getUsersByPageNumber(int pageNumber, int pageLength);

	List<User> getFriendsOfUser(String id);

	List<User> getFriendsOfFriendsOfUser(String id);
}
