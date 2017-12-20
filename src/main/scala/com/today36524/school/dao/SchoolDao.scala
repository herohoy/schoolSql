package com.today36524.school.dao

import com.today36524.school.util.ScalaSqlUtil
import com.today36524.school.bean.School
//import org.springframework.data.jpa.repository.{JpaRepository, Query}
//
/**
  * 未研究透的写法，使用springboot中的jpa，暂时不知如何结合使用
  */
//trait SchoolDao extends JpaRepository[School,Long]{
//  @Query("select id,name from School")
//  def findWholeList():List[School]
//}

/**
  * 新写法
  */
object SchoolDao {
  def findAllSchool: List[School]
  = ScalaSqlUtil.dataSource.rows[School](
    "select id,name from bean_school")
  def findSchoolById(id:String): Option[School]
  = ScalaSqlUtil.dataSource.row[School](s"select id,name from bean_school where id=$id")
}
