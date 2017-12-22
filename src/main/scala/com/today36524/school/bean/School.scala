package com.today36524.school.bean

import com.today36524.school.dao.GradeDao

//import javax.persistence.{Column, Entity, Id, Table}
//
//import com.fasterxml.jackson.databind.BeanProperty
//
//@Entity
//@Table{val name="bean_school",val catalog="school"}
case class School(
//                  @Id
//                  @Column{val name = "id", val unique = true, val nullable = false}
//                  @BeanProperty
                  id:String,
//                  @Id
//                  @Column{val name = "name", val unique = false, val nullable = true}
//                  @BeanProperty
                  name:String) {
  def getId = id
  def getName = name

  def getGrades = GradeDao.findGradesBySchool(id)

  /**
    * 默认构造的声明
    * @return
    */
  def this() = this("1","today school")
}
