package domain

import domain.meta._
import monocle.syntax._

case class Unit (
  uuid: String,
  spell: Spell,
  stats: UnitStats,
  traits: Set[ObjectTrait],
  conditions: Set[ConditionMarker],
  zone: Zone,
  controller: Player,
  hasActed: Boolean) extends GameObject

case class ConditionMarker(uuid: String, condition: Condition)