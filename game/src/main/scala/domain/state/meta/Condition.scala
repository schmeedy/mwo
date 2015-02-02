package domain.state.meta

import domain.state.common.Enum

object Condition extends Enum[Condition] {
  Burn; Bleed; Cripple; Rot; Slam; Stun; Weak
}
sealed trait Condition extends Condition.Value
case object Burn extends Condition
case object Bleed extends Condition
case object Cripple extends Condition
case object Rot extends Condition
case object Slam extends Condition
case object Stun extends Condition
case object Weak extends Condition