package org.dynamicproxy;

public class BigStar implements Star {
    private String name;


    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "BigStar{name = " + name + "}";
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name + "正在跳" + name);
        return "谢谢大家";
    }

    @Override
    public String dance(String name) {
        System.out.println(this.name + "正在唱" + name);
        return "谢谢大家";
    }
}
