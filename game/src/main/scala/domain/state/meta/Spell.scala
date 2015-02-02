package domain.state.meta

import domain.state.common.Qualifier
import domain.state.common.Enum

case class Spell(
  name: String,
  version: Int,
  classification: SpellClassification,
  castingMeta: CastingMeta,
  traits: Seq[ObjectTrait])

case class SpellClassification(
  spellType: SpellType,
  subtypes: Seq[SpellSubtype],
  school: School,
  level: Int)

case class CastingMeta(
  cost: Int,
  actionType: ActionType,
  range: Range,
  target: SpellTarget)

object Spell {
  def ofType[E <: Spell](st: SpellType) = new Qualifier[E] {
    def apply(spell: E) = spell.classification.spellType == st

    override def toString() = st.toString
  }

  def withSubtype[E <: Spell](subtypes: SpellSubtype*) = new Qualifier[E] {
    def apply(spell: E) = subtypes.forall(spell.classification.subtypes.contains(_))

    override def toString() = subtypes.mkString(", ")
  }

  def ofSchool[E <: Spell](school: School) = new Qualifier[E] {
    def apply(spell: E) = spell.classification.school == school

    override def toString() = school.toString
  }

  def withTrait[E <: Spell](t: GameTrait) = new Qualifier[E] {
    def apply(spell: E) = spell.traits.contains(t)

    override def toString() = t.toString
  }
}

object SpellTarget {
  def apply(q: Qualifier[Spell]) = ObjectTarget(q)
}
sealed trait SpellTarget
case object ZoneTarget extends SpellTarget
case class ObjectTarget(q: Qualifier[Spell]) extends SpellTarget