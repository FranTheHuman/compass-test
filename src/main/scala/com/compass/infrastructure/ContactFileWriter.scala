package com.compass.infrastructure

import com.compass.Accuracies

import java.io.{File, PrintWriter}

/**
 * Object that contains utility methods for writing results to a CSV file.
 */
object ContactFileWriter {

  /**
   * Writes the results to a CSV file.
   *
   * @param results List of results to write to the file
   */
  def writeResult(results: List[(Int, Int, Accuracies.Acurracies)]): Unit = {

    val csvFile = new File("src/main/resources/results.csv")
    val writer = new PrintWriter(csvFile)

    try {

      writer.println("ContactID,Source ContactID,Match Accuracy") // Write the header

      results.foreach { case (contactId, sourceContactId, accuracy) =>
        writer.println(s"$contactId,$sourceContactId,$accuracy") // Write each result to the file
      }

    } finally {

      writer.close()

    }

    println(s"Results written to ${csvFile.getAbsolutePath}")

  }

}
