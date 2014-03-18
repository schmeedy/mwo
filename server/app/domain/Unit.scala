package domain

class Unit extends Spell {

}

object ObjectAttribute extends Enum[ObjectAttribute]
sealed trait ObjectAttribute extends ObjectAttribute.Value
case object Armor extends ObjectAttribute
case object Channeling extends ObjectAttribute
case object Life extends ObjectAttribute