package com.hibernate.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.spring.entity.Game;
import com.hibernate.spring.entity.Item;
import com.hibernate.spring.service.GameService;

@RestController
@RequestMapping("/api/v2")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@RequestMapping("/creatGameItem/{name}")
	public void creatGameItem(@PathVariable String name) {
		System.out.println("PathValriable : " + name);
		gameService.creatGameItem(name);
	}
	
	@RequestMapping("/getItem")
	public String getItem() {
		System.out.println("/api/v2/getItem");
		System.out.println(gameService.getItem());
		for (Item item : gameService.getItem()) {
			System.out.println(item.getItemId());
		}
		return gameService.getItem().toString();
	}
	
	@RequestMapping("/getGame")
	public String getGame() {
		List<Game> games = gameService.getGame();
		for (Game game : games) {
			for(Item item : game.getItem()) {
				System.out.println(item.getItemId());
			}
		}
		return gameService.getGame().toString();
	}
	
	@RequestMapping("/getItemPage")
	public void getItemPage() {
		gameService.getItemPage();
	}
}
