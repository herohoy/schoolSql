package com.today36524.school.dao

import com.today36524.school.bean.Clazz
import com.today36524.school.util.ScalaSqlUtil
import wangzx.scala_commons.sql._

object ClassDao {
  def findClassesByGrade(gradeId:String) = {
    ScalaSqlUtil.dataSource.rows[Clazz](
      s"select id,name,classorder,grade_id from bean_clazz where grade_id = $gradeId order by classorder")
  }
  def findClassById(id:String) = {
    ScalaSqlUtil.dataSource.row[Clazz](
      s"select id,name,classorder,grade_id from bean_clazz where id = $id")
  }
}
