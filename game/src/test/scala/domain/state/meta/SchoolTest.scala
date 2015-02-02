package domain.state.meta

import org.scalatest.FunSpec
import play.api.libs.json.{JsString, Json}

class SchoolTest extends FunSpec {

  describe("School enum") {
    it("should serialize to Json string") {
      assert(Json.toJson(ArcaneSchool) == JsString("Arcane"))
      assert(Json.toJson(NatureSchool) == JsString("Nature"))
    }

    it("should deserialize from Json string") {
      assert(Json.parse("\"Arcane\"").as[School] == ArcaneSchool)
      assert(Json.parse("\"Nature\"").as[School] == NatureSchool)
    }
  }

}
