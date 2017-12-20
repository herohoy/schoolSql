package com.today36524.school.bean

import com.today36524.school.dao.ScoreDao

case class Student(id:String,name:String,sex:String,classId: String) {
  def getId = id
  def getName = name
  def getSex = sex
  def getClassId = classId
  def getScores = ScoreDao.findScoresByStudentId(id)
  def getSexCn: String = sex match {
    case "1" => "男"
    case "2" => "女"
    case _ => "未设置"
  }
}
