//package com.today36524.school.dao
//
//import com.today36524.school.bean.School
//import org.springframework.data.jpa.repository.{JpaRepository, Query}
//
/**
  * 未研究透的写法，使用springboot中的jpa，暂时不知如何结合使用
  */
//trait SchoolDao extends JpaRepository[School,Long]{
//  @Query("select id,name from School")
//  def findWholeList():List[School]
//}
