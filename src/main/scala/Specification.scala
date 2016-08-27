trait Specification[T] {
  def isSatisfiedBy(t: T): Boolean
}
