package com.today36524.school.util

import java.text.DecimalFormat

import com.today36524.school.bean.{Clazz, Grade, School, Student}
import com.today36524.school.dao.{ClassDao, GradeDao, StudentDao}
import wangzx.scala_commons.sql.Row

import scala.collection.mutable.ListBuffer

object ComputeUtil {
  private val decimalFormat : DecimalFormat = new DecimalFormat("#.##")

  /**
    * 学生成绩列表
    * @param c 班级
    * @param g 年级
    * @param s 学校
    * @return 一个List
    */
  private def studentAchList(c:Clazz = null,g:Grade = null,s:School = null) = {
    val stuList:ListBuffer[Row] = new ListBuffer[Row]
    if (c!=null) stuList ++= StudentDao.findStudentRowsByClass(c.id)
    if (g!=null)
      for(gclazz <- ClassDao.findClassesByGrade(g.id))
        stuList ++= StudentDao.findStudentRowsByClass(gclazz.id)
    if(s!=null)
    {
      for(sgrs <- GradeDao.findGradesBySchool(s.id))
        for(scls <- sgrs.getClasses) stuList ++= StudentDao.findStudentRowsByClass(scls.id)
    }
    stuList.toList
  }

  /**
    * 每班前五名及他们的平均分
    * @param c 班级
    * @param g 年级
    * @param s 学校
    * @return
    */
  def showTop5Student(c:Clazz = null,g:Grade = null,s:School = null) = {
    val stuList:List[Row] = studentAchList(c,g,s)

    println("语文前五名统计中：")
    for (r<-stuList.sortWith{case(s1,s2) => s1.get[Int]("yuwen")>s2.get[Int]("yuwen") }.take(5))
      println(r.get[String]("name")+"的语文成绩是"+r.get[Int]("yuwen"))
    println("数学前五名统计中：")
    for (r<-stuList.sortWith{case(s1,s2) => s1.get[Int]("shuxue")>s2.get[Int]("shuxue") }.take(5))
      println(r.get[String]("name")+"的数学成绩是"+r.get[Int]("shuxue"))
    println("英语前五名统计中：")
    for (r<-stuList.sortWith{case(s1,s2) => s1.get[Int]("yingyu")>s2.get[Int]("yingyu") }.take(5))
      println(r.get[String]("name")+"的英语成绩是"+r.get[Int]("yingyu"))
    println("总分前五名统计中：")
    for (r<-stuList.sortWith{case(s1,s2) => s1.get[Int]("total")>s2.get[Int]("total") }.take(5))
      println(r.get[String]("name")+"的总分成绩是"+r.get[Int]("total")
        +"，平均分"+decimalFormat.format(r.get[Double]("average")))
  }

  /**
    * 统计各科成绩优良数及占比
    * @param c
    * @param g
    * @param s
    */
  def countLevels(c:Clazz = null,g:Grade = null,s:School = null) = {
    val stuList:List[Row] = studentAchList(c,g,s)

    println("统计各等级人数及比例：本次统计样本共"+stuList.size+"人，其中：")

    println("语文成绩：")
    val you = stuList.filter(_.get[Int]("yuwen")>=90).size
    println("优：人数"+you+"，占比"+decimalFormat.format(you * 100/stuList.size)+"%")
    val liang = stuList.filter(_.get[Int]("yuwen")>=75).filter(_.get[Int]("yuwen")<90).size
    println("良：人数"+liang+"，占比"+decimalFormat.format(liang * 100/stuList.size)+"%")
    val pass = stuList.filter(_.get[Int]("yuwen")>=60).filter(_.get[Int]("yuwen")<75).size
    println("及格：人数"+pass+"，占比"+decimalFormat.format(pass * 100/stuList.size)+"%")
    val nopass = stuList.filter(_.get[Int]("yuwen")<60).size
    println("不及格：人数"+nopass+"，占比"+decimalFormat.format(nopass * 100/stuList.size)+"%")

    println("数学成绩：")
    val yousx = stuList.filter(_.get[Int]("shuxue")>=90).size
    println("优：人数"+yousx+"，占比"+decimalFormat.format(yousx * 100/stuList.size)+"%")
    val liangsx = stuList.filter(_.get[Int]("shuxue")>=75).filter(_.get[Int]("shuxue")<90).size
    println("良：人数"+liangsx+"，占比"+decimalFormat.format(liangsx * 100/stuList.size)+"%")
    val passsx = stuList.filter(_.get[Int]("shuxue")>=60).filter(_.get[Int]("shuxue")<75).size
    println("及格：人数"+passsx+"，占比"+decimalFormat.format(passsx * 100/stuList.size)+"%")
    val nopasssx = stuList.filter(_.get[Int]("shuxue")<60).size
    println("不及格：人数"+nopasssx+"，占比"+decimalFormat.format(nopasssx * 100/stuList.size)+"%")

    println("英语成绩：")
    val youyy = stuList.filter(_.get[Int]("yingyu")>=90).size
    println("优：人数"+youyy+"，占比"+decimalFormat.format(youyy * 100/stuList.size)+"%")
    val liangyy = stuList.filter(_.get[Int]("yingyu")>=75).filter(_.get[Int]("yingyu")<90).size
    println("良：人数"+liangyy+"，占比"+decimalFormat.format(liangyy * 100/stuList.size)+"%")
    val passyy = stuList.filter(_.get[Int]("yingyu")>=60).filter(_.get[Int]("yingyu")<75).size
    println("及格：人数"+passyy+"，占比"+decimalFormat.format(passyy * 100/stuList.size)+"%")
    val nopassyy = stuList.filter(_.get[Int]("yingyu")<60).size
    println("不及格：人数"+nopassyy+"，占比"+decimalFormat.format(nopassyy * 100/stuList.size)+"%")
  }

  def top20ofGrades(g:Grade = null,s:School = null) = {
    val stuList:List[Row] = studentAchList(g=g,s=s)

    val gn = if(g!=null) g.getName + "年级" else ""
    val sgn : StringBuilder = new StringBuilder
    if(s!=null)
      {
        sgn.append((if(g!=null) "以及" else "") + "学校"+s.getName+"中的各个年级：")
        for(i <- s.getGrades.indices) sgn.append(if(i!=0) "," else "" +s.getGrades(i).getName + "年级")
      }
    val gnn = if(gn.length>0 || sgn.length>0) gn + sgn.toString + " 的总分前20名如下：" else ""

    println(gnn)

    for (r<-stuList.sortWith{case(s1,s2) => s1.get[Int]("total")>s2.get[Int]("total") }.take(20))
      println(r.get[String]("name")+"的总分成绩是"+r.get[Int]("total")
        +"，平均分"+decimalFormat.format(r.get[Double]("average")))

    val map1 = stuList.sortWith { case (s1, s2) => s1.get[Int]("yuwen") > s2.get[Int]("yuwen") }
      .groupBy(_.get[String]("sex_cn"))
    val map2 = stuList.sortWith{case(s1,s2) => s1.get[Int]("shuxue")>s2.get[Int]("shuxue") }
      .groupBy(_.get[String]("sex_cn"))
    val map3 = stuList.sortWith{case(s1,s2) => s1.get[Int]("yingyu")>s2.get[Int]("yingyu") }
      .groupBy(_.get[String]("sex_cn"))
    println(
      if(map1.get("男").size>0)
      "语文男生状元是"+map1.get("男").get(0).get[String]("name")
        +"，分数为"+map1.get("男").get(0).get[Int]("yuwen") + "\r\n"
      else "")
    println (if(map1.get("女").size>0)
      "语文女生状元是"+map1.get("女").get(0).get[String]("name")
      +"，分数为"+map1.get("女").get(0).get[Int]("yuwen") + "\r\n"
      else "")
    println(
      if(map2.get("男").size>0)
        "数学男生状元是"+map2.get("男").get(0).get[String]("name")
          +"，分数为"+map2.get("男").get(0).get[Int]("shuxue") + "\r\n"
      else "")
    println (if(map2.get("女").size>0)
        "数学女生状元是"+map2.get("女").get(0).get[String]("name")
          +"，分数为"+map2.get("女").get(0).get[Int]("shuxue") + "\r\n"
      else "")
    println(
      if(map3.get("男").size>0)
        "英语男生状元是"+map3.get("男").get(0).get[String]("name")
          +"，分数为"+map3.get("男").get(0).get[Int]("yingyu") + "\r\n"
      else "")
        println (if(map3.get("女").size>0)
        "英语女生状元是"+map3.get("女").get(0).get[String]("name")
          +"，分数为"+map3.get("女").get(0).get[Int]("yingyu") + "\r\n"
      else "")

  }
}
