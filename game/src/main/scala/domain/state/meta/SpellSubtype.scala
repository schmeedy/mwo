package domain.state.meta

import domain.state.common.Enum

object SpellSubtype extends Enum[SpellSubtype]
trait SpellSubtype extends SpellSubtype.Value
case object Animal extends SpellSubtype
case object Command extends SpellSubtype
case object Demon extends SpellSubtype
case object FlameSpell extends SpellSubtype
case object Soldier extends SpellSubtype
