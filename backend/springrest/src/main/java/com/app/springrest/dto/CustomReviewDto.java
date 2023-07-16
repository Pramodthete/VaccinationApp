package com.app.springrest.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomReviewDto {
  private List<User> ulist = new ArrayList<>();
  
  private List<Center> clist = new ArrayList<>();
  
}
