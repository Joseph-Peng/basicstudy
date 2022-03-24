package design.factory;

public class FactoryMethod {
}

interface Sender{
    double getRange();
}

class SMSSender implements Sender {

    @Override
    public double getRange() {
        return 0;
    }
}

class MailSender implements Sender {

    @Override
    public double getRange() {
        return 2;
    }
}

class SenderFactory{
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SMSSender();
    }

}