/*
* Created by zampolit 20.09.2023
* It is used as a value in the map to store data in its fields
 */

package hexlet.code;

public class Data extends Object {
    private String status;
    private Object val1;
    private Object val2;

    public Data(String status, Object val1, Object val2) {
        this.status = status;
        this.val1 = val1;
        this.val2 = val2;
    }

    public String getStatus() {
        return status;
    }

    public Object getVal1() {
        return val1;
    }

    public Object getVal2() {
        return val2;
    }

    @Override
    public String toString() {
        String perfomance = "status: " + status;
        return perfomance;
    }
}
