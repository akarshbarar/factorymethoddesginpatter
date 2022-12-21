package factorymethod;

public class NotificationFactory {
	enum Channel {
		SMS,
		EMAIL,
		PUSH
	}
    public Notification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        Channel myChannel = null;
        if (channel.equals("SMS")) myChannel = Channel.SMS;
        if (channel.equals("EMIAL")) myChannel = Channel.EMAIL;
        if (channel.equals("PUSH")) myChannel = Channel.PUSH;

        switch (myChannel) {
        case SMS:
            return new SMSNotification();
        case EMAIL:
            return new EmailNotification();
        case PUSH:
            return new PushNotification();
        default:
            throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}