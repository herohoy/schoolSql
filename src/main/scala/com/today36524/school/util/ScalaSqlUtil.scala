package com.today36524.school.util

import java.io.FileInputStream
import java.util.Properties
import javax.sql.DataSource

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.today36524.school.util.ScalaSqlUtil.dataSource
import org.springframework.context.annotation.{Bean, Configuration}
import wangzx.scala_commons.sql._



object ScalaSqlUtil {

  val dataSource: DataSource = {

    val properties = new Properties()
    val path = Thread.currentThread().getContextClassLoader
      .getResource("application.properties").getPath //文件要放到resource文件夹下
    properties.load(new FileInputStream(path))
    val dataSource: DataSource = new MysqlDataSource{
      this.url = properties.getProperty("spring.datasource.url")
      this.user = properties.getProperty("spring.datasource.username")
      this.password = properties.getProperty("spring.datasource.password")
    }

    dataSource
  }

}

//@Configuration
//class ScalaSqlUtil{
//
//  @Bean(Array("scalaDataSource"))
//  def getDataSource : DataSource = {
//    val properties = new Properties()
//    val path = Thread.currentThread().getContextClassLoader
//      .getResource("application.properties").getPath //文件要放到resource文件夹下
//    properties.load(new FileInputStream(path))
//    val dataSource = new MysqlDataSource{
//      this.url = properties.getProperty("spring.datasource.url")
//      this.user = properties.getProperty("spring.datasource.username")
//      this.password = properties.getProperty("spring.datasource.password")
//    }
//
//    dataSource
//  }
//}
