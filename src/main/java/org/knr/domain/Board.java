package org.knr.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="board") // mongoDB document에서 collection은 board 이다
public class Board {
	@Id
	private Long bno;
	private String title;
	private String content;
	private String writer;	
}
