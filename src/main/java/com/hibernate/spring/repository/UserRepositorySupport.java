package com.hibernate.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.hibernate.spring.entity.QAllParent;
import com.hibernate.spring.entity.QTeam;
import com.hibernate.spring.entity.QUser;
import com.hibernate.spring.entity.QUserService;
import com.hibernate.spring.entity.User;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport{
	private final JPAQueryFactory queryFactory;
	
	public UserRepositorySupport(JPAQueryFactory queryFactory) {
		super(User.class);
		this.queryFactory = queryFactory;
	}

	public List<User> QfindByUsername(String name) {
		QUser user = QUser.user;
		return queryFactory.selectFrom(user).where(user.username.eq(name)).fetch();
	}
	
	public List<User> orderBy() {
		QUser user = QUser.user;
		List<User> items = queryFactory.selectFrom(user).where(user.username.eq("aaaa")).orderBy(user.usernumber.desc()).fetch();
		return items;
	}
	
	public void join() {
		QUser user = QUser.user;
		QTeam team = QTeam.team;
		System.out.println("join");
		List<User> list = (List<User>) queryFactory.from(user).innerJoin(user.team, team).fetchJoin().fetch();
//		List list = queryFactory.from(user).innerJoin(user.team, team).fetch();
		System.out.println(list);
	}
	
	public void serviceJoin() {
		QUserService userService = QUserService.userService;
		QTeam team = QTeam.team;
		System.out.println(queryFactory.from(userService).innerJoin(userService.Team, team).fetchJoin().fetch());
	}
	
	public void whereIn() {
		QAllParent ap = QAllParent.allParent;
		System.out.println(ap);
		QUser user = QUser.user;
		OrderSpecifier<Long> or = user.usernumber.asc();
		System.out.println("or : " + or);
		List<User> items = queryFactory.select(user).from(user).where(user.parent.parent_id.in(queryFactory.select(ap.parent_id).from(ap))).orderBy(or).fetch();
		
		for(User item : items) {
			System.out.println(item.getParent().getParent_name());
		}
	}
	
	public void twoJoin() {
		QUser quser = QUser.user;
		QAllParent qall = QAllParent.allParent;
		QUserService qservice = QUserService.userService; 
		System.out.println(queryFactory.selectFrom(quser).innerJoin(quser, qservice.user).fetch());
//		System.out.println(queryFactory.selectFrom(quser).innerJoin(quser.parent, qall).innerJoin(qservice.user, quser));
	}
}
