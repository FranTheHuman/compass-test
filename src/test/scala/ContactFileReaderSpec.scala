import com.compass.Contact
import com.compass.infrastructure.ContactFileReader
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ContactFileReaderSpec extends AnyWordSpec with Matchers {

  "ContactFileReader" should {
    "correctly read contacts from a CSV file" in {
      val filePath = "src/test/resources/contacts.csv"
      val contacts = ContactFileReader.readContactsFromCsv(filePath)
      contacts should have size 3
      contacts.head shouldBe Contact(1001, "C", "F", "mollis.lectus.pede@outlook.net", "449-6990", "Tellus. Rd.")
      contacts(1) shouldBe Contact(1002, "C", "French", "mollis.lectus.pede@outlook.net", "39746", "449-6990 Tellus. Rd.")
      contacts(2) shouldBe Contact(1003, "Ciara", "F", "non.lacinia.at@zoho.ca", "39746", "")
    }

    "handle empty fields gracefully" in {
      val filePath = "src/test/resources/contacts_empty_fields.csv"
      val contacts = ContactFileReader.readContactsFromCsv(filePath)
      contacts should have size 3
      contacts.head shouldBe Contact(1001, "C", "F", "mollis.lectus.pede@outlook.net", "449-6990", "Tellus. Rd.")
      contacts(1) shouldBe Contact(1002, "C", "French", "mollis.lectus.pede@outlook.net", "39746", "449-6990 Tellus. Rd.")
      contacts(2) shouldBe Contact(1003, "Ciara", "F", "non.lacinia.at@zoho.ca", "39746", "")
    }

    "handle missing file gracefully" in {
      val filePath = "nonexistent_file.csv"
      val thrown = intercept[RuntimeException] {
        ContactFileReader.readContactsFromCsv(filePath)
      }
      thrown.getMessage shouldBe s"Error reading contacts from file $filePath"
    }
  }
}