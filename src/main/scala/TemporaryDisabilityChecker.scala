case class HighPriorityImmediatelyPayable(highRisk: HighPriority, noLongerThanRetirementPolicy: NoLongerThanRetirementPolicy,
                                      immediatePay: ImmediatePay) {
  def isSatisfiedBy(t: TemporaryDisability): Boolean = {
    highRisk.isSatisfiedBy(t) && noLongerThanRetirementPolicy.isSatisfiedBy(t) &&
      immediatePay.isSatisfiedBy(t)
  }
}