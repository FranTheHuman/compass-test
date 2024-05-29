package com.compass

import com.compass.Accuracies.NoneAcc
import com.compass.infrastructure.{ContactFileReader, ContactFileWriter}

object Main extends App {

  try {

    val contacts: List[Contact]                          = ContactFileReader.readContactsFromCsv("src/main/resources/contacts.csv")
    val matches: List[(Int, Int, Accuracies.Acurracies)] = Contact.findPotentialMatches(contacts)
    println(contacts)
    ContactFileWriter.writeResult(matches)

    val header    = f"${"ContactID"}%-15s ${"Source ContactID"}%-20s ${"Match Accuracy"}%-15s"
    val separator = "-" * header.length

    println(header)
    println(separator)

    matches
      .filter(!_._3.eq(NoneAcc)) // Filter out the NoneAcc matches
      .foreach {
        case (contactId1, contactId2, accuracy) =>
          println(f"$contactId1%-15s $contactId2%-20s $accuracy%-15s")
      }

  } catch {

    case e: Exception =>
      println(s"An error occurred: ${e.getMessage}")

  }

}
