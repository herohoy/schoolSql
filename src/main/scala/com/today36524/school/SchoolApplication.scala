package com.today36524.school


import com.today36524.school.bean.{Grade, School}
import com.today36524.school.dao.SchoolDao
import com.today36524.school.util.ScalaSqlUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody, RestController}
import wangzx.scala_commons.sql._
import scala.collection.JavaConverters

object SchoolApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[SchoolApplication], args.toString)
  }
}

@SpringBootApplication
@RestController
class SchoolApplication{
//  @Autowired
//  var schoolDao : SchoolDao = _
//
//  @RequestMapping(Array("/schoolList"))
//  @ResponseBody
//  def schoolList: java.util.Map[String, java.util.List[School]]
//  =
//    JavaConverters.mapAsJavaMap(
//     Map("schools" -> JavaConverters.seqAsJavaList(
//       schoolDao.findAllSchool
//     )
//  ))


  @RequestMapping(Array("/gradeList"))
  @ResponseBody
  def gradeList( schoolId:String): java.util.Map[String, java.util.List[Grade]]
  =
    JavaConverters.mapAsJavaMap(
      Map("grades" -> JavaConverters.seqAsJavaList(
        ScalaSqlUtil.dataSource.rows[Grade](
          s"select id,level,year,school_id from bean_grade where school_id = $schoolId")
      )
      ))

  @RequestMapping(Array("/"))
  def hello:String = "<h2>Hello World!</h2><b/><a href='/schoolList'>school</a>"


//  @Bean("")
//  def getDataSources():DataSource = {
//      val ds = new MysqlDataSource
//      ds.setURL(s"jdbc:mysql://127.0.0.1/test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull")
//      ds.setUser("root")
//      ds.setPassword("123456")
//      ds
//
//  }

}