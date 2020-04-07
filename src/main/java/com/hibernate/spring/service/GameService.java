package com.hibernate.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.spring.entity.Game;
import com.hibernate.spring.entity.Item;
import com.hibernate.spring.repository.GameRepository;
import com.hibernate.spring.repository.GameRepositorySupport;
import com.hibernate.spring.repository.ItemRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	GameRepositorySupport gameSupport;
	
	public void creatGameItem(String name) {
		Game game = new Game();
		Item item = new Item();
		game.setGame_name(name);
		item.setGame(game);
		itemRepository.save(item);
	}
	
	public List<Item> getItem() {
		return gameSupport.getItem();
	}
	
	public List<Game> getGame() {
		return gameSupport.getGame();
	}
}
