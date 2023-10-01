package com.tang.mybatisplusjoin.pojo;

import lombok.Data;

@Data
public class User {

  private long id;
  private String name;
  private long addressId;
  private long sex;
  private String headImg;
  private String del;
}
