package com.today36524.school

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{RestController,RequestMapping}

object SchoolApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[SchoolApplication], args.toString)
  }
}

@SpringBootApplication
@RestController
class SchoolApplication{
  @RequestMapping(Array("/hello"))
  def hello:String = "<h2>Hello World!</h2>"
}