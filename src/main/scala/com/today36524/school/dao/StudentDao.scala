package com.today36524.school.dao

import com.today36524.school.bean.Student
import com.today36524.school.util.ScalaSqlUtil
import wangzx.scala_commons.sql._

object StudentDao {
  def findStudentsByClass(classId:String): List[Student] = {
    ScalaSqlUtil.dataSource.rows[Student](
      s"select id,name,sex,class_id from bean_student where class_id = $classId order by id")
  }
  def findStudentById(id:String): Student = {
    ScalaSqlUtil.dataSource.row[Student](
      s"select id,name,sex,class_id from bean_student where id = $id"
    ).get
  }

  def findStudentRowsByClass(classId:String): List[Row] = ScalaSqlUtil.dataSource.rows[Row](
    s"""
      select s.id,name,s.sex ,
      case s.sex when 1 then '男' when 2 then '女' else '未定义' end sex_cn,
      s.class_id,sc.yuwen,sc.shuxue,sc.yingyu,sc.total ,sc.average
      from bean_student s LEFT JOIN (
        select
        studentId
        ,MAX(case lessonName when 'yuwen' then point else 0 end) yuwen
        ,MAX(case lessonName when 'shuxue' then point else 0 end) shuxue
        ,MAX(case lessonName when 'yingyu' then point else 0 end) yingyu
        ,SUM(point) total
        ,AVG(point) average
        from midl_score where studentId in(select id from bean_student where class_id = $classId)
        GROUP BY studentId
      ) sc on sc.studentId = s.id where s.class_id = $classId order by id
    """
  )
}
