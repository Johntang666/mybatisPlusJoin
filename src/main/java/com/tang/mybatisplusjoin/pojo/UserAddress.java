package com.tang.mybatisplusjoin.pojo;

import lombok.Data;

@Data
public class UserAddress {

  private long id;
  private long userId;
  private long areaId;
  private String tel;
  private String address;
  private String del;
}
