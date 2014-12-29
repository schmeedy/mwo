package domain.state.meta

import domain.state.common.Qualifier

object SpellRepository {

  private val qCreature: Qualifier[Spell] = Spell ofType Creature
  private val qConjuration: Qualifier[Spell] = Spell ofType Conjuration
  private val qCreatureOrConjuration: Qualifier[Spell] = qCreature or qConjuration
  private val qCorporealCreature: Qualifier[Spell] = qCreature and (Spell withTrait Corporeal)

  val allSpells = Set(
    Spell("Evade", 1, SpellClassification(Incantation, Seq(Command), WarSchool, 1), CastingMeta(3, QuickAction, 0 to 2, SpellTarget(qCorporealCreature)), Seq()),
    Spell("Fireball", 1, SpellClassification(AttackSpell, Seq(FlameSpell), FireSchool, 2), CastingMeta(6, QuickAction, 0 to 2, SpellTarget(qCreatureOrConjuration)), Seq())
  )

}
