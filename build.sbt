name := "drools-demos"

version := "2.0"

scalaVersion := "2.11.2"

sbtVersion := "0.13.5"

val droolsVersion = "6.0.1.Final"

libraryDependencies += "com.sun.xml.bind" % "jaxb-xjc" % "2.2.4-1"

libraryDependencies ++= {
  "org.kie" % "kie-api" % droolsVersion ::
    List("drools-compiler", "drools-core", "drools-jsr94", "drools-decisiontables", "knowledge-api")
      .map("org.drools" % _ % droolsVersion)
}

val classesJarLocation = "/usr/lib/jvm/java-7-oracle/lib/tools.jar"

fullClasspath in Runtime += Attributed.blank(file(classesJarLocation))