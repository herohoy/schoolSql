package com.today36524.school.util

import java.io.FileInputStream
import java.util.Properties

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import wangzx.scala_commons.sql.RichDataSource


object ScalaSqlUtil {
  val dataSource: RichDataSource = {
    val dataSource: MysqlDataSource = new MysqlDataSource
    val properties = new Properties()
    val path = Thread.currentThread().getContextClassLoader
      .getResource("application.properties").getPath //文件要放到resource文件夹下
    properties.load(new FileInputStream(path))
    dataSource.setURL(properties.getProperty("spring.datasource.url"))
    dataSource.setUser(properties.getProperty("spring.datasource.username"))
    dataSource.setPassword(properties.getProperty("spring.datasource.password"))

    dataSource
  }
}
