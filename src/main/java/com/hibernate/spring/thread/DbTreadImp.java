package com.hibernate.spring.thread;

import com.hibernate.spring.entity.Team;
import com.hibernate.spring.repository.TeamRepository;

public class DbTreadImp implements Runnable{
	
	TeamRepository teamRepository;
	
	public DbTreadImp(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Override
	public void run() {
		String thread_name = Thread.currentThread().getName();
		System.out.println(thread_name);
		System.out.println(thread_name.indexOf("pool-1-thread-3"));
		if (thread_name.indexOf("pool-1-thread-3") > -1) {
			System.out.println("rollback");
			throw new RuntimeException("test execption");
		}
		Team team = new Team();
		team.setTeam_name("ateam");
		teamRepository.save(team);
	}
}
