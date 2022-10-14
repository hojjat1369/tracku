package com.ampada.tracku.board.entity;


import javax.jdo.annotations.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ampada.tracku.common.entity.AbstractEntity;

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
public class Board extends AbstractEntity {

	@NotBlank(message = "boardName cannot be blank!")
	private String boardName;
	@Column(name = "creator_id")
	private Long creatorId;

}
