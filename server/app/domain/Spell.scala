package domain

trait Spell {
  def spellType: SpellType
}

object Spell {
  def ofType[E <: Spell](st: SpellType) = new Qualifier[E] {
    def apply(spell: E) = spell.spellType == st
  }
}

object SpellType extends Enum[SpellType]
sealed trait SpellType extends SpellType.Value
case object AttackSpell extends SpellType
case object Conjuration extends SpellType
case object Creature extends SpellType
case object Enchantment extends SpellType
case object Equipment extends SpellType
case object Incantation extends SpellType