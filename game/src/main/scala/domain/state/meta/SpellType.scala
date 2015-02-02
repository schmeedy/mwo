package domain.state.meta

import domain.state.common.Enum

object SpellType extends Enum[SpellType] {
  AttackSpell; Conjuration; Creature; Enchantment; Equipment; Incantation
}
sealed trait SpellType extends SpellType.Value
case object AttackSpell extends SpellType
case object Conjuration extends SpellType
case object Creature extends SpellType
case object Enchantment extends SpellType
case object Equipment extends SpellType
case object Incantation extends SpellType
