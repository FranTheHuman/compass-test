package com.compass

/**
 * Contains the possible accuracies of a match between two contacts.
 */
object Accuracies {

  /**
   * Represents the possible accuracies of a match between two contacts. */
  sealed trait Acurracies

  case object High extends Acurracies

  case object Low extends Acurracies

  case object NoneAcc extends Acurracies

}


