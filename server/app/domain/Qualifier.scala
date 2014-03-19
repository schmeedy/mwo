package domain

trait Qualifier[-T] extends ((T) => Boolean) {
  def description: String

  override def toString() = description
}

object Qualifier {
  def and[E](qs: List[Qualifier[E]]) = new Qualifier[E] {
    def apply(e: E) = qs.forall(_.apply(e))

    def description = qs.mkString(" ")
  }
}