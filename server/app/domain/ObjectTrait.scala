package domain

sealed trait ObjectTrait {

  def name: String

  def value: Option[Int]

}

class PlainObjectTrait(val name: String) extends ObjectTrait {
  def value = None

  override def toString = name
}

class ParametricObjectTrait(val name: String, private val x: Int) extends ObjectTrait {
  def value = Some(x)

  override def toString = {
    val baseName = name.replaceAll("[\\+\\/\\-X]", "").trim
    val sign = if (x > 0 && (name.contains("+") || name.contains("-"))) "+" else ""
    s"$baseName $sign$x"
  }
}

case class Aegis(x: Int) extends ParametricObjectTrait("Aegis X", x)

case class Armor(x: Int) extends ParametricObjectTrait("Armor +/- X", x)

case class BlocksLoS() extends PlainObjectTrait("Blocks Line of Sight")

case class Bloodthirsty(x: Int) extends ParametricObjectTrait("Bloodthirsty X", x)

case class Burnproof() extends PlainObjectTrait("Burnproof")

case class Channeling(x: Int) extends ParametricObjectTrait("Channeling +/- X", x)

case class Climbing() extends PlainObjectTrait("Climbing")

case class Corporeal() extends PlainObjectTrait("Corporeal")

case class DamageBarrier() extends PlainObjectTrait("Damage Barrier")

case class Elusive() extends PlainObjectTrait("Elusive")

case class Extendable() extends PlainObjectTrait("Extendable")

case class Familiar() extends PlainObjectTrait("Familiar")

case class Fast() extends PlainObjectTrait("Fast")

case class FiniteLife() extends PlainObjectTrait("Finite Life")

case class Flying() extends PlainObjectTrait("Flying")

case class Incorporeal() extends PlainObjectTrait("Incorporeal")

case class Legendary() extends PlainObjectTrait("Legendary")

case class Life(x: Int) extends ParametricObjectTrait("Life +/- X", x)

case class Living() extends PlainObjectTrait("Living")

case class Magebind(x: Int) extends ParametricObjectTrait("Magebind +X", x)

case class Melee(x: Int) extends ParametricObjectTrait("Melee +X", x)

case class Nonliving() extends PlainObjectTrait("Nonliving")

case class PassageAttacks() extends PlainObjectTrait("Passage Attacks")

case class PassageBlocked() extends PlainObjectTrait("Passage Blocked")

case class Pest() extends PlainObjectTrait("Pest")

case class PoisonImmunity() extends PlainObjectTrait("Poison Immunity")

case class PsychicImmunity() extends PlainObjectTrait("Psychic Immunity")

case class Ranged(x: Int) extends ParametricObjectTrait("Ranged +X", x)

case class Regenerate(x: Int) extends ParametricObjectTrait("Regenerate +X", x)

case class Resilient() extends PlainObjectTrait("Resilient")

case class Restrained() extends PlainObjectTrait("Restrained")

// To be continued...

object Test extends App {
  println(Aegis(2))
  println(Melee(3))
  println(Life(-3))
  println(PsychicImmunity())
  println(Ranged(2))
}


