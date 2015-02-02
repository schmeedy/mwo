package domain.state.meta

import domain.state.common.Enum

object School extends Enum[School] {
  ArcaneSchool; DarkSchool; HolySchool; MindSchool; NatureSchool
  WarSchool; AirSchool; EarthSchool; FireSchool; WaterSchool
}
sealed trait School extends School.Value
// major schools
case object ArcaneSchool extends School
case object DarkSchool extends School
case object HolySchool extends School
case object MindSchool extends School
case object NatureSchool extends School
case object WarSchool extends School
// elemental (minor) schools
case object AirSchool extends School
case object EarthSchool extends School
case object FireSchool extends School
case object WaterSchool extends School

