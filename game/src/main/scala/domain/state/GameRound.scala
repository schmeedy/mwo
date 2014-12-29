package domain.state

import domain.state.common.Enum

case class GameRound(
  roundNumber: Int,
  initiative: MageId,
  phase: PhaseType)

object PhaseType extends Enum[PhaseType]
sealed trait PhaseType extends PhaseType.Value

// Ready Stage
case object InitiativePhase extends PhaseType
case object ResetPhase extends PhaseType
case object ChannelingPhase extends PhaseType
case object UpkeepPhase extends PhaseType
case object PlanningPhase extends PhaseType
case object DeploymentPhase extends PhaseType

// Action Stage
case object FirstQuickcastPhase extends PhaseType
case object ActionPhase extends PhaseType
case object FinalQuickcastPhase extends PhaseType


