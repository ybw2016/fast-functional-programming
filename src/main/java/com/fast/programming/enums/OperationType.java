package com.fast.programming.enums;

public enum OperationType {
    Open("Open", "打开"),
    Close("Close", "关闭"),
    Save("Save", "保存"),
    Edit("Edit", "编辑"),
    Undo("Undo", "撤销"),
    Redo("Redo", "重复-撤销"),
    Build("Build", "编译"),
    Debug("Debug", "调试");

    private final String value;
    private final String name;

    private OperationType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
