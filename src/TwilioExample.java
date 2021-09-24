/*
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class TwilioExample {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC1c459dc82ce9ffea6d4ede99cc3d761d";
    public static final String AUTH_TOKEN = "f0622958eb9014e2cdf769aa902bf72d";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+420735006245"),
                "MG640608718f4f42b826a6519d7079a26e",
                "Ahoy")
                .create();

        System.out.println(message.getSid());
    }
}
*/