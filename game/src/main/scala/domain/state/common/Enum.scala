package domain.state.common

trait Enum[A] {
  trait Value { self: A =>
    _values :+= this
  }
  private var _values = List.empty[A]
  def values = _values
}
