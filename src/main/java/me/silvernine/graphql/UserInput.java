package me.silvernine.graphql;

import lombok.Data;

@Data
public class UserInput {
	   private Long userId;
	   private String username;
	   private String password;
	   private String nickname;
	   private boolean activated;
}
