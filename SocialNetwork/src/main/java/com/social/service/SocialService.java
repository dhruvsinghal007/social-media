package com.social.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ISocialDAO;
import com.social.data.User;
import com.social.entity.FriendEntity;
import com.social.entity.UserEntity;

@Service
public class SocialService implements ISocialService {
	
	@Autowired
	private ISocialDAO socialDAO;

	@Override
	public List<User> getUsersByPageNumber(int pageNumber, int pageLength) {
		List<User> users = new ArrayList<>();
		List<UserEntity> userEntities = socialDAO.getUsersByPageNumber(pageNumber, pageLength);
		userEntities.forEach(entity -> {
			User user = new User();
			user.setId(entity.getId());
			user.setFirstName(entity.getFirstName());
			user.setLastName(entity.getLastName());
			user.setAvatar(entity.getAvatar());
			users.add(user);
		});
		return users;
	}

	@Override
	public List<User> getFriendsOfUser(String id) {
		List<Integer> ids = new ArrayList<>();
		ids.add(Integer.parseInt(id));
		List<FriendEntity> friendEntities = socialDAO.getFriendsOfUsers(ids);
		ids.clear();
		friendEntities.forEach(friendEntity -> {
			ids.add(friendEntity.getFriendId());
		});
		List<User> users = new ArrayList<>();
		if(ids.size() > 0) {
			List<UserEntity> userEntities = socialDAO.getUsersByIds(ids);
			userEntities.forEach(entity -> {
				User user = new User();
				user.setId(entity.getId());
				user.setFirstName(entity.getFirstName());
				user.setLastName(entity.getLastName());
				user.setAvatar(entity.getAvatar());
				users.add(user);
			});
		}
		return users;
	}

	@Override
	public List<User> getFriendsOfFriendsOfUser(String id) {
		List<Integer> ids = new ArrayList<>();
		ids.add(Integer.parseInt(id));
		List<FriendEntity> friendEntities = socialDAO.getFriendsOfUsers(ids);
		List<FriendEntity> friendsOfFriendsEntities;
		ids.clear();
		friendEntities.forEach(friendEntity -> {
			ids.add(friendEntity.getFriendId());
		});
		List<User> users = new ArrayList<>();
		if(ids.size() > 0) {
			friendsOfFriendsEntities = socialDAO.getFriendsOfUsers(ids);
			ids.clear();
			friendsOfFriendsEntities.forEach(friendsOfFriendsEntity -> {
				ids.add(friendsOfFriendsEntity.getFriendId());
			});
			if(ids.size() > 0) {
				List<UserEntity> userEntities = socialDAO.getUsersByIds(ids);
				userEntities.forEach(entity -> {
					User user = new User();
					user.setId(entity.getId());
					user.setFirstName(entity.getFirstName());
					user.setLastName(entity.getLastName());
					user.setAvatar(entity.getAvatar());
					users.add(user);
				});
			}
		}
		return users;
	}

}
