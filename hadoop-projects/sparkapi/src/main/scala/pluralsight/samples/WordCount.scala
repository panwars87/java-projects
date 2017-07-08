package pluralsight.samples

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

/**
  * Created by spanwar on 7/7/17.
  */

object WordCount extends App {
  // create Spark context with Spark configuration
  val conf = new SparkConf().setAppName("IQ Simple Spark App").setMaster("local[*]")
  conf.set("spark.driver.host", "localhost")
  val sc = new SparkContext(conf)
  val rdd = sc.parallelize(Seq(1,2,3,4,5))
  println(rdd.count())
}
