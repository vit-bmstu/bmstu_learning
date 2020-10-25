import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Phones {
    public static void main(String[] args) {
        PhonesList phoneList = new PhonesList();
        addPhoneList(phoneList);


        phoneList.ShowCityTimeUnderValue(60);
        phoneList.ShowPhonesUseIntercity();
        PhonesList sortPhoneList;
        sortPhoneList=phoneList.sortPhoneList();
        System.out.println("Сведения об абонентах в алфавитном порядке:");
        sortPhoneList.printPhonelist();

    }

    public static void addPhoneList(PhonesList phoneList) {
        phoneList.addPhoneList(new Phone("Баранов", "Олег", "Иванович", 150467887863690L, 100, 50, 1000, 100));
        phoneList.addPhoneList(new Phone("Сидоров", "Иван", "Петрович", 119338934889750L, 200, 100, 100, 20000));
        phoneList.addPhoneList(new Phone("Бобчинская", "Ольга", "Владимировна", 939908453736346L, 300, 150, 5000, 23444));
        phoneList.addPhoneList(new Phone("Коновалов", "Олег", "Егорович", 783400770797464L, 400, 200, 7777, 50));
        phoneList.addPhoneList(new Phone("Белый", "Антон", "Платонович", 983643622083780L, 500, 250, 0, 320));
        phoneList.addPhoneList(new Phone("Скоробогатько", "Ирина", "Александровна", 845982235567799L, 60, 125, 12345, 7000));
        phoneList.addPhoneList(new Phone("Морозов", "Антон", "Максимович", 603095181535640L, 600, 125, 900, 0));


    }

}

class Phone {
    private static int idCount = 0;

    private int id;
    private String name1;
    private String name2;
    private String name3;
    private long card;
    private double debit;
    private double credit;
    private long oncityTimer;
    private long intercityTimer;

    public Phone(String name1, String name2, String name3, long card, double debit, double credit, long oncityTimer, long intercityTimer) {
        setId();
        setName1(name1);
        setName2(name2);
        setName3(name3);
        setCard(card);
        setDebit(debit);
        setCredit(credit);
        setOncityTimer(oncityTimer);
        setIntercityTimer(intercityTimer);
    }

    public Phone(String name1, String name2, String name3, long cardNo) {
        setId();
        setName1(name1);
        setName2(name2);
        setName3(name3);
        setCard(card);
    }

    public Phone(String name1, String name2, String name3, long cardNo, double debit, double credit) {
        setId();
        setName1(name1);
        setName2(name2);
        setName3(name3);
        setCard(card);
        setDebit(debit);
        setCredit(credit);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        this.id = ++idCount;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        checkString(name1);
        this.name1 = name1;
    }

    private void checkString(String string) {
        if (string == null || string.equals("")) {
            throw new IllegalArgumentException("Value is empty!!!");
        }
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        checkString(name2);
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        checkString(name3);
        this.name3 = name3;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        checkLong(card);
        this.card = card;
    }

    private void checkLong(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Wrong Number!!!");
        }
    }

    private void checkTime(long seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Wrong Number!!!");
        }
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        checkDouble(debit);
        this.debit = debit;
    }

    private void checkDouble(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Wrong amount!!!");
        }
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        checkDouble(credit);
        this.credit = credit;
    }

    public long getOncityTimer() {
        return oncityTimer;
    }

    public void setOncityTimer(long oncityTimer) {
        checkTime(oncityTimer);
        this.oncityTimer = oncityTimer;
    }

    public long getIntercityTimer() {
        return intercityTimer;
    }

    public void setIntercityTimer(long intercityTimer) {
        checkTime(intercityTimer);
        this.intercityTimer = intercityTimer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("id=").append(id);
        sb.append(", name1='").append(name1).append('\'');
        sb.append(", name2='").append(name2).append('\'');
        sb.append(", name3='").append(name3).append('\'');
        sb.append(", card=").append(card);
        sb.append(", debit=").append(debit);
        sb.append(", credit=").append(credit);
        sb.append(", oncityTimer=").append(oncityTimer);
        sb.append(", intercityTimer=").append(intercityTimer);
        sb.append('}');
        return sb.toString();
    }
}

class PhonesList {
    private List<Phone> phoneList = new ArrayList<>();

    public void addPhoneList(Phone phone) {
        this.phoneList.add(phone);
    }

    public void printPhonelist() {
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }

    public void ShowCityTimeUnderValue(long second) {
        System.out.println("Абоненты, у которых время внутригородских разговоров превышает > " + second + " sec.:");
        for (Phone phone : phoneList) {
            if (phone.getOncityTimer() > second) {
                System.out.println(phone);
            }
        }
    }

    public void ShowPhonesUseIntercity() {
        System.out.println("Абоненты, которые пользовались междугородной связью:");
        for (Phone phone : phoneList) {
            if (phone.getIntercityTimer() > 0) {
                System.out.println(phone);
            }
        }
    }

    public PhonesList sortPhoneList() {
        List<Phone> custlist = new ArrayList<>(phoneList);
        Collections.sort(custlist, new Comparator<Phone>() {
            @Override
            public int compare(Phone cust1, Phone cust2) {
                return cust1.getName1().compareToIgnoreCase(cust2.getName1());
            }
        });
        PhonesList sortPhoneList = new PhonesList();
        for (Phone phone : custlist) {
            sortPhoneList.addPhoneList(phone);
        }
        return sortPhoneList;
    }

}
