package pluralsight.samples

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by spanwar on 7/10/17.
  */
object SampleTest {
  def main(args : Array[String]): Unit ={
    val conf = new SparkConf().setAppName("IQ Simple Spark App").setMaster("local[*]")
    conf.set("spark.driver.host", "localhost")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(Seq(1,2,3,4,5))
    println(rdd.count())
  }
}
