package domain.meta

import domain.common.Enum

object ActionType extends Enum[ActionType]
sealed trait ActionType extends ActionType.Value
case object QuickAction extends ActionType
case object FullAction extends ActionType