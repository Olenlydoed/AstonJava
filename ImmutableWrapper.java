class MutableClass {
    private int value;

    public MutableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public final class ImmutableWrapper {

    private final MutableClass data;

    public ImmutableWrapper(MutableClass data) {
        this.data = new MutableClass(data.getValue());
    }

    public int getValue() {
        return data.getValue();
    }

    public static void main(String[] args) {
        MutableClass mutable = new MutableClass(10);
        ImmutableWrapper wrapper = new ImmutableWrapper(mutable);

        mutable.setValue(100);
        System.out.println(wrapper.getValue()); // 10
    }
}