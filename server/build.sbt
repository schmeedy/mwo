name := "mw-server"

version := "1.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"
)

val monocleVersion = "0.5.1"  // or "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.github.julien-truffaut"  %%  "monocle-core"    % monocleVersion,
  "com.github.julien-truffaut"  %%  "monocle-generic" % monocleVersion,
  "com.github.julien-truffaut"  %%  "monocle-macro"   % monocleVersion,         // since 0.4.0
  "com.github.julien-truffaut"  %%  "monocle-law"     % monocleVersion % "test" // since 0.4.0
)

play.Project.playScalaSettings
