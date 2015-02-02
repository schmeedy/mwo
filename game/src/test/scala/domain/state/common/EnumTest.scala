package domain.state.common

import org.scalatest.FunSpec
import play.api.libs.json.{JsString, Json}

class EnumTest extends FunSpec {

  describe("Enum") {
    object IsEverythingOk extends Enum[IsEverythingOk]
    sealed trait IsEverythingOk extends IsEverythingOk.Value

    case object Yes extends IsEverythingOk
    case object No extends IsEverythingOk
    case object Maybe extends IsEverythingOk

    it("should be deserializable") {
      assert(Maybe == Json.parse("\"Maybe\"").as[IsEverythingOk])
      assert(Yes == Json.parse("\"Yes\"").as[IsEverythingOk])
    }

    it("should be serializable") {
      assert(Json.toJson(No) == JsString("No"))
    }
  }

}
