package com.today36524.school

import com.today36524.school.bean.{Clazz, Grade}
import com.today36524.school.util.ComputeUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(classOf[SpringRunner])
@SpringBootTest
class SchoolApplicationTests {
  @Test
  def contextLoads(): Unit = {
    ComputeUtil.showTop5Student(
      //Clazz("1","小一班",1,"1")
      g = Grade("1",2,2016,"1")
    )

    ComputeUtil.countLevels(
      g = Grade("1",2,2016,"1")
    )

    ComputeUtil.top20ofGrades(
      g = Grade("1",2,2016,"1")
    )
  }
}

object SchoolApplicationTests{
}
