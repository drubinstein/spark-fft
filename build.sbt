name := "spark-fft"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

initialCommands := "import src.main.scala.(complex, fft)"