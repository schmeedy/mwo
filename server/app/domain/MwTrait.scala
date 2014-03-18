package domain

trait MwTrait extends SpellQualifier {
  def name: String
}

abstract class PlainTrait(val name: String) extends MwTrait {
  override def toString = name
}

abstract class XTrait(val name: String, x: Int) extends MwTrait {
  override def toString = {
    val baseName = name.replaceAll("[\\+\\/\\-X]", "").trim
    val sign = if (x > 0 && (name.contains("+") || name.contains("-"))) "+" else ""
    s"$baseName $sign$x"
  }
}

// We have object traits ...

sealed trait ObjectTrait extends MwTrait
abstract class PlainObjectTrait(name: String) extends PlainTrait(name) with ObjectTrait
abstract class XObjectTrait(name: String, x: Int) extends XTrait(name, x) with ObjectTrait

case class Aegis(x: Int) extends XObjectTrait("Aegis X", x)
case class AttackTypeModifier(attackType: AttackType, x: Int) extends ObjectTrait {
  def name = s"$attackType +/- X"

  override def toString = s"$attackType ${if (x > 0) "+" else ""}$x"
}
case class AttributeModifier(attribute: ObjectAttribute, x: Int) extends ObjectTrait {
  def name = s"$attribute +/- X"

  override def toString = s"$attribute ${if (x > 0) "+" else ""}$x"
}
case object BlocksLoS extends PlainObjectTrait("Blocks Line of Sight")
case class Bloodthirsty(x: Int) extends XObjectTrait("Bloodthirsty X", x)
case object Burnproof extends PlainObjectTrait("Burnproof")
case object Climbing extends PlainObjectTrait("Climbing")
case object Corporeal extends PlainObjectTrait("Corporeal")
case class DamageTypeModifier(damageType: DamageType, x: Int) extends ObjectTrait {
  def name = s"$damageType +/- X"

  override def toString = s"$damageType ${if (x > 0) "+" else ""}$x"
}
case object DamageBarrier extends PlainObjectTrait("Damage Barrier")
case object Elusive extends PlainObjectTrait("Elusive")
case object Extendable extends PlainObjectTrait("Extendable")
case object Familiar extends PlainObjectTrait("Familiar")
case object Fast extends PlainObjectTrait("Fast")
case object FiniteLife extends PlainObjectTrait("Finite Life")
case object Flying extends PlainObjectTrait("Flying")
case class Immunity(against: DamageType) extends ObjectTrait {
  def name = against + " Immunity"

  override def toString = name
}
case object Incorporeal extends PlainObjectTrait("Incorporeal")
case object Legendary extends PlainObjectTrait("Legendary")
case object Living extends PlainObjectTrait("Living")
case class Magebind(x: Int) extends XObjectTrait("Magebind +X", x)
case object Nonliving extends PlainObjectTrait("Nonliving")
case object PassageAttacks extends PlainObjectTrait("Passage Attacks")
case object PassageBlocked extends PlainObjectTrait("Passage Blocked")
case object Pest extends PlainObjectTrait("Pest")
case class Regenerate(x: Int) extends XObjectTrait("Regenerate +X", x)
case object Resilient extends PlainObjectTrait("Resilient")
case object Restrained extends PlainObjectTrait("Restrained")

// ... and attack traits ...

sealed trait AttackTrait extends MwTrait
abstract class PlainAttackTrait(name: String) extends PlainTrait(name) with AttackTrait
abstract class XAttackTrait(name: String, x: Int) extends XTrait(name, x) with AttackTrait

case object Counterstrike extends PlainAttackTrait("Counterstrike")
case object Defrost extends PlainAttackTrait("Defrost")
case object Doublestrike extends PlainAttackTrait("Doublestrike")
case object Ethereal extends PlainAttackTrait("Ethereal")
case class ManaDrain(x: Int) extends XAttackTrait("Mana Drain +X", x)
case class ManaTransfer(x: Int) extends XAttackTrait("Mana Transfer +X", x)
case class OrAttack(options: List[AttackTrait]) extends AttackTrait {
  def name = "OR"

  override def toString = options.map(_.toString).mkString(" OR ")
}
case class Piercing(x: Int) extends XAttackTrait("Piercing +X", x)
case object Reach extends PlainAttackTrait("Reach")
case object Sweeping extends PlainAttackTrait("Sweeping")
case class TargetModifier(target: SpellQualifier, x: Int) extends AttackTrait {
  def name = s"+/- X vs. $target"

  override def toString = s"${if (x > 0) "+" else ""}$x vs. $target"
}
case object Tripplestrike extends PlainAttackTrait("Tripplestrike")
case object Unavoidable extends PlainAttackTrait("Unavoidable")
case object Vampiric extends PlainAttackTrait("Vampiric")
case object ZoneAttack extends PlainAttackTrait("Zone Attack")

// ... and combined traits

case class Charge(x: Int) extends XTrait("Charge", x) with ObjectTrait with AttackTrait