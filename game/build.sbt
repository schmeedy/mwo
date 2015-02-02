name := "mw-server"

version := "1.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("releases")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

val monocleVersion = "0.5.1"  // or "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "com.typesafe.play" %% "play-json" % "2.2.1",
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "com.github.julien-truffaut" %% "monocle-core"    % monocleVersion,
  "com.github.julien-truffaut" %% "monocle-generic" % monocleVersion,
  "com.github.julien-truffaut" %% "monocle-macro"   % monocleVersion,         // since 0.4.0
  "com.github.julien-truffaut" %% "monocle-law"     % monocleVersion % "test" // since 0.4.0
)
