package domain.state.meta

import domain.state.common

case class Attack(
  attackType: AttackType,
  damageType: Option[DamageType],
  attackDice: Int,
  traits: Set[AttackTrait]) {
}

object AttackType extends domain.state.common.Enum[AttackType]
sealed trait AttackType extends AttackType.Value
case object Melee extends AttackType
case object Ranged extends AttackType

object DamageType extends domain.state.common.Enum[DamageType]
sealed trait DamageType extends DamageType.Value
case object Flame extends DamageType
case object Hydro extends DamageType
case object Light extends DamageType
case object Lightning extends DamageType
case object Poison extends DamageType
case object Psychic extends DamageType
case object Wind extends DamageType

sealed trait AttackEffect
case object Push extends AttackEffect
case class GainCondition(condition: Condition, x: Int = 1) extends AttackEffect {
  require(x > 0, "number of condition markers has to be greater than 0")

  override def toString = (if (x > 1) x + " " else "") + condition.toString
}
case class AndAttackEffect(effects: List[AttackEffect]) extends AttackEffect {
  override def toString = effects.mkString(" & ")
}