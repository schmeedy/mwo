package domain

case class Attack(
  attackType: AttackType,
  damageType: Option[DamageType],
  attackDice: Int,
  traits: Set[AttackTrait]) {
}

object AttackType extends Enum[AttackType]
sealed trait AttackType extends AttackType.Value
case object Melee extends AttackType
case object Ranged extends AttackType

object DamageType extends Enum[DamageType]
sealed trait DamageType extends DamageType.Value
case object Flame extends DamageType
case object Hydro extends DamageType
case object Light extends DamageType
case object Lightning extends DamageType
case object Poison extends DamageType
case object Psychic extends DamageType
case object Wind extends DamageType