package io.vs.rkafka.common

case class Step(length: Float) {
  def + (other: Step): Step = Step(length + other.length)
}
