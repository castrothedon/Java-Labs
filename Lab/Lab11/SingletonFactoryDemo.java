package Lab.Lab11;



interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private final String institution = "Example University";

    private AppConfig() {}

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getInstitution() {
        return institution;
    }
}

class NotificationFactory {
    public static Notification create(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SmsNotification();
            default:
                throw new IllegalArgumentException(
                    "Unknown notification type: " + type
                );
        }
    }
}

public class SingletonFactoryDemo {
    public static void main(String[] args) {
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();

        System.out.println(
            "Same instance? " + (a == b) + " -> " + a.getInstitution()
        );

        NotificationFactory.create("email").send("Lab 11 is open");
        NotificationFactory.create("sms").send("Lab 11 is open");
    }
}
