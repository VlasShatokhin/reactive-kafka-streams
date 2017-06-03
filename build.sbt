import BuildConfiguration._

lazy val `reactive-kafka-streams` = (project in file("."))
  .configure(rootProfile)
  .aggregate(service, client)

lazy val service = project
  .dependsOn(common)
  .configure(serviceProfile)

lazy val client = project
  .dependsOn(common)
  .configure(clientProfile)

lazy val common = project
  .configure(commonProfile)