  def main(args: Array[String]): Unit = {

  val conf = new SparkConf().setAppName("CounterDemo").setMaster("local[*]")
  val sc = new SparkContext(conf)
    //val logFile = "C:/Big_data/readme.md"
  val spark = SparkSession.builder().appName(name = "TestApp").getOrCreate()
  val dataFile = spark.read.format("com.databricks.spark.csv").option("header", true).
    load("\\Users\\vitaly\\Desktop\\BigData\\russian_passenger_air_service_2.csv")dataFile
    .createOrReplaceTempView("Air_serv")

    //Найдем  аэропорты с наибольшим объемом оказанных услуг:
    spark.sql("SELECT Whole year, Airport name FROM Air_serv ORDER BY Whole year DESC").show()
    //Найдем  аэропорты с наибольшим объемом оказанных услуг за 2017 г.:
    spark.sql("SELECT Whole year = 2017, Airport name FROM Air_serv ORDER BY Whole year DESC").show()
    //Или посчитать объем оказанных услуг конкретного аэропорта за определенный период:
    spark.sql ("SELECT Whole year = 2017 FROM Demography WHERE Whole year=2017").show()

    spark.stop()



