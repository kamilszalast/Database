package strategies.contact;

import java.util.Arrays;
import java.util.List;

public class ContactStrategy {
    private final List<AbstractContactTypeStrategy> strategies = Arrays.asList(new JabberStrategy(), new PhoneStrategy(), new EmailStrategy());

    public int getValidContactType(String contact) {
        return strategies.stream()
                .filter(s1 -> s1.isValidContactType(contact))
                .findFirst()
                .map(AbstractContactTypeStrategy::getContactType)
                .orElse(0);
    }


}
