package domain.state.meta

import domain.state.GameObject
import domain.state.common.Qualifier
import org.scalatest.FunSpec
import play.api.libs.json.{JsString, Json}

class GameTraitTest extends FunSpec {

  describe("Plain Trait") {
    it("should print it's name") {
      assert(Burnproof.toString == "Burnproof")
    }

    it("should be deserializable") {
      assert(Json.parse("\"Finite Life\"").as[ObjectTrait] == FiniteLife)
      assert(Json.parse("\"Passage Attacks\"").as[ObjectTrait] == PassageAttacks)
    }
  }

  describe("'X' Trait") {
    describe("when printed") {
      it("should have plus sign when included in the name") {
        assert(Magebind(1).toString == "Magebind +1")
      }

      it("should have no signs if they are missing in the name") {
        assert(Aegis(1).toString == "Aegis 1")
      }
    }

    it("should serialize to Json string") {
      assert(Json.toJson(Regenerate(2)) == JsString("Regenerate +2"))
    }

    it("should deserialize from Json string") {
      assert(Json.parse("\"Mana Drain +2\"").as[AttackTrait] == ManaDrain(2))
      assert(Json.parse("\"Aegis 2\"").as[ObjectTrait] == Aegis(2))
      assert(Json.parse("\"Piercing -1\"").as[AttackTrait] == Piercing(-1))
    }
  }

  describe("Attack Modifiers") {
    it("should print with plus sign for positive values") {
      assert(AttackTypeModifier(Melee, 2).toString == "Melee +2")
    }
  }

  describe("Attribute Modifiers") {
    it("should support negative values") {
      assert(AttributeModifier(Life, -1).toString == "Life -1")
    }

    it("should print with plus sign for positive values") {
      assert(AttributeModifier(Armor, 2).toString == "Armor +2")
    }
  }

  describe("Damage Type Modifiers") {
    it("should support negative values") {
      assert(DamageTypeModifier(Flame, -1).toString == "Flame -1")
    }

    it("should print with plus sign for positive values") {
      assert(DamageTypeModifier(Hydro, 2).toString == "Hydro +2")
    }
  }

  describe("Target Modifiers") {
    it("should support negative values") {
      assert(TargetModifier(GameObject withTrait Flying, -2).toString == "-2 vs. Flying")
    }

    it("should print with plus sign for positive values") {
      assert(TargetModifier(Qualifier.and(List(GameObject withTrait Corporeal, GameObject fromSpell (Spell ofType Creature))), 2).toString == "+2 vs. Corporeal Creature")
    }
  }

  describe("Immunity Traits") {
    it("should print with damage type prepended") {
      assert(Immunity(Flame).toString == "Flame Immunity")
    }
  }

  describe("Or Attack Trait") {
    it("should give options of multiple attack traits") {
      assert(OrAttack(List(Sweeping, Piercing(3))).toString == "Sweeping OR Piercing +3")
    }
  }

}
