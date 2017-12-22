package com.today36524.school.dao

import com.today36524.school.bean.Grade
import com.today36524.school.util.ScalaSqlUtil
import wangzx.scala_commons.sql._


object GradeDao {
  def findGradesBySchool(schoolId:String) = {
    ScalaSqlUtil.dataSource.rows[Grade](
      s"select id,level,year,school_id from bean_grade where school_id = $schoolId")
  }
  def findGradeById(id:String) = {
    ScalaSqlUtil.dataSource.row[Grade](
      s"select id,level,year,school_id from bean_grade where id = $id")
  }
}
