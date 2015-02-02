package domain.state

import domain.state.meta._
import monocle.syntax._

case class UnitId(uuid: String)

case class GameUnit (
  id: UnitId,
  spell: Spell,
  stats: UnitStats,
  traits: Set[ObjectTrait],
  conditions: Set[ConditionMarker],
  zone: Zone,
  controller: MageId) extends GameObject

case class ConditionMarker(uuid: String, condition: Condition)