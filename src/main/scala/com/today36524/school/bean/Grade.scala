package com.today36524.school.bean

import java.text.SimpleDateFormat
import java.util.Calendar

case class Grade(id:String,level:Int,year:Int,schoolId:String) {
  val sdf:SimpleDateFormat = new SimpleDateFormat("yyyy")
  val grd: Int = sdf.format(Calendar.getInstance().getTime).toInt-year

  def getName:String =
    (if(level==1) """幼"""
    else if(level==2) """小"""
    else if(level==3) """初"""
    else if(level==4) """高"""
    else if(level==5) """专"""
    else if(level==6) """大"""
    else if(level==7) """研"""
    else if(level==8) """博"""
    else """""")+
      (if(grd<1) """一"""
    else if(grd>=1 && grd<2) """二"""
    else if(grd>=2 && grd<3) """三"""
    else if(grd>=3 && grd<4) """四"""
    else if(grd>=4 && grd<5) """五"""
    else if(grd>=5 && grd<6) """六"""
    else year+"级")

  def getId = id
  def getLevel = level
  def getYear = year
  def getSchoolId = schoolId
}
