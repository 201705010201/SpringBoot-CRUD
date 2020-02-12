package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 */
//@Data：作用于类上，是以下注解的集合：
// @ToString @EqualsAndHashCode @Getter @Setter @RequiredArgsConstructor
@Data
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造
public class Department {

    private Integer id;

    private String departmentName;


}
