package by.belstu.it.yarchynskaya;

import java.util.Objects;

public class WrapperString {
    private String ex;

    public WrapperString(String ex) {
        this.ex = ex;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(ex, that.ex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ex);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "ex='" + ex + '\'' +
                '}';
    }
    public void replace () {
        System.out.println("оригинальный replace");
    }
}
