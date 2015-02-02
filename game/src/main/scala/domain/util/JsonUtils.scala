package domain.util

import play.api.libs.json.Reads

object JsonUtils {
  implicit class ReadsExt[E](val r: Reads[E]) {
    def downcast[F <: E]: Reads[F] = r.map(x => x.asInstanceOf[F])
    def upcast[F >: E]: Reads[F] = r.map(x => x)
  }
}
