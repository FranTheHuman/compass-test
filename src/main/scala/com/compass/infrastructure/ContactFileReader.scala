package com.compass.infrastructure

import com.compass.Contact

import scala.io.Source
import scala.util.{Try, Using}

/**
 *  Object that contains utility methods for reading contacts from a CSV file.
 */
object ContactFileReader {

  /**
   * Reads contacts from a CSV file and returns a list of contacts.
   * @param filePath Path to the CSV file
   * @return List of contacts read from the CSV file
   */
  def readContactsFromCsv(filePath: String): List[Contact] = {

    // using Scala 2.13's Using to automatically close the resource
    Using(Source.fromFile(filePath)) { source =>

      // Read the lines from the file and convert them to a list
      // Skip the header and convert to list
      val data: List[String] = source.getLines().drop(1).toList

      // Map each line to a Contact object
      data map { line =>
        
        val attributes = line.split(",").map(_.trim)

        Contact(
          contactId = Try(attributes.headOption.getOrElse("0").toInt).getOrElse(0),
          firstName = attributes.lift(1).getOrElse(""),
          lastName = attributes.lift(2).getOrElse(""),
          email = attributes.lift(3).getOrElse(""),
          zipCode = attributes.lift(4).getOrElse(""),
          address = attributes.lift(5).getOrElse("")
        )
      }

    }.recover {

      case e: Exception => throw new RuntimeException(s"Error reading contacts from file $filePath", e)

    }.get
    
  }

}
