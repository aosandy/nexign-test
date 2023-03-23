package task;

public enum CallType {
    OUTGOING(1),
    INCOMING(2);

    private final int index;

    CallType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
