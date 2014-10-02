package domain.meta

case class Zone(x: Int, y: Int) {
  def distanceTo(z: Zone) = Math.abs(x - z.x) + Math.abs(y - z.y)
}
