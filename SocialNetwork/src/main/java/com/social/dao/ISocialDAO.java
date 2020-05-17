package com.social.dao;

import java.util.List;

import com.social.entity.FriendEntity;
import com.social.entity.UserEntity;

public interface ISocialDAO {
	List<UserEntity> getUsersByPageNumber(int pageNumber, int pageLength);

	List<UserEntity> getUsersByIds(List<Integer> ids);

	List<FriendEntity> getFriendsOfUsers(List<Integer> ids);

}
