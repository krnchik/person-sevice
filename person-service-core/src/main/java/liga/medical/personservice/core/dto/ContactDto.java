package liga.medical.personservice.core.dto;

import liga.medical.personservice.core.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private String phoneNumber;
    private String email;
    private String profileLink;

    public Contact convertToContact() {
        Contact contact = new Contact();
        contact.setEmail(getEmail());
        contact.setPhoneNumber(getPhoneNumber());
        contact.setProfileLink(getProfileLink());
        return contact;
    }

    public static ContactDto fromContact(Contact contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setEmail(contact.getEmail());
        contactDto.setPhoneNumber(contact.getPhoneNumber());
        contactDto.setProfileLink(contact.getProfileLink());
        return contactDto;
    }
}
