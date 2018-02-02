package com.exp.learning

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Hello world!
 *
 */
object App {

  def main(args: Array[String]): Unit ={
    println ("Executing main")
    val conf = new SparkConf().setAppName("Hive Test").setMaster("local[*]")
    conf.set("spark.driver.host", "localhost")
    val sc = new SparkContext(conf)

    val url="jdbc:mysql://cmhlddlkeedg02.expdev.local:10000/cmhdcdw"
    val prop = new java.util.Properties
    prop.setProperty("user", "adm-spanwar")
    prop.setProperty("password","q5EXP2017")

    val sqlContext = new org.apache.spark.sql.hive.HiveContext(sc)
    val people = sqlContext.read.jdbc(url, "dim_member", prop)

    //val myDataFrame = sqlContext.sql("select * from cmhdcdw.dim_member limit 10")
    people.show(5)

  }

}
