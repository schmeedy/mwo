package domain.state.common

import org.apache.commons.lang3.StringUtils.{join, splitByCharacterTypeCamelCase}
import play.api.libs.json._

trait Enum[A] { enumSelf: Enum[A] =>
  private var _values = List.empty[A]
  private var _valuesByStringVal = Map.empty[String, A]

  def name = enumSelf.getClass.getSimpleName.replace("$", "")

  /*
   * Product methods auto-generated for all case classes / objects
   */
  trait Value extends Product { self: A =>
    _values :+= this
    _valuesByStringVal = _valuesByStringVal.updated(toString, this)

    override def toString = {
      val enumNameTokens = splitByCharacterTypeCamelCase(name)
      // remove any enum value tokens that are part of the enum name
      val enumValueTokens = splitByCharacterTypeCamelCase(this.productPrefix).filter(!enumNameTokens.contains(_))
      enumValueTokens.mkString(" ")
    }
  }

  def values = _values

  implicit val readsEnum = new Reads[A] {
    override def reads(json: JsValue): JsResult[A] = json match {
      case JsString(strVal) =>
        _valuesByStringVal.get(strVal).map(JsSuccess(_))
          .getOrElse(JsError(s"No value of ${getClass.getSimpleName} found for '$strVal'."))
      case _ => JsError("Single String value expected for Enum deserialization.")
    }
  }

  implicit val writesEnum = new Writes[A] {
    override def writes(value: A): JsValue = JsString(value.toString)
  }
}
