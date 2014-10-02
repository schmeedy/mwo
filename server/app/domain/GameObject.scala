package domain

import domain.meta.{Spell, ObjectTrait}
import domain.common.Qualifier

trait GameObject {
  def uuid: String
  def spell: Spell
  def traits: Seq[ObjectTrait]
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

