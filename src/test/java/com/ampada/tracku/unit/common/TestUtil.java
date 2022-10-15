package com.ampada.tracku.unit.common;


import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.user.entity.User;


public class TestUtil {

	public static User getTestUser() {

		return User.builder().username("test").password("test").build();
	}

	public static Board getTestBoard() {

		return Board.builder().boardName("testBoardName").build();
	}

	public static Card getTestCard() {

		return Card.builder().board(getTestBoard()).cardTitle("testCardTitle").build();
	}
}
