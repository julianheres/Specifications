import org.joda.time.DateTime
import org.scalatest.FunSuite

class NaiveTest extends FunSuite {

  test("Is a high risk immediately payable") {
    val td1 = TemporaryDisability(DateTime.now().withTimeAtStartOfDay(),
      DateTime.now().plusDays(12), Disease("ET45", "LIVER_CANCER", "Liver Cancer"),
      Some( LawSuit(DateTime.now().minusDays(3), DateTime.now().plusMonths(24), "Columbia")) )
  }
}
