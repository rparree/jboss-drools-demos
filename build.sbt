name := "drools-demos"

version := "1.0"

scalaVersion := "2.10.2"

resolvers += "JBoss third party releases repository" at "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"

libraryDependencies += "com.sun.xml.bind" % "jaxb-xjc" % "2.2.4-1"

 libraryDependencies ++= {
  Seq("drools-compiler", "drools-core","drools-jsr94", "drools-decisiontables", "knowledge-api")
    .map("org.drools" % _ % "5.2.0.Final")
 }


