package com.today36524.school.dao

import com.today36524.school.bean.Lesson
import com.today36524.school.util.ScalaSqlUtil
import wangzx.scala_commons.sql._

object LessonDao {
  def findAllLessons = ScalaSqlUtil.dataSource.rows[Lesson](
    "select name,namecn,lessonorder from bean_lesson order by lessonorder")
  def findLessonByName(name:String) = ScalaSqlUtil.dataSource.row[Lesson](
    s"select name,namecn,lessonorder from bean_lesson where name=$name")
}
