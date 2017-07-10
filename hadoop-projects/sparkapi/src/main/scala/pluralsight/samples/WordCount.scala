package pluralsight.samples

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

/**
  * Created by spanwar on 7/7/17.
  */

object WordCount {

  def main(args: Array[String]): Unit ={
    // create Spark context with Spark configuration
    val conf = new SparkConf().setAppName("WordCount App").setMaster("local[*]")
    conf.set("spark.driver.host","localhost")
    val sc = new SparkContext(conf)

    //word count logic
    //file:///Users/spanwar/Techno/development/myrepo/java-projects/hadoop-projects/sparkapi/data/input/sample.txt
    val input = if(args != null) args(0).toString else return
    //file:///Users/spanwar/Techno/development/myrepo/java-projects/hadoop-projects/sparkapi/data/output
    val output = if(args != null) args(1).toString else return

    val textFile = sc.textFile(input)
    val words = textFile.flatMap(line=>line.split(" "))
    val wordCount = words.map(word=>(word,1))
    val finalcount = wordCount.reduceByKey(_+_)
    finalcount.saveAsTextFile(output)
  }
}
