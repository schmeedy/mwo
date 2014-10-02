package domain.common

trait Qualifier[-T] extends ((T) => Boolean) {
  def and[E <: T](other: Qualifier[E]): Qualifier[E] = Qualifier.and(List(this, other))

  def or[E <: T](other: Qualifier[E]): Qualifier[E] = Qualifier.or(List(this, other))
}

object Qualifier {
  def and[E](qs: Seq[Qualifier[E]]) = new Qualifier[E] {
    def apply(e: E) = qs.forall(_.apply(e))

    override def toString() = qs.mkString(" ")
  }

  def or[E](qs: Seq[Qualifier[E]]) = new Qualifier[E] {
    def apply(e: E) = qs.exists(_.apply(e))

    override def toString() = qs.mkString(" or ")
  }

  def not[E](q: Qualifier[E]) = new Qualifier[E] {
    def apply(e: E) = !q(e)

    override def toString() = s"not($q)"
  }
}