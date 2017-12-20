package com.today36524.school.bean

import com.today36524.school.dao.StudentDao

case class Clazz(id:String,name: String,classorder:Int,gradeId:String) {
  def getId = id
  def getName = name
  def getClassorder = classorder
  def getGradeId = gradeId
  def getStudents = StudentDao.findStudentsByClass(id)
}
