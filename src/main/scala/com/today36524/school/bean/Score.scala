package com.today36524.school.bean

import com.today36524.school.dao.{LessonDao, StudentDao}

/**
  * 分数
 *
  * @param studentId 学生
  * @param lessonName 课程名
  * @param point 分数
  */
case class Score(studentId:String,lessonName:String,point:Int) {
  def getStudentId = studentId
  def getLessonName = lessonName
  def getPoint = point

  def getStudent = StudentDao.findStudentById(studentId)
  def getLesson = LessonDao.findLessonByName(lessonName)
}
