package domain

trait Unit extends GameObject {

}

object ObjectAttribute extends Enum[ObjectAttribute]
sealed trait ObjectAttribute extends ObjectAttribute.Value
case object Armor extends ObjectAttribute
case object Channeling extends ObjectAttribute
case object Life extends ObjectAttribute

object Condition extends Enum[Condition]
sealed trait Condition extends Condition.Value
case object Burn extends Condition
case object Bleed extends Condition
case object Cripple extends Condition
case object Rot extends Condition
case object Slam extends Condition
case object Stun extends Condition
case object Weak extends Condition