package com.compass

import com.compass.Accuracies._

/**
 * Represents a contact with the following attributes:
 * @param contactId Unique identifier for the contact
 * @param firstName First name of the contact
 * @param lastName Last name of the contact
 * @param email Email address of the contact
 * @param zipCode Zip code of the contact
 * @param address Address of the contact
 */
case class Contact(
        contactId: Int,
        firstName: String,
        lastName: String,
        email: String,
        zipCode: String,
        address: String
)

/**
 * Companion object for the Contact class that contains the behavior.
 */
object Contact {

    /**
     * Compares two contacts and returns the accuracy of the match.
     * @param contact1 First contact to compare
     * @param contact2 Second contact to compare
     * @return The accuracy of the match between the two contacts
     */
    def getAccuracy(contact1: Contact, contact2: Contact): Acurracies =
        (contact1, contact2) match {
            case (Contact(_, name1, lastName1, _, _, _), Contact(_, name2, lastName2, _, _, _)) if name1 == name2 && lastName1 == lastName2 => High
            case (Contact(_, _, _, email1, _, _), Contact(_, _, _, email2, _, _)) if email1 == email2                                       => High

            case (Contact(_, _, _, _, _, address1), Contact(_, _, _, _, _, address2)) if address1 == address2 => Low
            case (Contact(_, _, lastName1, _, _, _), Contact(_, _, lastName2, _, _, _)) if lastName1 == lastName2 => Low

            case _  => NoneAcc
        }

  /**
   * Finds potential matches between contacts by comparing each pair of contacts.
   * @param contacts List of contacts to compare
   * @return
   */
    def findPotentialMatches(contacts: List[Contact]): List[(Int, Int, Acurracies)] =
        for {
            contact1 <- contacts
            contact2 <- contacts
            if contact1.contactId < contact2.contactId
        } yield (contact1.contactId, contact2.contactId, getAccuracy(contact1, contact2))

}
