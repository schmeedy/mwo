package domain.state

case class GameState(
  mages: Set[Mage],
  round: GameRound,
  units: Set[GameUnit])