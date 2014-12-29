package domain.state

import domain.state.meta.{Spell, ObjectTrait}
import domain.state.common.Qualifier

trait GameObject {
  def spell: Spell
  def traits: Set[ObjectTrait]
}

object GameObject {
  def withTrait(t: ObjectTrait) = new Qualifier[GameObject] {
    def apply(go: GameObject) = go.traits.contains(t)

    override def toString() = t.toString
  }

  def fromSpell(spellQualifier: Qualifier[Spell]) = new Qualifier[GameObject] {
    def apply(go: GameObject) = spellQualifier.apply(go.spell)

    override def toString() = spellQualifier.toString()
  }
}

