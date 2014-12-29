package domain.event.progress

import domain.event.GameEvent
import domain.state.{PhaseType, MageId, GameRound, GameState}

trait GameStateEvent extends GameEvent {
  def apply(game: GameState) = game.copy(round = apply(game.round))

  def apply(round: GameRound): GameRound
}

case class GameRoundChanged(roundNumber: Int) extends GameStateEvent {
  def apply(round: GameRound) = round.copy(roundNumber = roundNumber)
}

case class InitiativeChanged(player: MageId) extends GameStateEvent {
  def apply(round: GameRound) = round.copy(initiative = player)
}

case class GamePhaseChanged(phase: PhaseType) extends GameStateEvent {
  def apply(round: GameRound) = round.copy(phase = phase)
}