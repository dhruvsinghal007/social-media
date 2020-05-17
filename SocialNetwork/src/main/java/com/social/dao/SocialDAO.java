package com.social.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.social.entity.FriendEntity;
import com.social.entity.UserEntity;

@Transactional
@Repository
public class SocialDAO implements ISocialDAO {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsersByPageNumber(int pageNumber, int pageLength) {
		String sql = "select * FROM user LIMIT :offset, :length";
		List<Object[]> objArray = em.createNativeQuery(sql).setParameter("offset", (pageNumber - 1) * pageLength).setParameter("length", pageLength).getResultList();
		List<UserEntity> entities = new ArrayList<>();
		objArray.forEach(obj -> {
			UserEntity entity = new UserEntity();
			entity.setId(StringUtils.isEmpty(obj[0]) ? 0 : Integer.parseInt("" + obj[0]));
			entity.setFirstName(StringUtils.isEmpty(obj[1]) ? "" : "" + obj[1]);
			entity.setLastName(StringUtils.isEmpty(obj[2]) ? "" : "" + obj[2]);
			entity.setAvatar(StringUtils.isEmpty(obj[3]) ? "" : "" + obj[3]);
			entities.add(entity);
		});
		return entities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsersByIds(List<Integer> ids) {
		String sql = "FROM UserEntity WHERE id in :ids";
		return em.createQuery(sql).setParameter("ids", ids).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FriendEntity> getFriendsOfUsers(List<Integer> ids) {
		String sql = "FROM FriendEntity WHERE userId in :ids";
		return em.createQuery(sql).setParameter("ids", ids).getResultList();
	}

}
