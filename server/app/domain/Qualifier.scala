package domain

trait Qualifier[-T] extends ((T) => Boolean)

object Qualifier {
  def and[E](qs: List[Qualifier[E]]) = new Qualifier[E] {
    def apply(e: E) = qs.forall(_.apply(e))

    override def toString() = qs.mkString(" ")
  }
}