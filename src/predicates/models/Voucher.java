package predicates.models;

public class Voucher {

    private int value;

    private Voucher(int value) {
        this.value = value;
    }

    public static Voucher of(int value) {
        return new Voucher(value);
    }

    public static Voucher none() {
        return new Voucher(-1);
    }
}
