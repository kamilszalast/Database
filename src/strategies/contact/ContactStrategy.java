package strategies.contact;

import java.util.Arrays;
import java.util.List;

public class ContactStrategy {
    List<AbstractContactTypeStrategy> strategies = Arrays.asList(new JabberStrategy(), new PhoneStrategy(), new EmailStrategy());

    public int getValidContactType(String contact) {
        return strategies.stream()
                .filter(s1 -> s1.isValidContactType(contact))
                .findFirst()
                .map(s1 -> s1.getContactType())
                .orElse(0);
    }


}
