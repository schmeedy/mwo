package domain

trait GameObject extends Spell {
  def traits: List[ObjectTrait]
}

object GameObject {
  def withTrait(t: ObjectTrait) = new Qualifier[GameObject] {
    def apply(go: GameObject) = go.traits.contains(t)

    def description = t.toString
  }
}

