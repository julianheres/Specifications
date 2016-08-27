import java.util.concurrent.TimeUnit

import org.joda.time.Days

trait NoLongerThanRetirementPolicy extends Specification[TemporaryDisability] {
  private val MAX_TEMP_DIS_TIMESPAN = TimeUnit.MILLISECONDS.convert(540, TimeUnit.DAYS)

  override def isSatisfiedBy(t: TemporaryDisability) = {
    Days.daysBetween(t.end.toInstant, t.beginning.toInstant).getDays < MAX_TEMP_DIS_TIMESPAN
  }
}

trait HighPriority extends Specification[TemporaryDisability] {
  override def isSatisfiedBy(t: TemporaryDisability) = {
    t.disease.description match {
      case "LIVER_CANCER" => true
      case "HIV" => true
      case _ => false
    }
  }
}

trait ImmediatePay extends Specification[TemporaryDisability] {
  override def isSatisfiedBy(t: TemporaryDisability) = {
    t.lawSuit.isDefined
  }
}