package pluralsight.samples

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by spanwar on 7/11/17.
  */
object SampleRDD {
  def main(args: Array[String]): Unit ={
    // 1.RDD = Resilient Distributed Dataset
    // 2.DAG
    // 3.Transformations - map, filter, etc
    // 4.Actions -- collect, count, reduce

    val conf = new SparkConf().setAppName("Sample RDD App").setMaster("local[*]")
    conf.set("spark.driver.host", "localhost")
    val sc = new SparkContext(conf)


  }
}
