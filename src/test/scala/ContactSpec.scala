import com.compass.Accuracies.*
import com.compass.Contact
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ContactSpec extends AnyWordSpec with Matchers {

  "Contact" should {

    val contact = Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St")

    "correctly initialize with provided values - ADDRESS" in {
      contact.address shouldBe "123 Main St"
    }

    "correctly initialize with provided values - CONTACTID" in {
      contact.contactId shouldBe 1
    }

    "correctly initialize with provided values - EMAIL" in {
      contact.email shouldBe "john.doe@example.com"
    }

    "correctly initialize with provided values - FIRSTNAME" in {
      contact.firstName shouldBe "John"
    }

    "correctly initialize with provided values - LASTNAME" in {
      contact.lastName shouldBe "Doe"
    }

    "correctly initialize with provided values - ZIPCODE" in {
      contact.zipCode shouldBe "12345"
    }

  }

  "Contact behaviors" should {

    "return High accuracy for matching contacts with same name and last name" in {
      val contact1 = Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St")
      val contact2 = Contact(2, "John", "Doe", "j.doe@example.com", "54321", "321 Elm St")
      Contact.getAccuracy(contact1, contact2) shouldBe High
    }

    "return High accuracy for matching contacts with same email" in {
      val contact1 = Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St")
      val contact2 = Contact(2, "Jane", "Smith", "john.doe@example.com", "54321", "321 Elm St")
      Contact.getAccuracy(contact1, contact2) shouldBe High
    }

    "return Medium accuracy for matching contacts with same address" in {
      val contact1 = Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St")
      val contact2 = Contact(2, "Jane", "Smith", "jane.smith@example.com", "54321", "123 Main St")
      Contact.getAccuracy(contact1, contact2) shouldBe Medium
    }

    "return Low accuracy for non-matching contacts" in {
      val contact1 = Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St")
      val contact2 = Contact(2, "Jane", "Smith", "jane.smith@example.com", "54321", "321 Elm St")
      Contact.getAccuracy(contact1, contact2) shouldBe Low
    }

    "correctly find potential matches between contacts" in {
      val contacts = List(
        Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St"),
        Contact(2, "John", "Doe", "j.doe@example.com", "54321", "321 Elm St"),
        Contact(3, "Jane", "Smith", "jane.smith@example.com", "67890", "321 Elm St")
      )
      val potentialMatches = Contact.findPotentialMatches(contacts)
      potentialMatches shouldBe List((1, 2, High), (1, 3, Low), (2, 3, Medium))
    }

  }

}
