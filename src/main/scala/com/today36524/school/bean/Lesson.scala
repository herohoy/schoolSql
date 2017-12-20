package com.today36524.school.bean

/**
  * 课程
  * @param name 名称（主键）
  * @param namecn 中文名
  * @param lessonorder 排序号
  */
case class Lesson(name:String,namecn:String,lessonorder:Int) {
  def getName = name
  def getNamecn = namecn
  def getLessonorder = lessonorder
}
