package com.ampada.tracku.card.entity;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.common.entity.AbstractEntity;
import com.ampada.tracku.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card extends AbstractEntity {

	@NotBlank(message = "cardTitle cannot be blank!")
	private String cardTitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id")
	private Board board;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_cards", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
	private Set<User> users;

	public List<String> getUserIds() {

		if (users != null && !users.isEmpty()){
			return users.stream().map(User::getId).collect(Collectors.toList());
		}
		return null;
	}

}
