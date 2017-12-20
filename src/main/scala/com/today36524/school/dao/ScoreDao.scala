package com.today36524.school.dao

import com.today36524.school.bean.Score
import com.today36524.school.util.ScalaSqlUtil
import wangzx.scala_commons.sql.Row

object ScoreDao {
   def findAllScores = ScalaSqlUtil.dataSource.rows[Score](
     "select studentId,lessonName,point from midl_score")

  def findScoresByStudentId(studentId:String) = ScalaSqlUtil.dataSource.rows[Score](
    s"select studentId,lessonName,point from midl_score where studentId=$studentId")

  def findScoreByStudentIdAndLessonName(studentId:String,lessonName:String) =
    ScalaSqlUtil.dataSource.row[Score](
      s"""select studentId,lessonName,point from midl_score
         where studentId=$studentId and lessonName=$lessonName""")

//  def statisticStuAch() = {
//    val achList = ScalaSqlUtil.dataSource.rows[Row](
//      s"""
//      select s.id,s.name,s.sex ,
//         case s.sex when 1 then '男' when 2 then '女' else '未定义' end sex_cn,
//         CONCAT(case g.level WHEN 2 then '小学' WHEN 3 then '初中'
//          when 4 then '高中' else '其他学段' END
//         ,CAST(g.`year` AS CHAR),'级',c.name) class_full_name
//         ,sc.yuwen,sc.shuxue,sc.yingyu ,sc.total ,sc.average
//         from bean_student s LEFT JOIN (
//           select
//           studentId
//           ,MAX(case lessonName when 'yuwen' then point else 0 end) yuwen
//           ,MAX(case lessonName when 'shuxue' then point else 0 end) shuxue
//           ,MAX(case lessonName when 'yingyu' then point else 0 end) yingyu
//           ,SUM(point) total
//           ,AVG(point) average
//           from midl_score where studentId in(select id from bean_student where class_id = 2)
//           GROUP BY studentId
//         ) sc on sc.studentId = s.id
//         left join bean_clazz c on c.id = s.class_id
//         left join bean_grade g on g.id = c.grade_id
//         where s.class_id = 2 order by id
//    """
//    )
//  }
}
