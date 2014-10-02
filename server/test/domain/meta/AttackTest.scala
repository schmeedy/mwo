package domain.meta

import org.scalatest.FunSpec

class AttackTest extends FunSpec {

  describe("Attack Effect") {
    describe("Gain Condition") {
      it("should be printed without digit with one marker") {
        assert(GainCondition(Stun).toString == "Stun")
      }

      it("should be printed with digit for marker count > 1") {
        assert(GainCondition(Burn, 2).toString == "2 Burn")
      }
    }

    describe("& Attack Effect") {
      it("should print all effects concatenated with '&'") {
        val effect = AndAttackEffect(List[AttackEffect](Push, GainCondition(Stun)))
        assert(effect.toString == "Push & Stun")
      }
    }
  }

}
