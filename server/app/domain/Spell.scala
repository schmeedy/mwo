package domain

trait Spell {
  def matches(qualifier: SpellQualifier) = ???
}

trait SpellQualifier
