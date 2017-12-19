package com.today36524.school

import com.today36524.school.bean.{Grade, School}
import com.today36524.school.util.ScalaSqlUtil
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody, RestController}

import scala.collection.JavaConverters

object SchoolApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[SchoolApplication], args.toString)
  }
}

@SpringBootApplication
@RestController
class SchoolApplication{
  @RequestMapping(Array("/"))
  def hello:String = "<h2>Hello World!</h2><b/><a href='/schoolList'>school</a>"

  @RequestMapping(Array("/schoolList"))
  @ResponseBody
  def schoolList//: java.util.Map[String, java.util.List[School]]
  =
    JavaConverters.mapAsJavaMap(
     Map("schools" -> JavaConverters.seqAsJavaList(
          ScalaSqlUtil.dataSource.rows[School]("select id,name from bean_school")
     )
        ))


  @RequestMapping(Array("/gradeList"))
  @ResponseBody
  def gradeList(schoolId:String)//: java.util.Map[String, java.util.List[School]]
  =
    JavaConverters.mapAsJavaMap(
      Map("grades" -> JavaConverters.seqAsJavaList(
        ScalaSqlUtil.dataSource.rows[Grade](
          s"select id,level,year,school_id from bean_grade where school_id = $schoolId")
      )
      ))
}