/*
* Created by zampolit 20.09.2023
* It is used as a value in the map to store data in its fields
 */

package hexlet.code;

public class Data {
    private String status;
    private Object oldValue;
    private Object newValue;

    public Data(String status, Object val1, Object val2) {
        this.status = status;
        this.oldValue = val1;
        this.newValue = val2;
    }

    public final String getStatus() {
        return status;
    }

    public final Object getVal1() {
        return oldValue;
    }

    public final Object getVal2() {
        return newValue;
    }
}
